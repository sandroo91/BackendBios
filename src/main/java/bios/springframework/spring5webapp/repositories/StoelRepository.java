package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Stoel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoelRepository extends JpaRepository<Stoel, Long> {
}
