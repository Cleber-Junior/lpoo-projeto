package br.edu.ifsul.cstsi.projetouber.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Motoristas")
@Table(name = "Motorista")
public class Motorista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "motorista")
    private List <Corrida> Corridas = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "Veiculo", referencedColumnName = "id", unique = true)
    private Veiculo veiculo;
}