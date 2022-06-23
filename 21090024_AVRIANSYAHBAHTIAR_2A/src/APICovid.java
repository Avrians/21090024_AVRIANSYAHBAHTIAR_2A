import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static java.util.Collections.sort;

public class APICovid {
    static ArrayList<Integer> totalKasus = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println("Sebelum Sorting");
        System.out.print(getResponse());
        sort(getResponse());

    }

    //mengambil data dari url
    public static ArrayList<Integer>  getResponse(){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/npm-covid-data/asia"))
                    .header("X-RapidAPI-Key", "24903deefcmshf2fe1aacddec7cbp1c634cjsn00e15bd03e77")
                    .header("X-RapidAPI-Host", "vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

        }catch (Exception e){
            System.err.println("eror");
        }
        return totalKasus;
    }

}
