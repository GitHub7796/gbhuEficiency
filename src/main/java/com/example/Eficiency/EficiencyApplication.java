package com.example.Eficiency;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.Eficiency.mapper")
public class EficiencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EficiencyApplication.class, args);
	}

}
