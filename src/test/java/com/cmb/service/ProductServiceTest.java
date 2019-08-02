package com.cmb.service;

import com.cmb.entity.Product;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductServiceTest  extends IntegrationTestBase{

    @Autowired
    private ProductService productService;

    @Test
    @DatabaseSetup("classpath:dbdata/product.xml")
    public void should_get_product_service() {

        Optional<Product> product = productService.find("2001");

        assertTrue(product.isPresent());
        Product prod = product.get();
        assertEquals(prod.getId(), "2001");
        assertEquals(prod.getName(), "phone");
        assertEquals(prod.getPrice(), 2000.00, DELTA);
    }
}