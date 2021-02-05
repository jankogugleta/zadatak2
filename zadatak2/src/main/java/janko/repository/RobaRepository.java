package janko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import janko.model.Roba;

@Repository
public interface RobaRepository extends JpaRepository<Roba, Long>{

}
