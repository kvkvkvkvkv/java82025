package com.java.java8;

import com.java.java8.service.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class Java8Application {

	@Autowired
	Streams streams;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Java8Application.class, args);
		Java8Application app = context.getBean(Java8Application.class); // Get an instance of the application
		app.run();
	}

	public void run() {
		streams.print(Arrays.asList(1,2,3,4,5,6,7,8,9));
		streams.printCourses(Arrays.asList("Math", "Science", "English", "Physics", "Psycology", "Physiology"));
	}

}
