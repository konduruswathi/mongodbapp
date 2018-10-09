package com.capgemini.productapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.capgemini.productapp.entity.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {
@Query("{'productName':?0}")
public List<Product> findProductByName(String nameContains);

@Query("{'productCategory':?0}")
public List<Product> findProductByCategory(String productCategory);

@Query("{'productCategory': ?0 , 'price':{'$gt' : ?1 ,'$lt': ?2}}")
public List<Product> findProductByCategoryAndPrice(String productCategory , double max, double min);
}