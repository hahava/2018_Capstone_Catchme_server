package capstone.sejong.chemical;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChemicalController {

	@Autowired
	ChemicalService chemicalService;

	// 화학성분 전체 항목명을 리턴한다.
	@RequestMapping(value = "/request/chemicaList", method = RequestMethod.GET)
	public ResponseEntity chemicaList() {
		List<String> list = null;
		ResponseEntity responseEntity;
		try {
			list = chemicalService.getList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}

}
