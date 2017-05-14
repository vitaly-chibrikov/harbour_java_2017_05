package space.harbour.l111.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Created by tully.
 */
public class MongoMain {
    private final MongoClient mongo;
    private final MongoDatabase mongoDatabase;

    MongoMain() {
        mongo = new MongoClient("localhost", 27017);
        mongoDatabase = mongo.getDatabase("testdb"); //create if not exist
    }

    public static void main(String[] args) {
        //org.apache.log4j.BasicConfigurator.configure();

        MongoMain main = new MongoMain();
        main.example();
    }

    private void example() {
        listDatabaseNames();

        String collectionName = "user";

        insert(collectionName, new Document("name", "Tully").append("company", "Umbrella INC"));

        FindIterable<Document> iterable = findByName(collectionName, "Tully");

        System.out.println("\nFind by name result: ");
        for (Document document : iterable) {
            System.out.println(document);
        }

        ObjectId id = insert(collectionName, new Document("name", "Sully").append("age", 42));

        FindIterable<Document> iterableID = findById(collectionName, id);

        System.out.println("\nFind by id result: ");
        for (Document document : iterableID) {
            System.out.println(document);
        }

        mongo.close();
    }

    private FindIterable<Document> findById(String collectionName, ObjectId id) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("_id", id);
        return collection.find(searchQuery);
    }

    private FindIterable<Document> findByName(String collectionName, String userName) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", userName);
        return collection.find(searchQuery);
    }

    private void listDatabaseNames() {
        MongoIterable<String> dbs = mongo.listDatabaseNames();
        System.out.println("\nDatabase names:");
        for (String db : dbs) {
            System.out.println(db);
        }
    }

    private ObjectId insert(String collectionName, Document doc) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName); //create if not exist
        collection.insertOne(doc);
        return (ObjectId) doc.get("_id");
    }
}
