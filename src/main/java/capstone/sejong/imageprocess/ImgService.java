package capstone.sejong.imageprocess;

import capstone.sejong.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgService {
    @Autowired
    private ProductDAO productDAO;

    public List<String> getProducts() {
        return productDAO.selectAllProducts();
    }

    public List<String> getIngredient() {
        return productDAO.selectIngredient();
    }
}
