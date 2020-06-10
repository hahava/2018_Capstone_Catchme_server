package capstone.sejong.chemical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chemical")
public class ChemicalController {

	@Autowired
	private ChemicalService chemicalService;

	// 화학성분 전체 항목명을 리턴한다.
	@RequestMapping(value = "/ingredient_names", method = RequestMethod.GET)
	public ResponseEntity getChemicalIngredientNames() {
		return new ResponseEntity(chemicalService.getChemicalIngredientNames(), HttpStatus.OK);
	}

	// 화학성분 1개의 정보를 보내준다.
	@RequestMapping(value = "/ingredient/{ingredientName}", method = RequestMethod.GET)
	public ResponseEntity getChemical(@PathVariable String ingredientName) {
		return new ResponseEntity(chemicalService.getChemical(ingredientName), HttpStatus.OK);
	}

	// 화학성분의 리스트를 리턴한다.
	@RequestMapping(value = "/ingredients", method = RequestMethod.GET)
	public ResponseEntity getChemicals(@RequestParam List<String> ingredientsNames) {
		return new ResponseEntity(chemicalService.getChemicals(ingredientsNames), HttpStatus.OK);
	}

}
