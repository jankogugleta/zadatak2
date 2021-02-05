package janko.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import janko.model.Dokument;
import janko.web.dto.DokumentDTO;


@Component
public class DtoToDokument implements Converter<DokumentDTO, Dokument>{

	@Autowired
	private DtoToStavkaDokumenta toStavka;
	
	@Override
	public Dokument convert(DokumentDTO source) {

		Dokument ret = new Dokument();
		BeanUtils.copyProperties(source, ret);
		ret.setStavkeDokumenta(toStavka.convert(source.getStavkeDokumenta()));

		return ret;

	}

	public List<Dokument> convert(List<DokumentDTO> source) {
		List<Dokument> ret = new ArrayList<Dokument>();
		for (DokumentDTO dokumentDto : source) {
			ret.add(convert(dokumentDto));
		}
		return ret;
	}

}