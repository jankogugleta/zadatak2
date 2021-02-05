package janko.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dokument {
	@Id
	@GeneratedValue
	@Column
	private long id;
	@Column
	private String  naziv;
	@Column
	private Double iznos;
	@OneToMany(mappedBy = "dokument")
	private List<StavkaDokumenta> stavkeDokumenta = new ArrayList<StavkaDokumenta>();
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
	public void setIznos() {
		Double iznos = 0D;
		for (StavkaDokumenta i : stavkeDokumenta) {
			iznos += i.getCena();
		}
		this.iznos=iznos;
	}
	public List<StavkaDokumenta> getStavkeDokumenta() {
		return stavkeDokumenta;
	}
	public void setStavkeDokumenta(List<StavkaDokumenta> stavkeDokumenta) {
		this.stavkeDokumenta = stavkeDokumenta;
	}
	
	public void addStavkaDokumenta(StavkaDokumenta stavkaDokumenta) {
		this.stavkeDokumenta.add(stavkaDokumenta);
		if (!stavkaDokumenta.getDokument().equals(this)) {
			stavkaDokumenta.setDokument(this);
		}
	
	}
	public Dokument(String naziv, Double iznos, List<StavkaDokumenta> stavkeDokumenta) {
		super();
		this.naziv = naziv;
		this.iznos = iznos;
		this.stavkeDokumenta = stavkeDokumenta;
	}
	public Dokument() {
		super();
	}
	
}
