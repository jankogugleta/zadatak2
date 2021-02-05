package janko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import janko.model.Dokument;

@Repository
public interface DokumentRepository extends JpaRepository<Dokument, Long>{

}
