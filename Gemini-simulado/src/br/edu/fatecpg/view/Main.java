package br.edu.fatecpg.view;
import br.edu.fatecpg.service.ConsomeAPI;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String menu = """
                1 - Fazer Pergunta
                0 - Sair
                --------------------------------------------
                R:
                """;

        int qtdresp = 0;
        int escolha;
        List<String> perguntas = new ArrayList<>();

        while(true) {

            System.out.println(menu);
            escolha = scan.nextInt();
            scan.nextLine();

            if (escolha == 1) {
                System.out.println("Faça sua pergunta:");
                String pergunta = scan.nextLine();

                String resposta = ConsomeAPI.fazerPergunta(pergunta);
                System.out.println(resposta);
                perguntas.add(resposta);
                qtdresp++;
            }
            if (qtdresp >=3 && escolha == 0) {
                System.out.println("Saindo....");
                break;
            }
            }

        scan.close();
        ConsomeAPI.gravarResumoEmArquivo(ConsomeAPI.gerarResumo(perguntas));
        System.out.println("Salvo no arquivo 'resumo.txt'.");
        }
    }


