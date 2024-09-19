package fatec.br.edu.fatecpg.apigemini.service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

    public class ConsomeApi {
        private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=AIzaSyAAYgAaLXeFQ-WpwXWLxptjzDXbBM5eRqg";
        private static final Pattern RESPOSTA_PATTERN = Pattern.compile("\"text\"\\s*:\\s*\"([^\"]+)\"");
        //fazerPergunta
        public static String fazerPergunta(String pergunta) throws IOException, InterruptedException {
            String jsonRequest = gerarJsonRequest(pergunta);
            String respostaJson = enviarRequisicao(jsonRequest);
            return extrairResposta(respostaJson);
        }

        private static String gerarJsonRequest(String pergunta) {
            String promptFormatado = "O resultado gerado deve ser objetivo" + pergunta;
            return "{\"contents\":[{\"parts\":[{\"text\":\"" + promptFormatado + "\"}]}]}";
        }

        private static String extrairResposta(String respostaJson) {
            StringBuilder resposta = new StringBuilder();
            for (String linha : respostaJson.lines().toList()) {
                Matcher matcher = RESPOSTA_PATTERN.matcher(linha);
                if (matcher.find()) {
                    resposta.append(matcher.group(1)).append(" ");
                }
            }
            return resposta.toString().trim();
        }
        private static String enviarRequisicao(String jsonRequest) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json" )
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();        return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        }
    }
