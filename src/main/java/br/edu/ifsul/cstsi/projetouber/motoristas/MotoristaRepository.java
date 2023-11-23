package br.edu.ifsul.cstsi.projetouber.motoristas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    @Query(value = "Select m from Motoristas m where m.nome like ?")
    List<Motorista> findByNome(String nome);

    @Query(value = "Select m from Motoristas m where m.id = ?")
    Optional<Motorista> findById(Long id);
}
