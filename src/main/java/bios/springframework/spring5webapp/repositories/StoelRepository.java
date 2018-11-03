package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Stoel;
import org.springframework.data.repository.CrudRepository;

public interface StoelRepository extends CrudRepository <Stoel, Long> {
}
