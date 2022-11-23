package com.classylab.youtubeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class YoutubeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoutubeapiApplication.class, args);
	}

}
