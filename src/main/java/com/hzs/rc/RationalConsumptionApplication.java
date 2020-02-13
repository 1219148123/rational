package com.hzs.rc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.hzs.rc.mapper")
@SpringBootApplication
@EnableSwagger2
public class RationalConsumptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RationalConsumptionApplication.class, args);
	}

}
