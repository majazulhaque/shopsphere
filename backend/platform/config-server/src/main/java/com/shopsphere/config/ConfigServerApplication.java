package com.shopsphere.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ShopSphere Config Server.
 *
 * <p>Serves the files in {@code config-repo/} to every service (Blueprint PL-7).
 * The native backend reads them straight from the monorepo, so configuration is
 * versioned and reviewed together with the code.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
