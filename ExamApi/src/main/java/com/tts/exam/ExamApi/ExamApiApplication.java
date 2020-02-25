package com.tts.exam.ExamApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApiApplication.class, args);
	}

}
