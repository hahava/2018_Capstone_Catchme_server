package capstone.sejong.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import capstone.sejong.chemical.ChemicalDTO;

@RequestMapping(value = "/product")
@RestController
public class ProductController {

	final static boolean isWord = true;

	@Autowired
	ProductService service;

	// 해당 제품의 성분 리스트를 반환한다.
	@RequestMapping(method = RequestMethod.GET, value = "/getimage")
	ResponseEntity getImage(String imgBin) {

		String gradient[] = null;
		List<ChemicalDTO> list = null;

		// 제품명 존재시
		if (isWord) {
			String productName = "미장센";
			gradient = service.getGradient(productName);
			list = service.getList(gradient);
		}
		// 검색이 잘 못 되거나, 제품명이 없을 시
		else {
			return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}

}
