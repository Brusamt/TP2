package fatec.br.edu.fatecpg.apigemini.view;

import fatec.br.edu.fatecpg.apigemini.service.ConsomeApi;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String pergunta;

        while(true){
            System.out.println("Digite o número do tipo da pergunta: \n 1-Perguntar \n 2-sair");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha){
                case 1:
                    System.out.println("Escreva sua pergunta: ");
                    pergunta = scanner.nextLine();
                    if(pergunta.equalsIgnoreCase("sair")){
                        System.out.println("Programa encerrado!");
                        return;
                    }
                    try {
                        String resposta = ConsomeApi.fazerPergunta(pergunta);
                        System.out.println(resposta);
                        break;
                    }catch (IOException e){
                        System.out.println("erro ao conectar!" + e.getMessage());
                    }catch (Exception e){
                        System.out.println("erro Inesperado!" + e.getMessage());
                    }

                    case 2:
                        System.out.println("Programa encerrado!");
                        return;


            }
        }
    }
}