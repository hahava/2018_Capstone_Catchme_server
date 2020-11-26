package capstone.sejong.product;

import capstone.sejong.chemical.ChemicalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDao;

    public List<ChemicalDTO> getChemicals(List<String> gradients) {
        return productDao.selectChemicals(gradients);
    }

    public String getIngredientNames(String productName) {
        return productDao.selectIngredientNames(productName);
    }

}
