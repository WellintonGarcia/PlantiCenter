package com.example.planticenter.repository;

import com.example.planticenter.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}
