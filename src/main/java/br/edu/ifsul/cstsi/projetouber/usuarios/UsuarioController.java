package br.edu.ifsul.cstsi.projetouber.usuarios;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
@Controller
public class UsuarioController {
    private static final Scanner input = new Scanner(System.in);
    private static UsuarioService UsuarioService;
    public UsuarioController(UsuarioService UsuarioService){
        UsuarioController.UsuarioService = UsuarioService;
    }
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
            input.nextLine();
            switch (opcao){
                case 1 -> inseririUsuario();
                case 2 -> editarUsuario();
                case 3 -> excluirUsuario();
                case 4 -> selecionarUsuarioId();
                case 5 -> selecionarUsuarioNome();
                default -> {
                    if(opcao != 0)
                        System.out.println("Opção invalida!");
                }
            }
        }while(opcao != 0);
    }

}
