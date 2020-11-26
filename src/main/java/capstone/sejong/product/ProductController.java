package capstone.sejong.product;

import capstone.sejong.chemical.ChemicalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    private final String SEPARATOR = "_";

    // 해당 제품의 성분 리스트를 반환한다.
    @RequestMapping(method = RequestMethod.GET, value = "/{productName}/ingredient")
    public ResponseEntity<List<ChemicalDTO>> getImage(@PathVariable String productName) {

        String rawIngredientData = productService.getIngredientNames(productName);

        List<String> ingredients = Arrays.asList(rawIngredientData.split(SEPARATOR));

        List<ChemicalDTO> chemicals = productService.getChemicals(ingredients);

        return new ResponseEntity<>(chemicals, HttpStatus.OK);

    }

}
