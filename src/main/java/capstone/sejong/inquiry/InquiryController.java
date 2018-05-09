package capstone.sejong.inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InquiryController {

	@Autowired
	InquiryService service;

	HttpHeaders headers;

	// 질의응답. DTO 형태로 전달받는다.
	@RequestMapping(value = "/sendRequest", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity sendQuestion(@RequestBody InquiryDTO inquiryDTO) {

		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try {
			service.sendRequest(inquiryDTO);
		} catch (Exception e) {
			// 에러 발생시 400 error를 리턴한다.
			e.printStackTrace();
			
			return new ResponseEntity(null, headers, HttpStatus.BAD_REQUEST);
		}
		// 성공시 200 코드 리턴
		return new ResponseEntity(null, headers, HttpStatus.OK);
	}

}
