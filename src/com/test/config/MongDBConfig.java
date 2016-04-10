package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.test.db.TestDAO;

@Configuration
public class MongDBConfig {

	@Bean
	public TestDAO testDAO() {
		TestDAO manager = new TestDAO();
		return manager;
	}
}
