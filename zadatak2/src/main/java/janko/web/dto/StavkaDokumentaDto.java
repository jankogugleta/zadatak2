package janko.web.dto;

public class StavkaDokumentaDto {

	
	private long id;
	private Double  kolicina;
	private Double cena;
	private Long dokumentId;
	private Long robaId;
	private String nazivRobe;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getKolicina() {
		return kolicina;
	}
	public void setKolicina(Double kolicina) {
		this.kolicina = kolicina;
	}
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}
	public Long getDokumentId() {
		return dokumentId;
	}
	public void setDokumentId(Long dokumentId) {
		this.dokumentId = dokumentId;
	}
	public Long getRobaId() {
		return robaId;
	}
	public void setRobaId(Long robaId) {
		this.robaId = robaId;
	}
	public String getNazivRobe() {
		return nazivRobe;
	}
	public void setNazivRobe(String nazivRobe) {
		this.nazivRobe = nazivRobe;
	}
	
	
}
