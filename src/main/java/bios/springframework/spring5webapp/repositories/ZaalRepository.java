package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Zaal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZaalRepository extends JpaRepository<Zaal, Long> {
}
