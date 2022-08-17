package com.walmartdws.ids.DWS.service;

import com.walmartdws.ids.DWS.model.Product;
import com.walmartdws.ids.DWS.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        product = new Product();
        product.setBarcode("00005");
        product.setHeight("5");
        product.setLength("4");
        product.setWeight("3.5");
        product.setWidth("45.4");
    }

    @Test
    void getAllProduct() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product));
        assertNotNull(productService.getAllProduct());
    }

    @Test
    void getProductByBarcode() {
        when(productRepository.findById(product.getBarcode())).thenReturn(Optional.ofNullable(product));
        assertNotNull(productService.getProductByBarcode(product.getBarcode()));
    }

    @Test
    void createProduct() {
        when(productRepository.save(product)).thenReturn(product);
        assertNotNull(productService.createProduct(product));
    }

    @Test
    void updateProduct() {
        when(productRepository.findById(any(String.class))).thenReturn(Optional.ofNullable(product));
        when(productRepository.save(product)).thenReturn(product);
        assertNotNull(productService.updateProduct(product));
    }

    @Test
    void deleteProduct() {
        when(productRepository.findById(product.getBarcode())).thenReturn(Optional.ofNullable(product));
        productService.deleteProduct(product.getBarcode());
    }

    @Test
    void postApi() {
        when(restTemplate.postForObject("", "", Product.class)).thenReturn(product);
        productService.postApi();
    }
}