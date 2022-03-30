//package com.bicar.Repository;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//@Configuration
//@Component
//
//public class datasourcebit {
//
//
//		@ConfigurationProperties(prefix = "spring.datasource")
//		@Bean
//		@Primary
//		public DataSource getDataSource() {
//			return DataSourceBuilder
//					.create()
//					.url("jdbc:mysql://localhost:3306/bicar")
//					.username("root")
//					.password("root")
//					.driverClassName("com.mysql.jdbc.Driver")
//					.build();
//		}
//	}
//	
//	
//	
//
