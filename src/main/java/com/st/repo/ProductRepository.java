package com.st.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.st.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	interface ViewA{
		String getProdName();
		double getProdCost();
	}
	interface ViewB{
		Integer getProdId();
		String getProdName();
	}//static projection
	//List<ViewA> findByProdModel(String prodModel);
	//List<ViewB> findByProdCost(double prodcost);
	//dynamic projection
	<T> List<T>findByProdModel(String model,Class<T> cls);
}


