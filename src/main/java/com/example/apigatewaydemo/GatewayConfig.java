package com.example.apigatewaydemo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private final String path1 = "/mas/**";
    private final String serviceUrl1 = "lb://MAS-CLIENT/";
    private final String serviceId1 = "mas-client";
    private final String path2 = "/sam/**";
    private final String serviceUrl2 = "lb://SAM-CLIENT/";
    private final String serviceId2 = "sam-client";
    private final String hystrixName1 = "Hystrix-Service-1";
    private final String hystrixName2 = "Hystrix-Service-2";
    private final String hystrixFallbackUri = "forward:/fallback/message";

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route(p -> p
                        .path(path1)
                        .filters(
                                f -> f.hystrix(h ->
                                        h.setName(hystrixName1).setFallbackUri(hystrixFallbackUri)))
                        .uri(serviceUrl1).id(serviceId1))
                .route(p -> p
                        .path(path2)
                        .filters(
                                f -> f.hystrix(h ->
                                        h.setName(hystrixName2).setFallbackUri(hystrixFallbackUri)))
                        .uri(serviceUrl2).id(serviceId2))
                .build();
    }
}
