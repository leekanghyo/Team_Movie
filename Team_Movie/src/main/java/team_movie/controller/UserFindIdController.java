package team_movie.controller;



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
public class UserFindIdController {
	
	private static final String command = "findId.tm";
	private static final String getPage = "body/user/findId";
	private static final String gotoPage ="redirect:/main.tm";
	
	@Autowired 
	UserDao userDao;
	
	//main���� lonin ��ư�� Ŭ�� ���� ��
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doActionGet(){
		return getPage;
	} 
	
	//findId.jsp���� ���̵�ã�� ��ư�� Ŭ�� ���� ��
	@RequestMapping(value=command , method= RequestMethod.POST)
	public ModelAndView doActionPost(
						UserBean userBean,
						HttpServletResponse response,
						HttpServletRequest request) throws IOException{
		System.out.println("findId.jsp���� ���̵�ã�� ��ư�� Ŭ��");
		 
		String yy= request.getParameter("yy");
		String mm=request.getParameter("mm");
		String dd=request.getParameter("dd");
		String date = yy+"-"+mm+"-"+dd;
		Date ubirth = Date.valueOf(date);
		userBean.setUbirth(ubirth);
		
		System.out.println("userBean.getUname() :"+userBean.getUname());
		System.out.println("userBean.getUbirth() :"+userBean.getUbirth());
		
		ModelAndView mav = new ModelAndView();
		UserBean findId = this.userDao.GetIdData(userBean);
		
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8"); 
		writer = response.getWriter();

		if( findId == null ){
			writer.println("<script type='text/javascript'>");
			writer.println("alert('�Է��Ͻ� �̸��� �������� �ʽ��ϴ�.');");
			writer.println("history.back();"); 
			writer.println("</script>");
			writer.flush(); 
			return new ModelAndView( getPage ) ;

		}else{
			if(userBean.getUsid().equals(findId.getUsid())&& userBean.getUpw().equals(findId.getUpw()))
			{
				writer = response.getWriter();
				writer.println("<script type='text/javascript'>");
				writer.println("alert('ã���ô� ���̵��"+findId.getUsid()+"�Դϴ�.');");
				writer.println("history.back();"); 
				writer.println("</script>");
				mav.setViewName(gotoPage);// �α��� ���� ����������
				 
			}else{
				writer = response.getWriter();
				writer.println("<script type='text/javascript'>");
				writer.println("alert('�Է��Ͻ� ������ �߸��Ǿ����ϴ�.');");
				writer.println("history.back();"); 
				writer.println("</script>");
				writer.flush();
				
				return new ModelAndView( getPage );//�α��� ���� userLogin.jsp
			}
		}
		
		return mav;
	}
	
}