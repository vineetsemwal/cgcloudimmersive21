package com.cg.securitydemo.productms.service;

import com.cg.securitydemo.productms.dto.CreateProductRequest;
import com.cg.securitydemo.productms.dto.ProductDetails;

public interface IProductService {

   ProductDetails add(CreateProductRequest request);

   ProductDetails findById(long productId);


}
