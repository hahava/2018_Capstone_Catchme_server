package capstone.sejong.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capstone.sejong.chemical.ChemicalDTO;

@Service
public class ProductService {

	@Autowired
	ProductDAO productDao;

	public List<ChemicalDTO> getIngradientList(String[] gradient) {
		return productDao.getIngradientList(gradient);
	}

	public String getIngradient(String productname) {
		return productDao.getIngradient(productname);
	}

}
