package com.project.test;

import java.util.Date;
import java.util.List;

import com.project.model.Brand;
import com.project.model.Category;
import com.project.model.Product;
import com.project.repository.ProductRepository;
import com.project.repository.impl.ProductRepositoryImpl;

public class Test {

	private static ProductRepository productRepository = new ProductRepositoryImpl();
	
	public static void main(String[] args) {
		
		insertData(); //for adding data to the database
		
		List<Object[]> products = productRepository.findProductNameAndPrice();
		for (Object[] objects : products) {
			System.out.println(objects[0]+ "-" +objects[1]);
		}
		
	}
	
	public static void insertData() {
		
		Brand brand1 = new Brand("SAMSUNG");
		Brand brand2 = new Brand("APPLE");
		Brand brand3 = new Brand("LG");
		Brand brand4 = new Brand("SONY");
		Brand brand5 = new Brand("ASUS");
		
		productRepository.saveBrand(brand1);
		productRepository.saveBrand(brand2);
		productRepository.saveBrand(brand3);
		productRepository.saveBrand(brand4);
		productRepository.saveBrand(brand5);
		
		Category category1 = new Category("Bilgisayar");
		Category category2 = new Category("Tablet");
		Category category3 = new Category("Telefon");
		
		productRepository.saveCategory(category1);
		productRepository.saveCategory(category2);
		productRepository.saveCategory(category3);
		
		Product product1 = new Product("Galaxy S21", 10000, 2, brand1, category3, new Date());
		Product product2 = new Product("Iphone 12", 12000, 1, brand2, category3, new Date());
		Product product3 = new Product("Sony Xperia1", 9000, 1, brand3, category3, new Date());
		
		Product product4 = new Product("Samsung Z500", 4000, 1, brand1, category1, new Date());
		Product product5 = new Product("Mac i7", 15000, 1, brand2, category1, new Date());
		Product product6 = new Product("ASUS i7", 6000, 2, brand5, category1, new Date());
		
		Product product7 = new Product("Galaxy Tablet", 3500, 1, brand1, category2, new Date());
		Product product8 = new Product("Ipad", 5000, 3, brand2, category2, new Date());
		Product product9 = new Product("Sony Tablet", 2500, 1, brand3, category2, new Date());
		
		productRepository.saveProduct(product1);
		productRepository.saveProduct(product2);
		productRepository.saveProduct(product3);
		productRepository.saveProduct(product4);
		productRepository.saveProduct(product5);
		productRepository.saveProduct(product6);
		productRepository.saveProduct(product7);
		productRepository.saveProduct(product8);
		productRepository.saveProduct(product9);
		
		
	}

}
