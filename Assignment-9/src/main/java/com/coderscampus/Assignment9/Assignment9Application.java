package com.coderscampus.Assignment9;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.coderscampus")
public class Assignment9Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Assignment9Application.class, args);
		
		
	}

}
