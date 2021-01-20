package com.example.ProductsCatalogOnSpringBoot.repository;

import com.example.ProductsCatalogOnSpringBoot.model.Products;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudProductsRepositoryTest {

    @Autowired
    CrudProductsRepository crudProductsRepository;

    @Test
    public void whenFindingCustomerById_thenCorrect() {
        crudProductsRepository.save(new Products("John", "john@domain.com"));
        assertThat(crudProductsRepository.findById(1)).isInstanceOf(Optional.class);
    }
/*
    @Test
    public void whenFindingAllCustomers_thenCorrect() {
        crudProductsRepository.save(new Products(null, "John", "john@domain.com"));
        crudProductsRepository.save(new Products(null,"Julie", "julie@domain.com"));
        assertThat(crudProductsRepository.findAll()).isInstanceOf(List.class);
    }

 */

    @Test
    public void whenSavingCustomer_thenCorrect() {
        crudProductsRepository.save(new Products("Bob", "bob@domain.com"));
        Products product = crudProductsRepository.findById(1).orElseGet(()
                -> new Products("john", "john@domain.com"));
        assertThat(product.getName()).isEqualTo("Bob");
    }
}
