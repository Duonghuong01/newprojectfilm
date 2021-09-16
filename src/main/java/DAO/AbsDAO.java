package DAO;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class AbsDAO {
    static MongoDatabase db;

    MongoDatabase getDB() {
        if (db == null) {
            ConnectionString connectionString = new ConnectionString("mongodb+srv://duonghuong01:duonghuong01@cluster0.gqd8v.mongodb.net/sample_mflix?retryWrites=true&w=majority");
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .build();
            MongoClient mongoClient = MongoClients.create(settings);
            db = mongoClient.getDatabase("sample_mflix");
            System.out.println("Connect to DB");
        }
        return db;
    }
}
