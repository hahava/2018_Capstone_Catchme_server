package capstone.sejong.chemical;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ChemicalDAO {

	@Autowired
	private SqlSession session;

	public List<String> getChemicalIngredientNames() {
		return session.selectList("selectChemicalIngredientNames");
	}

	public ChemicalDTO getChemical(String gradient) {
		return session.selectOne("selectChemicalIngredient", gradient);
	}

	public List<ChemicalDTO> selectChemicals(List<String> ingredientsNames) {
		return ingredientsNames
			.stream()
			.<ChemicalDTO>map(ingredient -> session.selectOne("selectChemicalIngredient", ingredient))
			.collect(Collectors.toList());
	}

}
