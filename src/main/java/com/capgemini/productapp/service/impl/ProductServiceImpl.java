package com.capgemini.productapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.capgemini.productapp.entity.Product;
import com.capgemini.productapp.exception.ProductNotFoundException;
import com.capgemini.productapp.repository.ProductRepository;
import com.capgemini.productapp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	public ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product findProductById(int productId) throws ProductNotFoundException {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if (optionalProduct.isPresent())
			return optionalProduct.get();
		throw new ProductNotFoundException("product does not exist");
	}

	@Override
	public void deleteProduct(Product product) {

		productRepository.delete(product);

	}

	@Override
	public List<Product> findProductByName(String productName) throws ProductNotFoundException {
		List<Product> listProduct = productRepository.findProductByName(productName);
		if (!listProduct.isEmpty()) {
			return listProduct;
		}

		throw new ProductNotFoundException("product does not exist");

	}

	@Override
	public List<Product> findProductByCategory(String productCategory) {
		List<Product> listProduct = productRepository.findProductByCategory(productCategory);
		return listProduct;
	}

	@Override
	public List<Product> findProductByCategoryAndPrice(String productCategory, double max, double min) {
		List<Product> listProduct = productRepository.findProductByCategoryAndPrice(productCategory, max, min);
		return listProduct;
	}
}
