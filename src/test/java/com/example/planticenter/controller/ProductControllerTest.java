package com.example.planticenter.controller;

import com.example.planticenter.controller.ProductController;
import com.example.planticenter.exception.ProductNotFoundException;
import com.example.planticenter.model.Product;
import com.example.planticenter.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProductById() {
        // Produto mockado
        Product mockProduct = new Product();
        mockProduct.setId(1);
        mockProduct.setNome("Produto de Teste");
        mockProduct.setPreco(10.0);

        // Configuração do comportamento do serviço mockado
        when(productService.getProductById(1)).thenReturn(Optional.of(mockProduct));

        // Chamada do método do controlador
        ResponseEntity<Product> responseEntity = productController.getProductById(1);

        // Verifica resposta OK (código 200)
        // Verifica se o corpo é um produto, caso seja, se corresponde ao mock
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertTrue(responseEntity.getBody() instanceof Product);

        Product returnedProduct = (Product) responseEntity.getBody();
        assertEquals(mockProduct, returnedProduct);
    }

    @Test
    void testGetProductByIdNotFound() {
        // Configuração do comportamento do serviço mockado para um produto não encontrado
        when(productService.getProductById(2)).thenReturn(Optional.empty());

        // Chamada do método do controlador
        try {
            productController.getProductById(2);
        } catch (ProductNotFoundException e) {
            assertEquals("Produto não encontrado com o ID: 2", e.getMessage());
        }
    }
}
