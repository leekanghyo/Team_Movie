package team_movie.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team_movie.model.UserBean;
import team_movie.model.UserDao;

@Controller
public class UserFindPwController {

	private final String command = "findPw.tm";
	private final String getPage = "body/user/findPw";
	private final String gotoPage = "body/user/findPwCheck";


	@Autowired 
	UserDao userDao;

	//login���� ��й�ȣ ã�� Ŭ��������
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doActionGet(){
		return getPage;
	}

	//findPw.jsp���� ��� ��ȣ ã�� ��ư�� Ŭ�� ���� ��
	@RequestMapping(value=command , method= RequestMethod.POST)
	public ModelAndView doActionPost(
			UserBean userBean,
			HttpServletResponse response,
			HttpServletRequest request) throws IOException{
		System.out.println("findPw.jsp���� ��� ��ȣ ã�� ��ư�� Ŭ��");

		String yy= request.getParameter("yy");
		String mm=request.getParameter("mm");
		String dd=request.getParameter("dd");
		String date = yy+"-"+mm+"-"+dd;
		Date ubirth = Date.valueOf(date);
		userBean.setUbirth(ubirth);

		System.out.println("userBean.getUsid() :"+userBean.getUsid());
		System.out.println("userBean.getUname() :"+userBean.getUname());
		System.out.println("userBean.getUbirth() :"+userBean.getUbirth());

		ModelAndView mav = new ModelAndView();

		UserBean findPw = this.userDao.GetPwData(userBean);
		System.out.println("findPw : "+ findPw);
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8"); 
		writer = response.getWriter();

		if( findPw == null ){
			writer.println("<script type='text/javascript'>");
			writer.println("alert('�Է��Ͻ� ID�� ȸ�������� �������� �ʽ��ϴ�.');");
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
				writer.println("alert('�Է��Ͻ� �̸��� �߸��Ǿ����ϴ�.');");
				writer.println("history.back();"); 
				writer.println("</script>");
				writer.flush();

				return new ModelAndView( getPage );//�α��� ���� userLogin.jsp
			}else if(!userBean.getUbirth().equals(findPw.getUbirth())){

				writer.println("<script type='text/javascript'>");
				writer.println("alert('�Է��Ͻ� ��������� �߸��Ǿ����ϴ�.');");
				writer.println("history.back();"); 
				writer.println("</script>");
				writer.flush();

				return new ModelAndView( getPage );//�α��� ���� userLogin.jsp
			
			}
		}
		return mav;
	}
}
