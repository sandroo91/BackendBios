package bios.springframework.spring5webapp.repositories;

import bios.springframework.spring5webapp.model.Kijkwijzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KwRepository extends JpaRepository<Kijkwijzer,Long> {
}
