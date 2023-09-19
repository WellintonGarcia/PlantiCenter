package com.example.planticenter.controller;

import com.example.planticenter.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenValidProduct_thenReturns201() throws Exception {
        Product product = new Product();
        product.setNome("Teste Produto");
        product.setPreco(10.0);

        ResultActions result = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)));

        result.andExpect(status().isCreated());
    }

    @Test
    public void whenInvalidProduct_thenReturns400() throws Exception {
        // Criar um produto inválido (sem nome)
        Product product = new Product();
        product.setPreco(20.0);

        ResultActions result = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)));

        result.andExpect(status().isBadRequest());
    }
}
