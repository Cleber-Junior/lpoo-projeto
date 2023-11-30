package br.edu.ifsul.cstsi.projetouber.usuarios;


import br.edu.ifsul.cstsi.projetouber.corridas.Corrida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Usuarios")
@Table(name = "Usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    List<Corrida> Corridas = new ArrayList<>();
}