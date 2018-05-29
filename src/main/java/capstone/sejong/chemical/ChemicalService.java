package capstone.sejong.chemical;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemicalService {

	@Autowired
	ChemicalDAO chemicalDao;

	public List<String> getnamelist() throws Exception {
		return chemicalDao.getnamelist();
	}

	public ChemicalDTO getInfo(String gradient) throws Exception {
		return chemicalDao.getInfo(gradient);
	}

	public List<ChemicalDTO> getInfoList(List<String> list) throws Exception {
		return chemicalDao.getInfoList(list);
	}

}
