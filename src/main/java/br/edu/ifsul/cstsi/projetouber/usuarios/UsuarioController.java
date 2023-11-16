package br.edu.ifsul.cstsi.projetouber.usuarios;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

public class UsuarioController {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int opcao;
        do{
            System.out.println("\n ------- Menu do Usuário -------");
            System.out.println(
                    """
                            1. Cadastrar Usuário
                            2. Editar Usuário
                            3. Excluir Usuário
                            4. Buscar Usuário pelo código
                            5. Buscar Usuário pelo nome
                            0. Sair
                            
                            Sua Escolha:\s""");
            opcao = input.nextInt();
        }while(opcao != 0);
    }
}
