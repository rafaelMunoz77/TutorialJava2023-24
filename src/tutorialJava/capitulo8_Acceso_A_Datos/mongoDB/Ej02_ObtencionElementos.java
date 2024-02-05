package tutorialJava.capitulo8_Acceso_A_Datos.mongoDB;


import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;


public class Ej02_ObtencionElementos {

	
    // Obtener todos los documentos de una colección.
    private static void getAllDocuments(MongoCollection<Document> col) {
        System.out.println("Obteniendo todos los elementos de la colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find();
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
            	System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }
 
    // Filtrar documentos dentro de una colección.
    private static void getSelectiveDocument(MongoCollection<Document> col) {
    	System.out.println("Filtrando elementos de una colección");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find(Filters.eq("label", "Andalucía"));        
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
            	System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }
 
    // Obtener documentos que no cumplan un criterio.
    private static void getDocumentsWithNotInClause(MongoCollection<Document> col) {
    	System.out.println("Filtrando documentos con una claúsula 'not in'");
 
        // Performing a read operation on the collection.
        FindIterable<Document> fi = col.find(Filters.ne("label", "Andalucía"));        
        MongoCursor<Document> cursor = fi.iterator();
        try {
            while(cursor.hasNext()) {
            	System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
    }
 
    /**
     * Ejemplo de modificación de una entidad
     * @param col
     */
    private static void updateDocument (MongoCollection<Document> col) {
        try {
        	Document query = new Document().append("code",  "01");
        	Bson update = Updates.combine(Updates.set("label", "Andalucía 02"));
        	UpdateResult result = col.updateOne(query, update);
        	
        	System.out.println("Modificados: " + result.getModifiedCount());
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
        
    }
    
    /**
     * 
     * @param col
     */
    private static void insertDocument (MongoCollection<Document> col) {
        try {
        	Document doc = new Document().append("parent_code",  "0")
        			.append("code", "20")
        			.append("label", "Gibraltar");
        	col.insertOne(doc);
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
        
    }

    /**
     * 
     * @param col
     */
    private static void deleteDocument (MongoCollection<Document> col) {
        try {
        	Bson query = Filters.eq("code", "20");
        	DeleteResult result = col.deleteOne(query);
        	
        	System.out.println("Eliminados: " + result.getDeletedCount());
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
        
    }
    
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Mongodb inicializando parámetros.
        int port_no = 27017;
        String host_name = "localhost", db_name = "ComunidadesProvinciasPoblaciones", 
        		db_coll_name = "ccaa";
 
        // Mongodb creando la cadena de conexión.
        String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
        MongoClientURI uri = new MongoClientURI(client_url);
 
        // Conectando y obteniendo un cliente.
        MongoClient mongo_client = new MongoClient(uri);
 
        // Obteniendo un enlace a la base de datos.
        MongoDatabase db = mongo_client.getDatabase(db_name);
 
        // Obteniendo la colección de la base de datos
        MongoCollection<Document> coll = db.getCollection(db_coll_name);
 
        // Obteniendo todos los documentos de la colección.
//        getAllDocuments(coll); System.out.println("\n");
 
        // Filtrando documentos mediante una claúsula "eq".
//        getSelectiveDocument(coll); System.out.println("\n");
 
        // Filtrando documentos con una claúsula "neq".
//        getDocumentsWithNotInClause(coll); System.out.println();
        
        // Modificación de una entidad
//        updateDocument(coll);
        
        // Inserción de una entidad
//        insertDocument(coll);
        
        // Eliminación de una entidad
//        deleteDocument(coll);
        
    }
}
