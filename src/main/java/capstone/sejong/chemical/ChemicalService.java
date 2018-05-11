package capstone.sejong.chemical;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChemicalService {

	@Autowired
	ChemicalDAO chemicalDao;

	public List<String> getList() throws Exception {
		System.out.println("getList()");
		return chemicalDao.getList();
	}

	public ChemicalDTO getInfo(String gradient) {
		System.out.println("getinfo()");
		return chemicalDao.getInfo(gradient);
	}

	public List<ChemicalDTO> getInfoList(List<String> list) {
		System.out.println("getInfoList()");
		return chemicalDao.getInfoList(list);
	}

}
