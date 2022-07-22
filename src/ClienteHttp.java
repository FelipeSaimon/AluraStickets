import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    public String ConsultaDados(String url){
        // Pegar dados da API via HTTP

        try{
            URI endereco = URI.create(url);
            var cliente = HttpClient.newHttpClient(); //Cliente
            HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); //Requisição HTTP
            HttpResponse<String> response = cliente.send(request, BodyHandlers.ofString()); //Resposta
            String body = response.body();

            return body;
            
        }catch(IOException | InterruptedException ex){
            throw new RuntimeException(ex);
        }

        
    }
}
