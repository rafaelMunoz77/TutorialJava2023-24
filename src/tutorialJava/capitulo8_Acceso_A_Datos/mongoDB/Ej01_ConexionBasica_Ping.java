package tutorialJava.capitulo8_Acceso_A_Datos.mongoDB;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.ConnectionString;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Ej01_ConexionBasica_Ping {

	public static void main(String[] args) {

        try {
        	ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/");
        	MongoClient mongoClient = MongoClients.create(connectionString);

        	MongoDatabase database = mongoClient.getDatabase("ComunidadesProvinciasPoblaciones");
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            database.runCommand(command);
            System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
        } catch (MongoException me) {
            System.err.println(me);
        }
	}

}
