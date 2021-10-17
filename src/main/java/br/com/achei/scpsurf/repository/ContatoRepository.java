package br.com.achei.scpsurf.repository;

import br.com.achei.scpsurf.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long > {
}
