package com.st.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.st.repo.ProductRepository;
import com.st.repo.ProductRepository.ViewA;
import com.st.repo.ProductRepository.ViewB;

@Component
public class ConsoleRunner implements CommandLineRunner {

@Autowired
private ProductRepository repo;
	@Override
	public void run(String... args) throws Exception {
	//Static projection	
	//repo.findByProdCost(6.5).forEach(s->System.out.println(s.getProdId()+"\t"+s.getProdName()));
	//repo.findByProdModel("database").forEach(s1->System.out.println(s1.getProdName()+"\t"+s1.getProdCost()));
		
		System.out.println("all objecct saved on date: "+LocalDate.now());
		//dynamic projection
		repo.findByProdModel("ides", ViewA.class).forEach(s->System.out.println(s.getProdCost()+"\t"+s.getProdName()));
		repo.findByProdModel("fwork", ViewB.class).forEach(s->System.out.println(s.getProdId()+"\t"+s.getProdName()));
	}

}
