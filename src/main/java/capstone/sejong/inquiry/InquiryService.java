package capstone.sejong.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {

	@Autowired
	InquiryDAO question;

	public void sendRequest(InquiryDTO questionDTO) throws Exception {
		question.insert(questionDTO);
	}

}
