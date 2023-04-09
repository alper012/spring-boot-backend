package com.sample.springgraphql.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class SpringBootGraphqlMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlMysqlApplication.class, args);
	}


	@Configuration
	@Profile("local")
	public class LocalCorsConfiguration {

		@Bean
		public CorsFilter corsFilter() {
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			final CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true);
			config.addAllowedOrigin("*");
			config.addAllowedHeader("*");
			config.addAllowedMethod("*");
			source.registerCorsConfiguration("/apis/graphql", config);
			return new CorsFilter(source);
		}
	}



}
