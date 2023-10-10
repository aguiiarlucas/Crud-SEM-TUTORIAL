package com.example.crud.meu.crud.controllers;

import com.example.crud.meu.crud.DTO.ProductDTO;
import com.example.crud.meu.crud.entities.Product;
import com.example.crud.meu.crud.repositories.ProductRepository;
import com.example.crud.meu.crud.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService service;
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity findAllProducts() {
        List<Product> list = service.findAllProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        Optional<Product> dto = service.findById(id);
        dto.ifPresent(product -> service.findById(id));
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping()
    public ResponseEntity<ProductDTO> insertProduct(@Valid @RequestBody ProductDTO productDTO) {

        Product savedProduct = service.insertProduct(productDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        Optional<Product> updatedProduct = service.updateProduct(id, productDTO);
        return updatedProduct.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        Optional<Product> optionalProduct = service.findById(id);

        return ResponseEntity.ok("Produto deletado");

    }
}


