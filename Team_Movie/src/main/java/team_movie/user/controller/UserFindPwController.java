package team_movie.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team_movie.model.GenreBean;
import team_movie.model.GenreDao;
import team_movie.model.UserBean;
import team_movie.model.UserDao;

@Controller
public class UserFindPwController {

	private final String command = "findPw.tm";
	private final String getPage = "body/user/findIdPw";
	private final String gotoPage = "body/user/findPwCheck";


	@Autowired 
	UserDao userDao;
	@Autowired
	GenreDao genreDao;
	//login���� ��й�ȣ ã�� Ŭ��������
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doActionGet(){
		return getPage;
	}

	//findPw.jsp���� ��� ��ȣ ã�� ��ư�� Ŭ�� ���� ��
	@RequestMapping(value=command , method= RequestMethod.POST)
	public ModelAndView doActionPost(
			@RequestParam(value="usid") String usid,
			@RequestParam(value="uname") String uname,
			@RequestParam(value="ubirth" ,required =false) String ubirth,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException{
		System.out.println("findPw.jsp���� ��� ��ȣ ã�� ��ư�� Ŭ��");

		UserBean userBean = new UserBean();
		
		
		userBean.setUname(uname);
		userBean.setUsid(usid);
		
		Date ub = null;
		
		if(ubirth != ""){
			ub = Date.valueOf(ubirth);
			userBean.setUbirth(ub);
		}

	

		ModelAndView mav = new ModelAndView();
		//genre������
		List<GenreBean> genreList = null;
		genreList = genreDao.getGenreList();
		mav.addObject("genreList", genreList);
		
		UserBean findPw = this.userDao.GetPwData(userBean);
		System.out.println("findPw : "+ findPw);
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8"); 
		writer = response.getWriter();

		if( findPw == null ){
			writer.println("<script type='text/javascript'>");
			writer.println("alert('ID�� �߸��Ǿ����ϴ�.');");
			writer.println("history.back();"); 
			writer.println("</script>");
			writer.flush(); 
			return new ModelAndView( getPage ) ;

		}else{
			if(userBean.getUsid().equals(findPw.getUsid())
					&& userBean.getUbirth().equals(findPw.getUbirth())
					&& userBean.getUname().equals(findPw.getUname()))
			{
				System.out.println("pwã�� ����");
				mav.addObject("findPw",findPw.getUpw());
				mav.setViewName(gotoPage);

			}else if(!userBean.getUname().equals(findPw.getUname())){

				writer.println("<script type='text/javascript'>");
				writer.println("alert('�̸��� �߸��Ǿ����ϴ�.');");
				writer.println("history.back();"); 
				writer.println("</script>");
				writer.flush();

				return new ModelAndView( getPage );//�α��� ���� userLogin.jsp
			}else if(!userBean.getUbirth().equals(findPw.getUbirth())){

				writer.println("<script type='text/javascript'>");
				writer.println("alert('��������� �߸��Ǿ����ϴ�.');");
				writer.println("history.back();"); 
				writer.println("</script>");
				writer.flush();

				return new ModelAndView( getPage );//�α��� ���� userLogin.jsp

			}
		}
		return mav;
	}
}
