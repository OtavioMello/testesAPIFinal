package com.project.test.cantina.controller;

import com.project.test.cantina.dto.ProductDTO;
import com.project.test.cantina.dto.ProductFormDTO;
import com.project.test.cantina.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> postProduct(@RequestBody ProductFormDTO productFormDTO){
        ProductDTO product = productService.postProduct(productFormDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping
    public Page<ProductDTO> getProduct
            (@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
       Page<ProductDTO> products = productService.getProduct(pageable);
       return products;
    }
}
