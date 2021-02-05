package janko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import janko.model.StavkaDokumenta;

@Repository
public interface StavkaDokumentaRepository extends JpaRepository<StavkaDokumenta, Long>{

}
