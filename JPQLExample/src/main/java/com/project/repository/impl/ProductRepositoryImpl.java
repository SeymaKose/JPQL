package com.project.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.project.EntityManager.IJPAFactory;
import com.project.EntityManager.impl.JPAFactoryImpl;
import com.project.model.Brand;
import com.project.model.Category;
import com.project.model.Product;
import com.project.model.ProductDetails;
import com.project.queries.ProductQueries;
import com.project.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository{

	private IJPAFactory factory = new JPAFactoryImpl();
	private EntityManager entityManager = factory.getEntityManager();
	private EntityTransaction entityTransaction = factory.getTransaction();
	
	public Product saveProduct(Product product) {
		
		this.entityTransaction.begin();
		this.entityManager.persist(product);
		this.entityTransaction.commit();
		
		return product;
	}
	public Brand saveBrand(Brand brand) {
		
		this.entityTransaction.begin();
		this.entityManager.persist(brand);
		this.entityTransaction.commit();
		
		return brand;
	}
	public Category saveCategory(Category category) {
		
		this.entityTransaction.begin();
		this.entityManager.persist(category);
		this.entityTransaction.commit();
		
		return category;
	}
	
	public List<Product> findProducts() {

//		Query query = this.entityManager.createQuery(ProductQueries.findProducts);
//		List<Product> products = query.getResultList();
		
		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findProducts, Product.class);
		List<Product> products = typedQuery.getResultList();
		
		return products;
	}
	public List<Product> findProductsEntitties(int firstResult, int maxResult) {
		
		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findProducts, Product.class);
		typedQuery.setFirstResult(firstResult);
		typedQuery.setMaxResults(maxResult);
		List<Product> products = typedQuery.getResultList();
		
		return products;
	}
	public Product findProductById(int productId) {
		
		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findProductId, Product.class);
		typedQuery.setParameter("productId", productId);
		Product product = typedQuery.getSingleResult();
		
		return product;
	}
	public List<ProductDetails> findProductDetails() {
		
		TypedQuery<ProductDetails> typedQuery = this.entityManager.createQuery(ProductQueries.findProductDetails, ProductDetails.class);
		List<ProductDetails> productDetails = typedQuery.getResultList();
		
		return productDetails;
	}
	public ProductDetails findProductDetailsById(int productId) {
		
		TypedQuery<ProductDetails> typedQuery = this.entityManager.createQuery(ProductQueries.findProductDetailsById, ProductDetails.class);
		typedQuery.setParameter("productId", productId);
		ProductDetails productDetails = typedQuery.getSingleResult();
		
		return productDetails;
	}
	public List<String> findProductNames() {

		TypedQuery<String> typedQuery = this.entityManager.createQuery(ProductQueries.findProductNames, String.class);
		List<String> productNames = typedQuery.getResultList();
		
		return productNames;
	}
	public List<Object[]> findProductNameAndPrice() {

		TypedQuery<Object[]> typedQuery = this.entityManager.createQuery(ProductQueries.findProductNamePrice, Object[].class);
		List<Object[]> productNameAndPrice = typedQuery.getResultList();
		
		return productNameAndPrice;
	}
	public List<Product> findSpecificPrice(double unitPrice) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findSpecificPrice, Product.class);
		typedQuery.setParameter("unitPrice", unitPrice);
		List<Product> products = typedQuery.getResultList();
		
		return products;
	}
	public List<Product> findLessMorePrice(double minUnitPrice, double maxUnitPrice) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findLessMorePrice, Product.class);
		typedQuery.setParameter("minUnitPrice", minUnitPrice);
		typedQuery.setParameter("maxUnitPrice", maxUnitPrice);
		List<Product> produts = typedQuery.getResultList();
		
		return produts;
	}
	public List<Product> findBetweenPrice(double minUnitPrice, double maxUnitPrice) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findBetweenPrice, Product.class);
		typedQuery.setParameter("minUnitPrice", minUnitPrice);
		typedQuery.setParameter("maxUnitPrice", maxUnitPrice);
		List<Product> produts = typedQuery.getResultList();
		
		return produts;
	}
	public List<Product> findLikeProductName(String productName) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findLikeProductName, Product.class);
		typedQuery.setParameter("productName", "%" + productName + "%");
		List<Product> products = typedQuery.getResultList();
		
		return products;
	}
	public List<Product> findInCategoryName(String categoryName1, String categoryName2) {

		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findInCategoryName, Product.class);
		typedQuery.setParameter("categoryName1", categoryName1);
		typedQuery.setParameter("categoryName2", categoryName2);
		List<Product> products = typedQuery.getResultList();
		
		return products;
	}
	public List<Product> findAllProduct(int categoryId) {
		
		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findAllProduct, Product.class);
		typedQuery.setParameter("categoryId", categoryId);
		List<Product> products = typedQuery.getResultList();
		
		return products;
	}
	public List<Object[]> findFunctionsPrice() {
		TypedQuery<Object[]> typedQuery = this.entityManager.createQuery(ProductQueries.findFunctionsPrice, Object[].class);
		List<Object[]> functionsPrice = typedQuery.getResultList();
		
		return functionsPrice;
	}
	public List<Object[]> findGroupByCategory() {
		TypedQuery<Object[]> typedQuery = this.entityManager.createQuery(ProductQueries.findGroupByCategory, Object[].class);
		List<Object[]> groupByCategory = typedQuery.getResultList();
		
		return groupByCategory;
	}
	public List<Object[]> findGroupByHavingCategory(double unitPrice) {

		TypedQuery<Object[]> typedQuery = this.entityManager.createQuery(ProductQueries.findGroupByHavingCategory, Object[].class);
		typedQuery.setParameter("unitPrice", unitPrice);
		List<Object[]> groupByHavingCategory = typedQuery.getResultList();
		
		return groupByHavingCategory;
	}
	public List<Product> findOrderByPrice() {
		
		TypedQuery<Product> typedQuery = this.entityManager.createQuery(ProductQueries.findOrderByPrice, Product.class);
		List<Product> products = typedQuery.getResultList();
		
		return products;
	}
	
	
}