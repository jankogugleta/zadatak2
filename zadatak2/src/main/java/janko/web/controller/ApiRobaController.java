package janko.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import janko.model.Roba;
import janko.service.impl.JpaRobaService;
import janko.support.DtoToRoba;
import janko.support.RobaToDto;
import janko.web.dto.RobaDTO;

@RestController
@RequestMapping(value = "/api/roba")
public class ApiRobaController {

	@Autowired
	private RobaToDto toDto;

	@Autowired
	private DtoToRoba toRoba;

	@Autowired
	private JpaRobaService rs;

	// *****GETONE*****
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<RobaDTO> getOne(@PathVariable Long id) {
		Roba f = rs.findOne(id);
		if (f == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDto.convert(f), HttpStatus.OK);

	}

	// *****GETALL*****
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<RobaDTO>> getAll() {

		List<Roba> all = new ArrayList<>();
		all = rs.findAll();

		return new ResponseEntity<>(toDto.convert(all), HttpStatus.OK);
	} //

	// *****ADD*****
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<RobaDTO> add(@RequestBody RobaDTO novi) {
		
		Roba f = rs.save(toRoba.convert(novi));

		return new ResponseEntity<>(toDto.convert(f), HttpStatus.CREATED);

	}

	// *****EDIT*****
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	ResponseEntity<RobaDTO> edit(@RequestBody RobaDTO eddited, @PathVariable Long id) {

		if (id == null || !id.equals(eddited.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Roba persisted = rs.save(toRoba.convert(eddited));

		return new ResponseEntity<>(toDto.convert(persisted), HttpStatus.OK);
	}

	// *****DELETE*****

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<RobaDTO> delete(@PathVariable Long id) {

		rs.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	// *****EXCEPTIONHANDLER*****
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
}
