package team_movie.user.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import team_movie.model.MembershipBean;
import team_movie.model.MembershipDao;
import team_movie.model.UserBean;
import team_movie.model.UserDao;
 
@Controller
public class UserMembershipBuyController {
	private final String command="mShipBuyForm.tm";
	private final String command2="mShipBuy.tm";
	private final String getPage="body/user/MShipBuyForm";
	@Autowired
	@Qualifier("myMembership")
	MembershipDao membershipDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value=command ,method=RequestMethod.GET)
	public String doActionGet(Model model){
		System.out.println("�������");
		List<MembershipBean> membershipList = new ArrayList<MembershipBean>();
		membershipList = membershipDao.GetMemberShipList();
		model.addAttribute("membershipList",membershipList);
		
		return getPage;
	} 
	
	@RequestMapping(value=command2 ,method=RequestMethod.GET)
	public String doActionGet(
			@RequestParam(value="mbsnum",required=true) int mbsnum,
			HttpSession session
			){
		System.out.println("mbsnum : "+ mbsnum);
		System.out.println("usid : "+ session.getAttribute("usid"));
		String usid =(String)session.getAttribute("usid");
		MembershipBean msBean= membershipDao.GetMemberShip(mbsnum);
		
		System.out.println(msBean.getMbsnum());
		System.out.println(msBean.getMbsname());
		System.out.println(msBean.getMbsperiod());
		System.out.println(msBean.getMbsprice());
		
		
		UserBean userBean = new UserBean();
	    Timestamp nowTime = new Timestamp(System.currentTimeMillis()); 
		Calendar cal = Calendar.getInstance(); 
		cal.setTimeInMillis(nowTime.getTime()); 
		cal.add(Calendar.DATE, msBean.getMbsperiod()); 
		Timestamp afterTime = new Timestamp(cal.getTime().getTime());
		
		System.out.println("nowTime :" +nowTime);
		System.out.println("afterTime :"+afterTime);
		
		if(msBean.getMbsnum()!=0){
			System.out.println("msBean.getMbsnum()!=0");
			System.out.println("usid 123 :"+ usid);
		
			userBean.setUsid(usid);
			userBean.setUgrade("2");
			userBean.setUupend(afterTime);
			userBean.setUupstart(nowTime);
			
			int cnt =0;
			cnt =userDao.UpdateMembership(userBean);
		
		}
		
		return getPage;
	}
}