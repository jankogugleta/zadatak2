package janko.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import janko.model.Roba;
import janko.web.dto.RobaDTO;

@Component
public class RobaToDto implements Converter<Roba, RobaDTO>{

	@Override
	public RobaDTO convert(Roba source) {
		
		RobaDTO ret = new RobaDTO();
		BeanUtils.copyProperties(source, ret);
		
		return ret;
	}
	
	public List<RobaDTO> convert(List<Roba> source){
		List<RobaDTO> ret = new ArrayList<RobaDTO>();
		for (Roba roba : source) {
			ret.add(convert(roba));
		}
		return ret;
	}

}
