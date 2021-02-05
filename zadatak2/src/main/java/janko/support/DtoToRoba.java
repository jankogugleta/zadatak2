package janko.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import janko.model.Roba;
import janko.web.dto.RobaDTO;

@Component
public class DtoToRoba implements Converter<RobaDTO, Roba>{

	
	@Override
	public Roba convert(RobaDTO source) {

		Roba ret = new Roba();
		BeanUtils.copyProperties(source, ret);

		return ret;

	}

	public List<Roba> convert(List<RobaDTO> source) {
		List<Roba> ret = new ArrayList<Roba>();
		for (RobaDTO robaDto : source) {
			ret.add(convert(robaDto));
		}
		return ret;
	}

}