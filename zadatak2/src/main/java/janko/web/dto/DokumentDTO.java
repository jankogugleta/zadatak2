package janko.web.dto;

import java.util.ArrayList;
import java.util.List;

public class DokumentDTO {

	
	private long id;
	private String  naziv;
	private Double iznos;
	private String brojDokumenta;
	private List<StavkaDokumentaDto> stavkeDokumenta = new ArrayList<StavkaDokumentaDto>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Double getIznos() {
		return iznos;
	}
	public void setIznos(Double iznos) {
		this.iznos = iznos;
	}
	public String getBrojDokumenta() {
		return brojDokumenta;
	}
	public void setBrojDokumenta(String brojDokumenta) {
		this.brojDokumenta = brojDokumenta;
	}
	public List<StavkaDokumentaDto> getStavkeDokumenta() {
		return stavkeDokumenta;
	}
	public void setStavkeDokumenta(List<StavkaDokumentaDto> stavkeDokumenta) {
		this.stavkeDokumenta = stavkeDokumenta;
	}

	
}
