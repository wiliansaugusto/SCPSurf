package br.com.achei.scpsurf.repository;

import br.com.achei.scpsurf.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long > {
}

