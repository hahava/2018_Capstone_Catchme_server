package capstone.sejong.inquiry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {

	@Autowired
	InquiryDAO question;

	public void sendRequest(InquiryDTO questionDTO) throws Exception{
		System.out.println("sendquestion()");
		question.insert(questionDTO);
	}

}
