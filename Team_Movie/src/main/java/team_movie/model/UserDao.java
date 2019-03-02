package team_movie.model;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<UserBean> GetAllUserList(){
		System.out.println("GetAllUserList");
		List<UserBean> userList = new ArrayList<UserBean>();
		userList = sqlSessionTemplate.selectList(namespace + ".GetAllUserData");

		return userList;
	}
	
	public int DelUser(int unum){
		System.out.println("DelUser");
		int num = 0;
		num =  sqlSessionTemplate.delete(namespace + ".DelUser",unum);
		return num;
	}

	public int UserUpdate(UserBean userBean) {
		int cnt =-1;
		
		cnt = sqlSessionTemplate.update(namespace+".UserUpdate",userBean);
		return cnt;
	}

	public int UpdateMembership(UserBean userBean) {
		int cnt = -1;
		System.out.println("userBean.getUsid(): "+userBean.getUsid());
		System.out.println("userBean.getUsid(): "+userBean.getUupend());
		System.out.println("userBean.getUsid(): "+userBean.getUupstart());
		System.out.println("userBean.getUsid(): "+userBean.getUgrade());
		cnt =sqlSessionTemplate.update(namespace+".UpdateMembership",userBean);
		return cnt;
	}
	
	public UserBean GetUserById(String usid) {
		UserBean user = new UserBean();
		user = sqlSessionTemplate.selectOne(namespace + ".GetUserById", usid);
		return user;
	}

	//�ߺ�üũ
	public boolean SearchID(String usid) {
		boolean flag =false;
		int cnt = -1;
		List<UserBean> array  =new ArrayList<UserBean>();
		
		array= sqlSessionTemplate.selectList(namespace+".SearchID",usid);
		System.out.println("array.size():"+array.size());
		if(array.size()==0 && usid!=null){
			flag =true;//���̵��������
			System.out.println("flag="+flag);
		
		}else{
			
			flag=false;//���̵��ߺ�
			System.out.println("flag="+flag);
		}
		return flag;
	}

	public String GetUserNum(String usid) {
		String unum=null;
		unum=sqlSessionTemplate.selectOne(namespace+".GetUserNum" ,usid);
		System.out.println("unum : "+ unum);
		return unum;
	}
}
 