package com.tamrakar.api_gateway_server.discovery_service_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceServerApplication.class, args);
    }
}
