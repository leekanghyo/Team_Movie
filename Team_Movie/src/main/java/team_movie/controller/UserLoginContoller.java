package team_movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team_movie.model.UserBean;
import team_movie.model.UserDao;

@Controller
public class UserLoginContoller { 

	private static final String command = "userLogin.tm";
	private static final String getPage = "body/user/userLogin";
	private static final String gotoPage ="redirect:/main.tm";
	
	@Autowired
	UserDao userDao;
	
	//main���� login ��ư�� Ŭ�� ���� ��
	@RequestMapping(value=command, method = RequestMethod.GET)
	public String doActionGet(){
		return getPage;
	}
	
	//userLogin.jsp ���� �α��� ��ư Ŭ�� ���� ��
	@RequestMapping(value=command , method= RequestMethod.POST)
	public ModelAndView doActionPost(
			UserBean userBean,
			HttpSession session,
			HttpServletResponse response
			) throws IOException{
		ModelAndView mav = new ModelAndView();
		
		System.out.println("UserLogin.jsp���� �α��ι�ư Ŭ��");
		System.out.println("userBean.getUsid():"+userBean.getUsid());
		UserBean login = this.userDao.GetData(userBean.getUsid());
		//userDao.userLoginSelect(userBean);
		System.out.println("���̵����� : "+login);
		
		PrintWriter writer;
		response.setContentType("text/html;charset=UTF-8"); 
		writer = response.getWriter();

		if( login == null ){
			writer.println("<script type='text/javascript'>");
			writer.println("alert('�Է��Ͻ� ���̵�� �������� �ʽ��ϴ�.');");
			writer.println("history.back();"); 
			writer.println("</script>");
			writer.flush(); 
			return new ModelAndView( getPage ) ;

		}else{
			if(userBean.getUsid().equals(login.getUsid())&& userBean.getUpw().equals(login.getUpw()))
			{
				session.setAttribute("loginfo", login.getUname());
				mav.setViewName(gotoPage);// �α��� ���� ����������
				
			}else{
				writer = response.getWriter();
				writer.println("<script type='text/javascript'>");
				writer.println("alert('�Է��Ͻ� ��й�ȣ �߸��Ǿ����ϴ�.');");
				writer.println("history.back();"); 
				writer.println("</script>");
				writer.flush();
				
				return new ModelAndView( getPage );//�α��� ���� userLogin.jsp
			}
		}
		return mav;
	}
}
