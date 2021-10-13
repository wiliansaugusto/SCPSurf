package br.com.achei.scpsurf.repository;

import br.com.achei.scpsurf.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select usuario from Usuario usuario where usuario.numCpf = :numCpf")
    Optional<Usuario> FindByNumCpf(int numCpf);

}
