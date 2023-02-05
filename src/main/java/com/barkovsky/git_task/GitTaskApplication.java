package com.barkovsky.git_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.barkovsky.git_task.repository.api")
public class GitTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitTaskApplication.class, args);
	}

}
