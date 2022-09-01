package com.pillarglobal.sitemap.news.manager.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SitemapNewsManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SitemapNewsManagerApiApplication.class, args);
	}

}
