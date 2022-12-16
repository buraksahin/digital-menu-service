package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Product;
import com.levelupcorp.emenube.domain.request.ProductRequest;
import com.levelupcorp.emenube.repository.ProductRepository;
import com.levelupcorp.emenube.util.mapper.GenericMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private GenericMapper genericMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, GenericMapper genericMapper) {
        this.productRepository = productRepository;
        this.genericMapper = genericMapper;
    }


    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long productId) {
        return productRepository.findById(productId).map(product -> product).orElse(null);
    }

    @Override
    public List<Product> getByRestaurantId(Long restaurantId) {
        return productRepository.findByRestaurantId(restaurantId);
    }
    @Override
    public List<Product> getByRestaurantIdAndCategoryId(Long restaurantId, Long categoryId) {
        return productRepository.findByRestaurantIdAndCategoryId(restaurantId, categoryId);
    }

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product newProduct = new Product();
        BeanUtils.copyProperties(productRequest, newProduct);
        Product savedProduct = productRepository.save(newProduct);
        return savedProduct;
    }

    @Override
    public Product updateProduct(ProductRequest productRequest, Long productId) {
        Product currentProduct = productRepository.findById(productId).map(product->product).orElse(null);

        if(currentProduct == null){
            return null;
        }
        try {
            genericMapper.<ProductRequest, Product>copyProperties(productRequest, currentProduct);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Product savedProduct = productRepository.save(currentProduct);
        return savedProduct;
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        return null;
    }
}
