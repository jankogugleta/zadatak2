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

import janko.model.Dokument;
import janko.service.impl.JpaDokumentService;
import janko.support.DokumentToDto;
import janko.support.DtoToDokument;
import janko.web.dto.DokumentDTO;

@RestController
@RequestMapping(value = "/api/dokumenti")
public class ApiDokumentController {

	@Autowired
	private DokumentToDto toDto;

	@Autowired
	private DtoToDokument toDokument;

	@Autowired
	private JpaDokumentService ds;

	// *****GETONE*****
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<DokumentDTO> getOne(@PathVariable Long id) {
		Dokument f = ds.findOne(id);
		if (f == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDto.convert(f), HttpStatus.OK);

	}

	// *****GETALL*****
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<DokumentDTO>> getAll() {

		List<Dokument> all = new ArrayList<>();
		all = ds.findAll();

		return new ResponseEntity<>(toDto.convert(all), HttpStatus.OK);
	} //

	// *****ADD*****
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<DokumentDTO> add(@RequestBody DokumentDTO novi) {
		
		Dokument f = ds.save(toDokument.convert(novi));
		return new ResponseEntity<>(toDto.convert(f), HttpStatus.CREATED);

	}

	// *****EDIT*****
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	ResponseEntity<DokumentDTO> edit(@RequestBody DokumentDTO eddited, @PathVariable Long id) {

		if (id == null || !id.equals(eddited.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Dokument novi = toDokument.convert(eddited);
		ds.save(novi);

		return new ResponseEntity<>(toDto.convert(novi), HttpStatus.OK);
	}

	// *****DELETE*****

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<DokumentDTO> delete(@PathVariable Long id) {

		ds.delete(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	// *****EXCEPTIONHANDLER*****
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle() {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
}
