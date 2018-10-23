package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film,Long> {
}
