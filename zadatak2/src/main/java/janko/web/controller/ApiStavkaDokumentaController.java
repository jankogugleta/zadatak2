package janko.web.controller;

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

import janko.model.StavkaDokumenta;
import janko.service.impl.JpaDokumentService;
import janko.service.impl.JpaStavkaDokumenta;
import janko.support.DtoToStavkaDokumenta;
import janko.support.StavkaDokumentaToDto;
import janko.web.dto.RobaDTO;
import janko.web.dto.StavkaDokumentaDto;

	@RestController
	@RequestMapping(value = "/api/stavke")
	public class ApiStavkaDokumentaController {
	
	
		@Autowired
		private JpaStavkaDokumenta ss;
		@Autowired
		private StavkaDokumentaToDto toDto;
		@Autowired
		private DtoToStavkaDokumenta toStavka;
		@Autowired
		private JpaDokumentService ds;

		// *****ADD*****
		@RequestMapping(method = RequestMethod.POST)
		ResponseEntity<StavkaDokumentaDto> add(@RequestBody StavkaDokumentaDto novi) {
			
			
			StavkaDokumenta f = ss.save(toStavka.convert(novi));
			f.getDokument().setIznos();
			ds.save(f.getDokument());
			return new ResponseEntity<>(toDto.convert(f), HttpStatus.CREATED);

		}

		// *****DELETE*****

		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		ResponseEntity<RobaDTO> delete(@PathVariable Long id) {

			ss.delete(id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}

		// *****EXCEPTIONHANDLER*****
		@ExceptionHandler(DataIntegrityViolationException.class)
		public ResponseEntity<Void> handle() {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

}
