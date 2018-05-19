package capstone.sejong.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import capstone.sejong.chemical.ChemicalDTO;

@Repository
public class ProductDAO {

	@Autowired
	SqlSession session;

	public List<ChemicalDTO> getList(String[] gradient) {

		List<ChemicalDTO> temp = new ArrayList<>();
		for (String key : gradient) {
			ChemicalDTO chemicalDTO = session.selectOne("getlist", key);
			temp.add(chemicalDTO);
		}
		return temp;
	}

	public String[] getGradient(String productName) {
		String word = session.selectOne("getgradient", productName);
		String temp[] = word.split("_");
		return temp;
	}
}
