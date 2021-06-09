package com.daniel.lojalivros.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.daniel.lojalivros.service.DBService;

@Configuration
@Profile("testes")
public class TestesConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaBD() {
		this.dbService.InstanciaBD();
	}
}
