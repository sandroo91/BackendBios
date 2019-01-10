package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Authority;
import bios.springframework.spring5webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
