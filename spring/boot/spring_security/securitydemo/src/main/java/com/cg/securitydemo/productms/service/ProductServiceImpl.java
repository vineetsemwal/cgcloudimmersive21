package com.cg.securitydemo.productms.service;

import com.cg.securitydemo.productms.dto.CreateProductRequest;
import com.cg.securitydemo.productms.dto.ProductDetails;
import com.cg.securitydemo.productms.entities.Product;
import com.cg.securitydemo.productms.exceptions.ProductNotFoundException;
import com.cg.securitydemo.productms.repository.IProductRepository;
import com.cg.securitydemo.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ProductUtil productUtil;

    @Override
    public ProductDetails add(CreateProductRequest request) {
        Product product=new Product();
        product.setName(request.getName());
        product=productRepository.save(product);
        ProductDetails desired=productUtil.toDetails(product);
        return desired;
    }

    @Override
    public ProductDetails findById(long productId) {
       Optional<Product> optional=  productRepository.findById(productId);
        if(!optional.isPresent()){
            throw new ProductNotFoundException("product is not found");
        }
        Product product= optional.get();
        ProductDetails desired=productUtil.toDetails(product);
        return desired ;
    }
}
