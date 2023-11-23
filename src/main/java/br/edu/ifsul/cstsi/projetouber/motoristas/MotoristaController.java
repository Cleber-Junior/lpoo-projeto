package br.edu.ifsul.cstsi.projetouber.motoristas;

import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class MotoristaController {

    private static final Scanner input = new Scanner(System.in);
    private static MotoristaService MotoristaService;

    public MotoristaController(MotoristaService MotoristService){
        MotoristaController.MotoristaService = MotoristService;
    }
    public static void main(String[] args) {

        int opcao;
        do{
            System.out.print("\n\"-------  Menu Usuário -------\"");
            System.out.print(
                    """
    
                        1. Inserir novo Motoristas
                        2. Atualizar um Motoristas
                        3. Excluir um Motoristas
                        4. Listar todos os Motoristas
                        5. Buscar Mootorista pelo Id
                        6. Buscar Motorista pelo nome
                        0. Sair
                        
                        Opção:\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao){
                case 1 -> inserirMotorista();
                case 2 -> atualizarMotorista();
                case 3 -> excluirMotorista();
                case 4 -> ListaMotorista();
                case 5 -> BuscarPeloNome();
                default -> {
                    if (opcao != 0){
                        System.out.println("Opção Invalida");
                    }
                }
            }
        }while(opcao != 0);
    }

}