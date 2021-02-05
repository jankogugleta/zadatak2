package janko.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import janko.model.StavkaDokumenta;
import janko.web.dto.StavkaDokumentaDto;
@Component
public class StavkaDokumentaToDto implements Converter<StavkaDokumenta, StavkaDokumentaDto> {

	@Override
	public StavkaDokumentaDto convert(StavkaDokumenta source) {
		StavkaDokumentaDto ret = new StavkaDokumentaDto();
		BeanUtils.copyProperties(source, ret);
		ret.setDokumentId(source.getDokument().getId());
		ret.setRobaId(source.getRoba().getId());
		ret.setNazivRobe(source.getRoba().getNaziv());
		return ret;
	}

	public List<StavkaDokumentaDto> convert(List<StavkaDokumenta> source){
		List<StavkaDokumentaDto> ret = new ArrayList<StavkaDokumentaDto>();
		for (StavkaDokumenta stavka : source) {
			ret.add(convert(stavka));
		}
		return ret;
	}

}
