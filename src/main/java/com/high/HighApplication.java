package com.high;

import com.high.proxy.app.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppV1Config.class)
@SpringBootApplication
public class HighApplication {

	public static void main(String[] args) {
		SpringApplication.run(HighApplication.class, args);
	}

}
