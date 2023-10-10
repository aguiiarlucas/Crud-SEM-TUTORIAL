package com.example.crud.meu.crud.services;


import com.example.crud.meu.crud.DTO.ProductDTO;
import com.example.crud.meu.crud.entities.Product;
import com.example.crud.meu.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    public Product insertProduct(ProductDTO productDTO) {
        Product newProduct = new Product();
        newProduct.setId(productDTO.getId());
        newProduct.setName(productDTO.getName());
        newProduct.setDescription(productDTO.getDescription());
        newProduct.setPrice(productDTO.getPrice().doubleValue());

        return repository.save(newProduct);


    }

    public Optional<Product> updateProduct(Long id, ProductDTO productDTO) {
        return repository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(productDTO.getName());
                    existingProduct.setDescription(productDTO.getDescription());
                    existingProduct.setPrice(productDTO.getPrice().doubleValue());

                    return repository.save(existingProduct);
                });
    }
    public void deleteProduct(Long id){
          repository.deleteById(id);
    }
}

