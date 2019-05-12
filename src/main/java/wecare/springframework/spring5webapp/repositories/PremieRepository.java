package wecare.springframework.spring5webapp.repositories;

import wecare.springframework.spring5webapp.model.Premie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremieRepository extends JpaRepository<Premie,Long> {

}

