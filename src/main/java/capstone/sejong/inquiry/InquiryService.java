package capstone.sejong.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {

	@Autowired
	private InquiryDAO question;

	public int addInquiry(InquiryDTO questionDTO) {
		return question.addInquiry(questionDTO);
	}

}
