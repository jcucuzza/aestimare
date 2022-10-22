package com.ae.landfill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LandfillApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandfillApplication.class, args);
	}

}
