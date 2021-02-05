package janko.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import janko.model.StavkaDokumenta;
import janko.service.impl.JpaDokumentService;
import janko.service.impl.JpaRobaService;
import janko.web.dto.StavkaDokumentaDto;
@Component
public class DtoToStavkaDokumenta implements Converter<StavkaDokumentaDto, StavkaDokumenta>{

	@Autowired
	private JpaDokumentService ds;
	@Autowired
	private JpaRobaService rs;
	
	@Override
	public StavkaDokumenta convert(StavkaDokumentaDto source) {

		StavkaDokumenta ret  = new StavkaDokumenta();
		BeanUtils.copyProperties(source, ret);
		ret.setDokument(ds.findOne(source.getDokumentId()));
		ret.setRoba(rs.findOne(source.getRobaId()));
		
		return ret;
	}
	
	public List<StavkaDokumenta> convert(List<StavkaDokumentaDto> source) {
		List<StavkaDokumenta> ret = new ArrayList<StavkaDokumenta>();
		for (StavkaDokumentaDto stavkaDto : source) {
			ret.add(convert(stavkaDto));
		}
		return ret;
	}


}
