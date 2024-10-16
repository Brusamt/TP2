package br.edu.fatecpg;
import br.edu.fatecpg.ConverteDados;
import br.edu.fatecpg.APIService;
import br.edu.fatecpg.ConverteDados;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Digite um valor para adicionar ao filtro: ");
        double preco = scan.nextDouble();

        ConverteDados conversor = new ConverteDados();
        String json = APIService.obterDado();
        JsonNode jsonNode = conversor.obterDado(json);
        List<JsonNode> jsonList = new ArrayList<>();
        jsonNode.forEach(jsonList::add);

        List<String> listaproduto = jsonList.stream()
                .filter(node -> node.get("price").asDouble() < preco)
                .map(node -> node.get("title").asText().toUpperCase())
                .toList();
        listaproduto.forEach(System.out::println);
    }

}


