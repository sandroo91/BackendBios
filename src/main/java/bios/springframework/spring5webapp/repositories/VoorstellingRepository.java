package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Voorstelling;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoorstellingRepository extends CrudRepository<Voorstelling,Long> {
}

