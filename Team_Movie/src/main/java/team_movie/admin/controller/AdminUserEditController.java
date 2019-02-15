package team_movie.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminUserEditController {
	
	private static final String command ="adminUserEdit.tm";
	private static final String getPage = "body/admin/adminUserEdit";
	
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionGet(){
		System.out.println("admin controller");
		
		
		return getPage;
	}
	
}
