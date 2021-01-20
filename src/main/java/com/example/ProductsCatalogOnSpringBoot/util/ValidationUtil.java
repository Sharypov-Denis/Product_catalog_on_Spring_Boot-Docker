package com.example.ProductsCatalogOnSpringBoot.util;


import com.example.ProductsCatalogOnSpringBoot.model.Products;

public class ValidationUtil {

    public static void checkNewProduct(Products products) {
        if (!products.isNew()) {
            throw new RuntimeException(products + " must be new (id=null)");
        }
    }
}
