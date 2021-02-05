package janko.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import janko.model.StavkaDokumenta;
import janko.repository.StavkaDokumentaRepository;
import janko.service.StavkaDokumentaService;

@Service
public class JpaStavkaDokumenta  implements StavkaDokumentaService{

	@Autowired
	private StavkaDokumentaRepository sr;
	@Override
	public StavkaDokumenta findOne(Long id) {
		// TODO Auto-generated method stub
		return sr.findById(id).orElse(null);
	}

	@Override
	public List<StavkaDokumenta> findAll() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public StavkaDokumenta save(StavkaDokumenta stavkaDokumenta) {
		// TODO Auto-generated method stub
		return sr.save(stavkaDokumenta);
	}

	@Override
	public void delete(Long id) {
		sr.deleteById(id);;
		
	}

}
