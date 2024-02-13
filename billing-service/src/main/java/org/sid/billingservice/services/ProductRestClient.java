package org.sid.billingservice.services;

import org.sid.billingservice.medel.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {


    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable Long id);

    @GetMapping("/products")
    //PagedModel means the returned object is supposed to have the very same structure that will be returned by this method
    PagedModel<Product> allProducts();
}
