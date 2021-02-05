package janko.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import janko.model.Roba;
import janko.repository.RobaRepository;
import janko.service.RobaService;

@Service
public class JpaRobaService implements RobaService{

	@Autowired
	private RobaRepository rr;
	
	@Override
	public Roba findOne(Long id) {
		// TODO Auto-generated method stub
		return rr.findById(id).orElse(null);
	}

	@Override
	public List<Roba> findAll() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	@Override
	public Roba save(Roba roba) {
		// TODO Auto-generated method stub
		return rr.save(roba);
	}

	@Override
	public void delete(Long id) {
		rr.deleteById(id);
		
	}

}
