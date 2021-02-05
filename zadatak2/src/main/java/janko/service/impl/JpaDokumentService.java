package janko.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import janko.model.Dokument;
import janko.repository.DokumentRepository;
import janko.service.DokumentService;
@Service
public class JpaDokumentService implements DokumentService {

	@Autowired
	private DokumentRepository dr;

	
	@Override
	public Dokument findOne(Long id) {
		return dr.findById(id).orElse(null);
	}
	 

	@Override
	public List<Dokument> findAll() {
		// TODO Auto-generated method stub
		return dr.findAll();
	}

	@Override
	public Dokument save(Dokument dokument) {
		dokument.setIznos();
		return dr.save(dokument);
	}

	@Override
	public void delete(Long id) {
		dr.deleteById(id);

	}

}
