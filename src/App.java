import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse.BodyHandlers;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // Pegar dados da API via HTTP
        String URL = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(URL);
        var cliente = HttpClient.newHttpClient(); //Cliente
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); //Requisição HTTP
        HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString()); //Resposta
        String body = response.body();

        // System.out.println(body);
        // Extrair somente os dados necessarios (Title, poster, classificação)
        //REGEX java (Expressões regulares)

        //map é como dicionario/objeto em outras linguagens, que acossia chave: valor
        JsonParser Parser = new JsonParser();
        List<Map<String, String>> listaFilmes = Parser.parse(body);

        // Exibir os dados extraidos e manipular eles
        for (Map<String,String> filme : listaFilmes) {
            System.out.println("Título: "+filme.get("title"));
            System.out.println("Poster: "+filme.get("image"));
            System.out.println("Classificação: "+filme.get("imDbRating"));
            System.out.println();
        }

    }
}
