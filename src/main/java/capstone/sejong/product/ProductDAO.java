package capstone.sejong.product;

import capstone.sejong.chemical.ChemicalDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO {

    @Autowired
    private SqlSession session;

    public List<ChemicalDTO> selectChemicals(List<String> gradients) {
        List<ChemicalDTO> chemicals = new ArrayList<>();
        for (String key : gradients) {
            ChemicalDTO chemicalDTO = session.selectOne("selectChemicalInfo", key);
            chemicals.add(chemicalDTO);
        }
        return chemicals;
    }

    public String selectIngredientNames(String productName) {
        return session.selectOne("selectIngredientNames", productName);
    }

}
