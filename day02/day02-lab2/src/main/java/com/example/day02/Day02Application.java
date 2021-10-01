package com.example.day02;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Day02Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Day02Application.class, args);
		log.info("bean definition count {}", context.getBeanDefinitionCount());
		Stream.of(context.getBeanDefinitionNames()).forEach(name -> log.info("bean deinition name {}", name));
	}

}
