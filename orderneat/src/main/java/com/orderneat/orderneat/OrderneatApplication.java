package com.orderneat.orderneat;

import com.orderneat.orderneat.config.YamlConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.yaml.snakeyaml.Yaml;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class OrderneatApplication implements CommandLineRunner {

	@Autowired
	private YamlConfig myConfig;

	public static void main(String[] args) {
		SpringApplication.run(OrderneatApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("using environment: " + myConfig.getEnvironment());
		System.out.println("name: " + myConfig.getName());
		System.out.println("enabled:" + myConfig.isEnabled());
		System.out.println("servers: " + myConfig.getServers());
	}
}
