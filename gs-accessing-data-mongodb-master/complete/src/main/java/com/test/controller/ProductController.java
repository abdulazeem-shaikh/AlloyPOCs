package com.test.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import com.test.model.Product;
import com.test.service.ProductService;
import com.test.service.ProductService;

@Controller
@Path("/Product")
public class ProductController {

	@Inject
	private ProductService productService;

	@Path("/getProductDetailById")
	public Product getProductDetailById() {
		return new Product();
	}

	@Path("/updateProductDetailById")
	public Product updateProductDetailById() {
		return new Product();
	}

	@Path("/createProduct")
	public Product createProduct() {
		return new Product();
	}

	@Path("/deleteProduct")
	public Product deleteProduct() {
		return new Product();
	}

}
