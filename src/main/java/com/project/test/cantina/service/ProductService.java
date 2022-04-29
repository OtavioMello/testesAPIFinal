package com.project.test.cantina.service;

import com.project.test.cantina.dto.ProductDTO;
import com.project.test.cantina.dto.ProductFormDTO;
import com.project.test.cantina.entities.Product;
import com.project.test.cantina.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO postProduct(ProductFormDTO productFormDTO) {
        Product product = productRepository.save(modelMapper.map(productFormDTO, Product.class));
        return modelMapper.map(product, ProductDTO.class);
    }

    public Page<ProductDTO> getProduct(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        List<ProductDTO> productDTOList =
                products.stream().map(p -> modelMapper.map(p, ProductDTO.class)).collect(Collectors.toList());
        return new PageImpl<>(productDTOList, pageable, productDTOList.size());
    }
}
