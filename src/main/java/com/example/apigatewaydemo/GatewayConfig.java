package com.example.apigatewaydemo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableHystrix
@Configuration
public class GatewayConfig {

    String path1 = "/mas/**";
    String serviceUrl1 = "lb://MAS-CLIENT/";
    String serviceId1 = "mas-client";
    String path2 = "/sam/**";
    String serviceUrl2 = "lb://SAM-CLIENT/";
    String serviceId2 = "sam-client";
    String hostPattern = "";
    String serviceUrl3 = "http://localhost:8090/";

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p.path(path1).uri(serviceUrl1).id(serviceId1))
                .route(p -> p.path(path2).uri(serviceUrl2).id(serviceId2))
                .build();
    }
}
