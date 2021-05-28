package com.cg.securitydemo.productms.util;


import com.cg.securitydemo.productms.dto.ProductDetails;
import com.cg.securitydemo.productms.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductUtil {

    public ProductDetails toDetails(Product product){
        ProductDetails desired=new ProductDetails();
        desired.setProductId(product.getProductId());
        desired.setName(product.getName());
        return desired;
    }

}
