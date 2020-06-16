package capstone.sejong.inquiry;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InquiryDAO {

	@Autowired
	private SqlSession session;

	public int addInquiry(InquiryDTO inquiryDTO) {
		return session.insert("insertInquiry", inquiryDTO);
	}

}
