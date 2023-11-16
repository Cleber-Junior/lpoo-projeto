package br.edu.ifsul.cstsi.projetouber.model;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Usuarios")
@Table(name = "Usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "usuario")
    List<Corrida> Corridas = new ArrayList<>();
}