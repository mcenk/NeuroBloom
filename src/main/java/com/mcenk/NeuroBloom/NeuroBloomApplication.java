package com.mcenk.NeuroBloom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class  NeuroBloomApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeuroBloomApplication.class, args);
	}

}
