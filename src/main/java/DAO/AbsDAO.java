package DAO;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class AbsDAO {
    static MongoDatabase db;

    static MongoDatabase getDB() {
        if (db == null) {
            ConnectionString connectionString = new ConnectionString("mongodb+srv://root:root@cluster0.lh5rj.mongodb.net/sample_mflix?retryWrites=true&w=majority");
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(connectionString)
                    .codecRegistry(fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build())))
                    .build();
            MongoClient mongoClient = MongoClients.create(settings);
            db = mongoClient.getDatabase("sample_mflix");
            System.out.println("Connect to DB");
        }
        return db;
    }
//    public static void main(String[] args){
//
//        MongoCollection<Comment> comments = getDB().getCollection("comments", Comment.class);
//
//        List<Bson> filter = new ArrayList<>();
//        filter.add(Aggregates.match(Filters.eq("operationType", "insert")));
//        filter.add(Aggregates.match(Filters.eq("fullDocument.email", "david@gmail.com")));
//
//        comments.watch().forEach(d->System.out.println(d));
//        System.out.println("unf dung ket thuc");
//
//
//    }
}
