package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Long> {
}
