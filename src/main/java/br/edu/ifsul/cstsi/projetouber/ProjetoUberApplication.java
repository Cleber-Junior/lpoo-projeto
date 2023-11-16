package br.edu.ifsul.cstsi.projetouber;

import br.edu.ifsul.cstsi.projetouber.corridas.CorridaController;
import br.edu.ifsul.cstsi.projetouber.motoristas.Motorista;
import br.edu.ifsul.cstsi.projetouber.motoristas.MotoristaController;
import br.edu.ifsul.cstsi.projetouber.usuarios.Usuario;
import br.edu.ifsul.cstsi.projetouber.usuarios.UsuarioController;
import br.edu.ifsul.cstsi.projetouber.veiculos.Veiculo;
import br.edu.ifsul.cstsi.projetouber.veiculos.VeiculoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ProjetoUberApplication {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do{
            System.out.println("\n------- Home ------");
            System.out.println(
                    """
                            1. Corrida
                            2. Usuário
                            3. Motorista
                            4. Veiculo
                            0. Sair
                            :\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao){
                case 1 -> CorridaController.main(null);
                case 2 -> UsuarioController.main(null);
                case 3 -> MotoristaController.main(null);
                case 4 -> VeiculoController.main(null);
                default -> {
                    if (opcao != 0){
                        System.out.println("Opção Invalida");
                    }
                }
            }
        } while(opcao != 0);
        System.out.println("\n\n ------- Fim Da Aplicação -------");
    }



}
