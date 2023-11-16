package br.edu.ifsul.cstsi.projetouber.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Corridas")
@Table(name = "Corrida")
public class Corrida {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoPagamento;
    private String detalhePagamento;
    private LocalDateTime dataInicio;
    private Double preco;
    @ManyToOne
    @JoinColumn(name = "Usuario_Id", referencedColumnName = "id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "Motorista_Id", referencedColumnName = "id")
    private Motorista motorista;

}