package capstone.sejong.chemical;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChemicalDAO {

	@Autowired
	SqlSession session;

	public List<String> getList() throws Exception {
		return session.selectList("getList");
	}

	public ChemicalDTO getInfo(String gradient) {
		ChemicalDTO chemicalDTO = session.selectOne("getinfo", gradient);
		System.out.println(chemicalDTO.allergy + "");
		return chemicalDTO;
	}

}
