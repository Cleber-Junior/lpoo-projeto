package br.edu.ifsul.cstsi.projetouber.corridas;

import br.edu.ifsul.cstsi.projetouber.motoristas.Motorista;
import br.edu.ifsul.cstsi.projetouber.usuarios.Usuario;
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