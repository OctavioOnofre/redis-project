package com.datascience.redisproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableRedisRepositories
public class RedisProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(RedisProjectApplication.class, args);
	}

}
