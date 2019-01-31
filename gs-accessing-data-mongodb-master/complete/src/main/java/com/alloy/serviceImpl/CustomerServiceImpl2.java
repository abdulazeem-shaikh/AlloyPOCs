package com.alloy.serviceImpl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Sorts.descending;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.alloy.model.Customer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.match;
import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Sorts.descending;
import static com.mongodb.client.model.Updates.inc;
import static com.mongodb.client.model.Updates.set;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.WriteModel;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class CustomerServiceImpl2 {

	MongoCollection<Document> collection;

	public boolean insertDoc(Document doc1) {
		Document doc = new Document("name", new Customer());
		collection.insertOne(doc);
		return true;
	}

	public Customer getFirstdoc() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Document myDoc = collection.find().first();
		return mapper.readValue(myDoc.toJson(), Customer.class);

	}

	public boolean insertMultiDoc() {
		List<Document> documents = new ArrayList<Document>();
		for (int i = 0; i < 100; i++) {
			documents.add(new Document("" + i, new Customer()));
		}
		collection.insertMany(documents);
		return false;
	}

	public List<Customer> getListOfCustomerdoc() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());

				customer.add(mapper.readValue(cursor.next().toJson(), Customer.class));
			}
		} finally {
			cursor.close();
		}
		return customer;
	}

	public List<Customer> getCustomerByRange() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		MongoCursor<Document> cursor = collection.find(gt("i", 50)).iterator();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());

				customer.add(mapper.readValue(cursor.next().toJson(), Customer.class));
			}
		} finally {
			cursor.close();
		}
		return customer;
	}

	public List<Customer> getAllCustomerDoc() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());

				customer.add(mapper.readValue(cursor.next().toJson(), Customer.class));
			}
		} finally {
			cursor.close();
		}
		return customer;
	}

	//

	public List<Customer> getAllCustomerDocByMultiCondition()
			throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		MongoCursor<Document> cursor = collection.find(and(gt("i", 50), lte("i", 100))).iterator();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
				customer.add(mapper.readValue(cursor.next().toJson(), Customer.class));
			}
		} finally {
			cursor.close();
		}
		return customer;
	}

	public List<Customer> sortCustomerInDesc() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		Document doc = collection.find(exists("i")).sort(descending("i")).first();
		customer.add(mapper.readValue(doc.toJson(), new TypeReference<List<Customer>>() {
		}));
		return customer;
	}

	
	
	
//	public List<Customer> getCustDocByPorojection() throws JsonParseException, JsonMappingException, IOException {
//
//		List<Customer> customer = new ArrayList<Customer>();
//		ObjectMapper mapper = new ObjectMapper();
//		AggregateIterable<Document> AgItdoc = collection
//				.aggregate(asList(match(gt("i", 0)), project(Document.parse("{ITimes10: {$multiply: ['$i', 10]}}"))));
//		for (Document doc : AgItdoc) {
//			customer.add(mapper.readValue(doc.toJson(),  Customer.class));
//		}
//		return customer;
//	}
	
	
	public boolean updateCustomerDoc() {
		collection.updateOne(eq("i", 10), set("i", 110));
		return false;
	}
	
	
	public long updateMultipleCustomDoc() {
		UpdateResult updateResult = collection.updateMany(lt("i", 100), inc("i", 100));
		return updateResult.getModifiedCount();
	}
	
	public long deleteOneCustDoc() {
		DeleteResult result= collection.deleteOne(eq("i", 110));
		return result.getDeletedCount();
	
	}
	
	public long deleteManyCustDoc() {
		DeleteResult result= collection.deleteOne(eq("i", 110));
		return result.getDeletedCount();	
	}
	
	
	/*
	 * public boolean custDocBulkwrite() {
	 * 
	 * Document doc = new Document("name", new Customer());
	 * 
	 * 
	 * List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();
	 * writes.add(new InsertOneModel<Document>(new Document("_id",
	 * 4).append("",Customer))); writes.add(new InsertOneModel<Document>(new
	 * Document("_id", 5))); writes.add(new InsertOneModel<Document>(new
	 * Document("_id", 6))); writes.add(new UpdateOneModel<Document>(new
	 * Document("_id", 1), new Document("$set", new Document("x", 2))));
	 * writes.add(new DeleteOneModel<Document>(new Document("_id", 2)));
	 * writes.add(new ReplaceOneModel<Document>(new Document("_id", 3), new
	 * Document("_id", 3).append("x", 4)));
	 * 
	 * collection.bulkWrite(writes);
	 * 
	 * }
	 */
	
	
	
	
	
	
	
}
