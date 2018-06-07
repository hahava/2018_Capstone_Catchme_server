package capstone.sejong.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import capstone.sejong.chemical.ChemicalDTO;

@RequestMapping(value = "/product")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	// 해당 제품의 성분 리스트를 반환한다.
	@RequestMapping(method = RequestMethod.GET, value = "/ingradient/{productname}")
	ResponseEntity getImage(@PathVariable String productname) {
		System.out.println(productname);

		String gradient[] = null;
		List<ChemicalDTO> list = null;
		String ingradient = productService.getIngradient(productname);
		System.out.println(ingradient);
		gradient = ingradient.split("_");
		list = productService.getIngradientList(gradient);
		Map<String, ChemicalDTO> result = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			result.put(String.valueOf(i), list.get(i));
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}

}
