package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Reservering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ReserveringRepository extends CrudRepository<Reservering, Long> {
}
