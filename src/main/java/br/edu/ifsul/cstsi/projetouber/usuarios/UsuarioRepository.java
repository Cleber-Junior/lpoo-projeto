package br.edu.ifsul.cstsi.projetouber.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query(value = "Select u from Usuarios u where u.nome like ?1")
    List<Usuario> findByNome(String nome);

}
