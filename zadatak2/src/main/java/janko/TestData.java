
package janko;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import janko.model.Dokument;
import janko.model.Roba;
import janko.model.StavkaDokumenta;
import janko.service.impl.JpaDokumentService;
import janko.service.impl.JpaRobaService;
import janko.service.impl.JpaStavkaDokumenta;

@Component
public class TestData {

	@Autowired
	private JpaDokumentService ds;
	@Autowired
	private JpaRobaService rs;
	@Autowired
	private JpaStavkaDokumenta ss;

	@PostConstruct
	public void init() {
		Dokument z= new Dokument();
		z.setNaziv("Prvi Dokument");
		ds.save(z);
		
		Roba q = new Roba("Monitor");
		Roba w = new Roba("Mis");
		Roba e = new Roba("Tastatura");
		rs.save(q);
		rs.save(w);
		rs.save(e);
		
		StavkaDokumenta a = new StavkaDokumenta(5D, 98000D, z, q);
		StavkaDokumenta s = new StavkaDokumenta(3D, 6500D, z, w);
		StavkaDokumenta d = new StavkaDokumenta(4D, 12520.56, z, e);
		ss.save(a);
		ss.save(s);
		ss.save(d);
		
		z.addStavkaDokumenta(a);
		z.addStavkaDokumenta(s);
		z.addStavkaDokumenta(d);
		
		z.setIznos();
		System.out.println("***********************");
		System.out.println(z.getIznos());
		System.out.println("***********************");
		ds.save(z);
		

	}
}
