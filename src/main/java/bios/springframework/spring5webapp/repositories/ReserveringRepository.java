package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Reservering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveringRepository extends JpaRepository<Reservering, Long> {
}
