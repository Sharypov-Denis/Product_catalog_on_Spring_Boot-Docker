package com.example.ProductsCatalogOnSpringBoot.repository;

import com.example.ProductsCatalogOnSpringBoot.model.Products;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
//@Sql(scripts = "classpath:db/Populate_DB.sql", config = @SqlConfig(encoding = "UTF-8"))
@SpringBootTest
public class CrudProductsRepositoryTest {

    @Autowired
    CrudProductsRepository crudProductsRepository;

    @Before
    public void deleteAll() {
        crudProductsRepository.deleteAll();
    }
/*
    @Test
    public void whenSavingProduct_thenCorrect() {
        crudProductsRepository.save(new Products("Bob", "bob@domain.com"));
        Products product = crudProductsRepository.findById(1).orElseGet(()
                -> new Products("john", "john@domain.com"));
        assertThat(product.getName()).isEqualTo("Bob");

        crudProductsRepository.deleteAll();
    }

 */

    @Test
    public void whenFindingProductById_thenCorrect() {
        crudProductsRepository.save(new Products("John", "john@domain.com"));
        assertThat(crudProductsRepository.findById(1)).isInstanceOf(Optional.class);

        crudProductsRepository.deleteAll();
    }

    @Test
    public void whenFindingAllProducts_thenCorrect() {
        crudProductsRepository.save(new Products(null, "John", "john@domain.com"));
        crudProductsRepository.save(new Products(null, "Julie", "julie@domain.com"));
        assertThat(crudProductsRepository.findAll()).isInstanceOf(List.class);

        crudProductsRepository.deleteAll();
    }

    @Test
    public void deleteNotFound() {
        assertThrows(EmptyResultDataAccessException.class, () -> crudProductsRepository.deleteById(1));
    }
    /*
    @Test
    public void delete() {
        crudProductsRepository.save(new Products(null, "John", "john@domain.com"));
        assertThrows(EmptyResultDataAccessException.class, () -> crudProductsRepository.getOne(12));

    }
     */
}
