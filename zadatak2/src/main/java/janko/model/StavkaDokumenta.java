package janko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StavkaDokumenta {

	
	@Id
	@GeneratedValue
	@Column
	private long id;
	@Column
	private Double  kolicina;
	@Column
	private Double cena;
	@ManyToOne
	private Dokument dokument;
	@ManyToOne
	private Roba roba;
	
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
	public Dokument getDokument() {
		return dokument;
	}
	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
		if (!dokument.getStavkeDokumenta().contains(this)) {
			dokument.getStavkeDokumenta().add(this);
		}
	}
	public Roba getRoba() {
		return roba;
	}
	public void setRoba(Roba roba) {
		this.roba = roba;
		
	}
	public StavkaDokumenta(Double kolicina, Double cena, Dokument dokument, Roba roba) {
		super();
		this.kolicina = kolicina;
		this.cena = cena;
		this.dokument = dokument;
		this.roba = roba;
	}
	public StavkaDokumenta() {
		super();
	}
	
	
}
