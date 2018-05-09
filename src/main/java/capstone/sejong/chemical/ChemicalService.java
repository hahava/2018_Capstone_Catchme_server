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

}
