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
public class DokumentToDto  implements Converter<Dokument, DokumentDTO>{

	@Autowired
	private StavkaDokumentaToDto toDto;
	
	@Override
	public DokumentDTO convert(Dokument source) {
		DokumentDTO ret = new DokumentDTO();
		
		BeanUtils.copyProperties(source, ret);
		ret.setStavkeDokumenta(toDto.convert(source.getStavkeDokumenta()));
		
		return ret;
	}
	
	public List<DokumentDTO> convert(List<Dokument> source){
		List<DokumentDTO> ret = new ArrayList<DokumentDTO>();
		for (Dokument dok : source) {
			ret.add(convert(dok));
		}
		return ret;
	}

}
