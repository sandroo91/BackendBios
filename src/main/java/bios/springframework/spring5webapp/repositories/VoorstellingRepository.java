package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Voorstelling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoorstellingRepository extends JpaRepository<Voorstelling,Long> {
}

