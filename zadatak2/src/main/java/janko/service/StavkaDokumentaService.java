package janko.service;

import java.util.List;

import janko.model.StavkaDokumenta;

public interface StavkaDokumentaService {

	StavkaDokumenta findOne(Long id);
	List<StavkaDokumenta> findAll();
	StavkaDokumenta save(StavkaDokumenta stavkaDokumenta);
	void delete(Long id);
}
