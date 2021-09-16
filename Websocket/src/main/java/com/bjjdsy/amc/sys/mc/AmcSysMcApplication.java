package com.bjjdsy.amc.sys.mc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan(basePackages = "com.bjjdsy.amc.sys.mc.mapper")
public class AmcSysMcApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AmcSysMcApplication.class);
		app.setWebEnvironment(false);
		app.addListeners(new ApplicationStartup());
		app.run(args);
	}
}
