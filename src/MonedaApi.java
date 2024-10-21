import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MonedaApi {

    public Moneda Cambio(String origen, String destino, Double monto){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/1bae58a997bb89000be9b8e9/pair/"
                + origen + "/"
                + destino + "/"
                + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre la moneda");
        }


    }
}
