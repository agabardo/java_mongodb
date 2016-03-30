package org.mongojava.main;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

public class Main {

	public Main() {
		
	}

	public static void main(String[] args) {
		
		System.out.println("Oi");
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase("Amazon");
		String fields = "{imURL:true}";
		FindIterable<Document> iterable = db.getCollection("products_metadata").find(fields).limit(10);
		iterable.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document.toJson());
		    }
		});
		
		mongoClient.close();
	}

}
