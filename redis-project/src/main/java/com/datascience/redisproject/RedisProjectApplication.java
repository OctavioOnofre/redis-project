package com.datascience.redisproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
@SpringBootApplication
public class RedisProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisProjectApplication.class, args);
	}

}
