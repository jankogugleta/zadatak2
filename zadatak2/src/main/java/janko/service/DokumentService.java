package janko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import janko.model.Dokument;
@Service
public interface DokumentService {

	Dokument findOne(Long id);
	List<Dokument> findAll();
	Dokument save(Dokument dokument);
	void delete(Long id);
	
	
}
