package com.productbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productbackend.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
