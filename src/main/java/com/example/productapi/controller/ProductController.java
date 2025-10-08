
package com.example.productapi.controller;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.entity.Product;
import com.example.productapi.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    // GET /products
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // GET /products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    // POST /products
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductRequest request) {
        Product p = new Product(request.getName(), request.getDescription(), request.getPrice());
        Product saved = service.create(p);
        return ResponseEntity.created(URI.create("/products/" + saved.getId())).body(saved);
    }

    // PUT /products/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody ProductRequest request) {
        Product p = new Product(request.getName(), request.getDescription(), request.getPrice());
        Product updated = service.update(id, p);
        return ResponseEntity.ok(updated);
    }

    // DELETE /products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
