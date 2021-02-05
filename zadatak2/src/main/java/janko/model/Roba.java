package janko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Roba {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Roba() {
		super();
	}
	public Roba(String naziv) {
		super();
		this.naziv = naziv;
	}
	
	
	
}
