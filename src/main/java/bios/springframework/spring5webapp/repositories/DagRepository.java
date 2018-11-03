package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Dag;
import org.springframework.data.repository.CrudRepository;

public interface DagRepository extends CrudRepository<Dag,Long> {
}
