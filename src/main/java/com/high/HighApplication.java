package com.high;

import com.high.proxy.config.AppV1Config;
import com.high.proxy.config.AppV2Config;
import com.high.proxy.config.AppV3Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import({AppV1Config.class, AppV2Config.class})
@SpringBootApplication(scanBasePackages = "com.high.proxy.app")
public class HighApplication {

	public static void main(String[] args) {
		SpringApplication.run(HighApplication.class, args);
	}

}
