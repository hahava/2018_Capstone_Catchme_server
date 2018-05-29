package capstone.sejong.inquiry;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InquiryDAO {

	@Autowired
	SqlSession session;

	public void insert(InquiryDTO inquiryDTO) throws Exception {
		session.insert("insert", inquiryDTO);
	}

}
