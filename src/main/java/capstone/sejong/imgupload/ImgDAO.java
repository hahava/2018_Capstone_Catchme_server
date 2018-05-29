package capstone.sejong.imgupload;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImgDAO {

	@Autowired
	SqlSession sqlSession;

	public List<String> getProductList() {
		return sqlSession.selectList("getProductList");
	}

}
