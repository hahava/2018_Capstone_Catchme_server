package capstone.sejong.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.sejong.chemical.ChemicalDTO;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDao;

	public List<ChemicalDTO> getList(String[] gradient) {
		return productDao.getList(gradient);
	}

	public String[] getGradient(String productName) {
		return productDao.getGradient(productName);
	}

}
