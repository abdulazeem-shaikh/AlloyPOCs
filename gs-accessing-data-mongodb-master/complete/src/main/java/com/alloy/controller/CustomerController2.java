package com.alloy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alloy.model.AmountRange;
import com.alloy.model.Customer;
import com.alloy.serviceImpl.CustomerServiceWithMColl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/root2")
public class CustomerController2 {

	private final static Logger logger = Logger.getLogger(CustomerController2.class);

	@Autowired
	private final CustomerServiceWithMColl customerService;

	public CustomerController2(CustomerServiceWithMColl customerService) {
		this.customerService = customerService;
	}

	@RequestMapping("/getFirstdoc")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getFirstdoc() {
		Customer customer = null;
		try {
			logger.info("Inside at the getFirstdoc method");
			customer = customerService.getFirstdoc();
		} catch (IOException e) {
			logger.error("Inside at the getFirstdoc method", e);
		}
		logger.info(customer);
		return customer;
	}
	
	

	@RequestMapping("/insertMultiDoc")
	public String insertMultiDoc( @RequestBody List<Customer> list ) {
 		boolean result = customerService.insertMultiDoc(list);
		return "Record inserted action status is : " + result;
	}

	@RequestMapping("/getListOfCustomerdoc")
	public List<Customer> getListOfCustomerdoc() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer=null;
 		customer = customerService.getListOfCustomerdoc();
 		return customer;
	}

	@RequestMapping("/getCustomerByRange")
	public List<Customer> getCustomerByRange(@RequestBody int returnedAmount) throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = null;
		customer=customerService.getCustomerByRange(returnedAmount);
		return customer;
	}


	@RequestMapping("/getAllCustomerDoc")
	public List<Customer> getAllCustomerDoc() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = null;
		customer = customerService.getAllCustomerDoc();
		return customer;
	}

	


	@RequestMapping("/getAllCustomerDocByMultiCondition")
	public List<Customer> getAllCustomerDocByMultiCondition( @RequestBody AmountRange range)
			throws JsonParseException, JsonMappingException, IOException {
 		List<Customer> customer = null;
  		logger.info("Input range is from start : "+range.start+" to "+range.end);
   		customer = customerService.getAllCustomerDocByMultiCondition(range);
		return customer;
	}
	

	

	
	@RequestMapping("/sortCustomerInDesc")
	public List<Customer> sortCustomerInDesc() throws JsonParseException, JsonMappingException, IOException {
		List<Customer> customer = null;
  		
   		customer = customerService.sortCustomerInDesc();
		return customer;
	}

	
	/*
	@RequestMapping("/getFirstdoc") // public List<Customer>
	  getCustDocByPorojection() throws JsonParseException, JsonMappingException,
	  IOException { // // List<Customer> customer = new ArrayList<Customer>(); //
	  ObjectMapper mapper = new ObjectMapper(); // AggregateIterable<Document>
	  AgItdoc = collection // .aggregate(asList(match(gt("i", 0)),
	  project(Document.parse("{ITimes10: {$multiply: ['$i', 10]}}")))); // for
	  (Document doc : AgItdoc) { // customer.add(mapper.readValue(doc.toJson(),
	  Customer.class)); // } // return customer; // }

	@RequestMapping("/getFirstdoc")
	public boolean updateCustomerDoc() {
		collection.updateOne(eq("i", 10), set("i", 110));
		return false;
	}

	@RequestMapping("/getFirstdoc")
	public long updateMultipleCustomDoc() {
		UpdateResult updateResult = collection.updateMany(lt("i", 100), inc("i", 100));
		return updateResult.getModifiedCount();
	}

	@RequestMapping("/getFirstdoc")
	public long deleteOneCustDoc() {
		DeleteResult result = collection.deleteOne(eq("i", 110));
		return result.getDeletedCount();

	}

	@RequestMapping("/getFirstdoc")
	public long deleteManyCustDoc() {
		DeleteResult result = collection.deleteOne(eq("i", 110));
		return result.getDeletedCount();
	}

	public boolean custDocBulkwrite() {

		Document doc = new Document("name", new Customer());

		List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();
		writes.add(new InsertOneModel<Document>(new Document("_id", 4).append("", Customer)));
		writes.add(new InsertOneModel<Document>(new Document("_id", 5)));
		writes.add(new InsertOneModel<Document>(new Document("_id", 6)));
		writes.add(new UpdateOneModel<Document>(new Document("_id", 1), new Document("$set", new Document("x", 2))));
		writes.add(new DeleteOneModel<Document>(new Document("_id", 2)));
		writes.add(new ReplaceOneModel<Document>(new Document("_id", 3), new Document("_id", 3).append("x", 4)));

		collection.bulkWrite(writes);

	}
*/
}
