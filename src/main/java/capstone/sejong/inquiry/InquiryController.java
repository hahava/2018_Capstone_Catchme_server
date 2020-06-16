package capstone.sejong.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class InquiryController {

	private static final int INSERT_SUCCESS = 1;
	private static final int FIRST_ERROR = 0;

	@Autowired
	private InquiryService service;

	@RequestMapping(value = "/inquiry", method = RequestMethod.POST)
	public ResponseEntity addInquiry(@Valid @RequestBody InquiryDTO inquiryDTO, BindingResult br) {

		if (br.hasErrors()) {
			String errMsg = br.getAllErrors().get(FIRST_ERROR).getDefaultMessage();
			return new ResponseEntity("Error : " + errMsg, HttpStatus.BAD_REQUEST);
		}

		int result = service.addInquiry(inquiryDTO);
		if (result == INSERT_SUCCESS) {
			return new ResponseEntity("success", HttpStatus.OK);
		}
		return new ResponseEntity("fail", HttpStatus.BAD_REQUEST);
	}

}
