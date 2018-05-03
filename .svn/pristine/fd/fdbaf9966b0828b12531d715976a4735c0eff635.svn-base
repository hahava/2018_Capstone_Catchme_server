package capstone.sejong.inquiry;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InquiryDAO {

	@Autowired
	SqlSession session;

	public void insert(InquiryDTO inquiryDTO) throws Exception{
		System.out.println("insert()");
		session.insert("insert",inquiryDTO);
	}

}
