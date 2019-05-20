package com.cmb.contract.base;

import com.cmb.controller.ProductController;
import com.cmb.integrationtest.IntegrationTestBase;
import com.cmb.service.ProductService;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProductGetBase extends IntegrationTestBase {

	@Autowired
	private ProductService productService;

	@Before
	@DatabaseSetup("classpath:dbdata/product.xml")
	public void setUp() throws Exception {
		RestAssuredMockMvc.standaloneSetup(new ProductController(productService));
	}
}
