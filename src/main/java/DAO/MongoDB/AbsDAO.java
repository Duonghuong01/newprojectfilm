package DAO.MongoDB;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Date;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class AbsDAO {
    static MongoDatabase db;

    static MongoDatabase getDB() {
        if (db == null) {
            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));

            ConnectionString connectionString = new ConnectionString("mongodb+srv://duonghuong01:duonghuong01@cluster0.gqd8v.mongodb.net/sample_mflix?retryWrites=true&w=majority");
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .codecRegistry(pojoCodecRegistry)
                    .build();
            MongoClient mongoClient = MongoClients.create(settings);
            db = mongoClient.getDatabase("sample_mflix");

            System.out.println("Connect to DB");
        }
        return db;
    }
//    public static void main(String[] args) {
//        MongoCollection<Comment> comments = getDB().getCollection("comments",Comment.class);
//
//        comments.watch().forEach(d-> System.out.println(d));
//
//
//
//
//    }


}
