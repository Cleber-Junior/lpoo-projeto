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
                            6. Listar Usuário
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
                case 6 -> listarUsuario();
                default -> {
                    if(opcao != 0)
                        System.out.println("Opção invalida!");
                }
            }
        }while(opcao != 0);
    }

    private static void inseririUsuario(){
        Usuario usuario = new Usuario();
        System.out.println("\n----------- Cadastra novo Usuário -----------");
        System.out.println("Digite nome do Usuário: ");
        usuario.setNome(input.nextLine());
        System.out.println("\nDigite o email do Usuário: ");
        usuario.setEmail(input.nextLine());
        System.out.println("\nDigte o Telefone do Usuário: ");
        usuario.setTelefone(input.nextLine());
        System.out.println("Usuário inserido com sucesso:" + UsuarioService.insert(usuario));

    }

    private static void editarUsuario(){
        System.out.println("\n----------- Digite o Código do Usúario -----------");
        Usuario usuario;
        int opcao = 0;

        do{
            System.out.println("Digite o código do Usuário a ser editado (Zero p/Sair)");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0){
                opcao = 0;
            }else{
                usuario = UsuarioService.getUsuarioById(codigo);
                if(usuario == null){
                    System.out.println("Código invalido!");
                }else{
                    System.out.println("Nome: " + usuario.getNome());
                    System.out.println("Deseja alterar? (0.Sim/1.Não)");
                    if (input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo nome do usuário: ");
                        usuario.setNome(input.nextLine());
                    }
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Alterar? (0.Sim/1.Não) ");
                    if (input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo email do Usuário: ");
                        usuario.setEmail(input.nextLine());
                    }
                    System.out.println("Telefone: " + usuario.getTelefone());
                    System.out.println("Alterar? (0.Sim/1.Não) ");
                    if (input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo telefone do Usuário: ");
                        usuario.setTelefone(input.nextLine());
                    }
                    if (UsuarioService.update(usuario) != null){
                        System.out.println("Usuário atualizado com sucesso. " + UsuarioService.getUsuarioById(usuario.getId()));
                    }else{
                        System.out.println("Não foi possivel atualizar este usuário. Para resolver este problema contate o Administrador");
                    }

                    opcao = 1;

                }
            }
        }while(opcao != 0);
    }

    private static void excluirUsuario(){
        System.out.println("----------- Excluir Usuário -----------");
        Usuario usuario;
        int opcao = 0;

        do{
            System.out.println("\nDigite o código do usuário (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if (codigo == 0){
               opcao = 0;
            }else if(codigo > 0){
                usuario = UsuarioService.getUsuarioById(codigo);
                if (usuario == null){
                    System.out.println("Código invalido!");
                }else{
                    System.out.println(usuario);
                    System.out.print("Excluir o Usuário? (0.Sim | 1.Não)");
                    if (input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Tem certeza? (0.Sim | 1.Não)");
                        input.nextLine();
                        UsuarioService.delete(usuario.getId());
                        System.out.println("Usuario excluido com sucesso: " + usuario);
                    }
                }
            }else{
                System.out.println("Digite um código Valido!");
            }
        }while(opcao != 0);
    }

    private static void selecionarUsuarioId(){
        System.out.println("\n Digite o código do Usuário: ");
        Usuario usuario = UsuarioService.getUsuarioById(input.nextLong());
        input.nextLine();
        if (usuario != null){
            System.out.println(usuario);
        }else{
            System.out.println("Código não encontrado!");
        }
    }

    private static void selecionarUsuarioNome(){
        System.out.println("\nDigite o nome do cliente: ");
        String nome = input.next();
        System.out.println("Chave de pesquisa: " + nome);
        List<Usuario> usuarios = UsuarioService.getUsuarioByNome(nome + "%");
        if (usuarios.isEmpty()){
            System.out.println("Não há registros relacionados a " + nome);
        }else{
            System.out.println(usuarios);
        }
    }

    private static void listarUsuario(){
        System.out.println("\n Lista dos Usuario:" + UsuarioService.getUsuario() + "\n");
    }
}
