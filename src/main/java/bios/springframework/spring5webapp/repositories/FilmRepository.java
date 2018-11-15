package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
}
