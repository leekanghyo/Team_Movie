package team_movie.model;

import java.util.List;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myUserDao")
public class UserDao {
	public static final String namespace="team_movie.model.UserBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	//ȸ������
	public int userInsert(UserBean userBean) {
		
		int cnt = sqlSessionTemplate.insert(namespace+".userInsert",userBean);
		return cnt;
	}

	//�α������� �������� ����
	public UserBean GetData(String usid) {
		UserBean login = null;
		System.out.println("�α��� id����");
		login = sqlSessionTemplate.selectOne(namespace +".GetData",usid);
		return login;
	}
	
	//IDã��
	public UserBean GetIdData(UserBean userBean) {
		UserBean findId=null; 
		System.out.println("ID ã��");
		findId = sqlSessionTemplate.selectOne(namespace+".GetIdData",userBean);
		return findId;
	}

	public UserBean GetPwData(UserBean userBean) {
		UserBean findPw=null; 
		System.out.println("PW ã��");
		findPw = sqlSessionTemplate.selectOne(namespace+".GetPwData",userBean);
		
		return findPw;
	}
}
