package team_movie.model;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myGenreDao")
public class GenreDao {
	public static final String namespace="team_movie.model.GenreBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	//DB�� ���ǵ� ��ȭ �帣 ȹ��
	public List<GenreBean> getGenreList(){
		System.out.println("getGenreList Enter");
		List<GenreBean> genreList = new ArrayList<GenreBean>();
		
		genreList = sqlSessionTemplate.selectList(namespace + ".GetGenreList");
		System.out.println("genreList: " + genreList);
		
		return genreList;
	}
}
