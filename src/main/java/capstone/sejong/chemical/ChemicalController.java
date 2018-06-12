package capstone.sejong.chemical;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/chemical")
@RestController
public class ChemicalController {

	@Autowired
	ChemicalService chemicalService;

	// 화학성분 전체 항목명을 리턴한다.
	@RequestMapping(value = "/getnamelist", method = RequestMethod.GET)
	public ResponseEntity chemicaList() {
		List<String> list = null;
		try {
			list = chemicalService.getnamelist();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		// json타입으로 만들기 위한 hashmap
		Map<String, String> result = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			result.put(String.valueOf(i), list.get(i));
		}
		System.out.println(list.get(0));
		return new ResponseEntity(result, HttpStatus.OK);
	}

	// 화학성분 1개의 정보를 보내준다.
	@RequestMapping(value = "/getinfo/{gradient}", method = RequestMethod.GET)
	public ResponseEntity getInfo(@PathVariable String gradient) {
		ChemicalDTO chemicalDTO = null;
		try {
			chemicalDTO = chemicalService.getInfo(gradient);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(chemicalDTO, HttpStatus.OK);
	}

	// 화학성분의 리스트를 리턴한다.
	@RequestMapping(value = "/getinfolist", method = RequestMethod.GET)
	public ResponseEntity getInfoList(@RequestParam List<String> list) {
		List<ChemicalDTO> chemiList = null;
		HashMap<String, ChemicalDTO> map = new HashMap();

		try {
			chemiList = chemicalService.getInfoList(list);
			for (int i = 0; i < chemiList.size(); i++) {
				map.put(String.valueOf(i), chemiList.get(i));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(map, HttpStatus.OK);
	}

}
