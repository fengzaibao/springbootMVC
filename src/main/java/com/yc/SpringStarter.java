package com.yc;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot程序入口
@SpringBootApplication
public class SpringStarter {

	public static void main(String[] args) {
		SpringApplication.run(  SpringStarter.class   , args);
	}

}
