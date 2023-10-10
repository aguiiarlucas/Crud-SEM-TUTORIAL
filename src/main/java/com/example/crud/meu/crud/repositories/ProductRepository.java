package com.example.crud.meu.crud.repositories;

import com.example.crud.meu.crud.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Long> {


}
