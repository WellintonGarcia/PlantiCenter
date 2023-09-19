package com.example.planticenter.service;

import com.example.planticenter.model.Product;
import com.example.planticenter.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product updatedProduct) {
        Optional<Product> existingProductOptional = productRepository.findById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // Verifica se o id na requisição corresponde ao id na entidade
            if (existingProduct.getId() == id) {
                // Atualiza os campos do produto existente com os dados do produto atualizado
                existingProduct.setNome(updatedProduct.getNome());
                existingProduct.setPreco(updatedProduct.getPreco());

                // Salva o produto atualizado
                return productRepository.save(existingProduct);
            } else {
                throw new IllegalArgumentException("ID na requisição não corresponde ao ID do produto");
            }
        } else {
            throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
        }
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
