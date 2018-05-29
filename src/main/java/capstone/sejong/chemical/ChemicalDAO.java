package capstone.sejong.chemical;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChemicalDAO {

	@Autowired
	SqlSession session;

	public List<String> getnamelist() throws Exception {
		return session.selectList("getList");
	}

	public ChemicalDTO getInfo(String gradient) throws Exception {
		ChemicalDTO chemicalDTO = session.selectOne("getinfo", gradient);
		return chemicalDTO;
	}

	public List<ChemicalDTO> getInfoList(List<String> list) throws Exception {
		List<ChemicalDTO> temp = new ArrayList<>();
		for (String gradient : list) {
			ChemicalDTO chemicalDTO = session.selectOne("getinfo", gradient);
			temp.add(chemicalDTO);
		}
		return temp;
	}

}
