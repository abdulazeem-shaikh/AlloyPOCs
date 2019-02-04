package com.alloy.serviceImpl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Updates.inc;
import static com.mongodb.client.model.Updates.set;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.alloy.model.AmountRange;
import com.alloy.model.Customer;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

@Repository
public class CustomerServiceWithMColl {

	@Autowired
	MongoCollection<Customer> collection;
 
	private final static Logger logger = Logger.getLogger(CustomerServiceWithMColl.class);
	
	public Customer getFirstdoc() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Customer customer = collection.find().first();
 		/*logger.info("Getting the first doc");*/
 		return  customer;
	}

	
	
	public boolean insertMultiDoc(List<Customer> list) {
		List<Customer> customer = new ArrayList<Customer>();
		for (long i = 0; i < 100; i++) {
			customer.add(new Customer(String.valueOf(Math.abs(new Random().nextLong())) , "firstName"+i, "lastName"+i, i));
		}
		collection.insertMany(list);
		logger.info("inserted successfully");
		return true;
	}
	

	public List<Customer> getListOfCustomerdoc() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		MongoCursor<Customer> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				//System.out.println(cursor.next().toJson());
				//customer.add(mapper.readValue(cursor.next().toJson(), Customer.class));
				customer.add(cursor.next());
			
			}
		} finally {
			cursor.close();
		}
		return customer;
	}

	
	public List<Customer> getCustomerByRange(int returnedAmount) throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		MongoCursor<Customer> cursor = collection.find(gt("returnedAmount", returnedAmount)).iterator();
		try {
			while (cursor.hasNext()) {
				// System.out.println(cursor.next().toJson());
				customer.add(cursor.next());
				// customer.add(mapper.readValue(cursor.next().toJson(), Customer.class));
			}
		} finally {
			cursor.close();
		}
		return customer;
	}
	
	
	public List<Customer> getAllCustomerDoc() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		MongoCursor<Customer> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				//System.out.println(cursor.next().toJson());
				customer.add(cursor.next());
				//customer.add(mapper.readValue(cursor.next().toJson(), Customer.class));
			}
		} finally {
			cursor.close();
		}
		return customer;
	}

	//

	public List<Customer> getAllCustomerDocByMultiCondition( AmountRange range)
			throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		MongoCursor<Customer> cursor = collection.find(and(gt("returnedAmount", range.start), lte("returnedAmount", range.end)))
				.iterator();
		try {
			while (cursor.hasNext()) {
				customer.add(cursor.next());
			}
		} finally {
			cursor.close();
		}
		return customer;
	}

	public List<Customer> sortCustomerInDesc() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = new ArrayList<Customer>();
		ObjectMapper mapper = new ObjectMapper();
		Customer doc = (Customer) collection.find(exists("returnedAmount")).sort(descending("returnedAmount")).first();
 
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
	
	
	
	
	private void mian() {
		// TODO Auto-generated method stub
    System.out.println(System.currentTimeMillis());
	}
	
	
}
