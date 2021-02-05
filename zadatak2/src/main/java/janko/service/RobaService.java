package janko.service;

import java.util.List;

import janko.model.Roba;

public interface RobaService {

	Roba findOne(Long id);
	List<Roba> findAll();
	Roba save(Roba roba);
	void delete(Long id);
}
	
