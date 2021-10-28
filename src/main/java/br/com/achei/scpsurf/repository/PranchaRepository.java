package br.com.achei.scpsurf.repository;

import br.com.achei.scpsurf.entity.Prancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PranchaRepository extends JpaRepository<Prancha, Long> {


}
