package DAO.MovieDB;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class AbsDAO {
    static WebTarget apiTarget;

    WebTarget getApiTarget() {
        if (apiTarget == null) {
            Client client = ClientBuilder.newClient();
            apiTarget = (WebTarget) ((Client) client).target("https://api.themoviedb.org/3").queryParam("api_key", "b813aa34b116603591a1f315a54dc895");
            System.out.println("Connect to API");
        }
        return apiTarget;
    }
}
