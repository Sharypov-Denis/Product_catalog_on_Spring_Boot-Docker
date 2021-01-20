package com.example.ProductsCatalogOnSpringBoot.repository;


import com.example.ProductsCatalogOnSpringBoot.model.Products;

import java.util.List;

public interface ProductsRepository {

    Products save(Products products);

    Products update(Products products);

    Products get(Integer id);

    void delete(Integer id);

    List<Products> getAll();

    List<Products> findProductsByName(String name);

    Products findOneProductsByName(String name);
}
