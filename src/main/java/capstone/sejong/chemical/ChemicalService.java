package capstone.sejong.chemical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChemicalService {

	@Autowired
	private ChemicalDAO chemicalDao;

	public List<String> getChemicalIngredientNames() {
		return chemicalDao.getChemicalIngredientNames();
	}

	public ChemicalDTO getChemical(String ingredientName) {
		return chemicalDao.getChemical(ingredientName);
	}

	public List<ChemicalDTO> getChemicals(List<String> ingredientsNames) {
		return chemicalDao.selectChemicals(ingredientsNames);
	}

}
