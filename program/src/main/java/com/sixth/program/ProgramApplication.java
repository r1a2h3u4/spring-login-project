package com.sixth.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramApplication.class, args);
        System.out.println("Springboot Application Started");
	}

}
