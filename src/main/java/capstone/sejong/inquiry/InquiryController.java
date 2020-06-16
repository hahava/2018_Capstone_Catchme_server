package capstone.sejong.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InquiryController {

	private static final int INSERT_SUCCESS = 1;

	@Autowired
	private InquiryService service;

	@RequestMapping(value = "/inquiry", method = RequestMethod.POST)
	public ResponseEntity addInquiry(@RequestBody InquiryDTO inquiryDTO) {
		int result = service.addInquiry(inquiryDTO);
		if (result == INSERT_SUCCESS) {
			return new ResponseEntity("success", HttpStatus.OK);
		}
		return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
	}

}
