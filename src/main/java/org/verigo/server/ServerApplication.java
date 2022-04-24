package org.verigo.server;

import com.cloudinary.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ServerApplication {
    @Value("${cloudinary.cloudname}")
    private String cloudName;

    @Value("${cloudinary.api.key}")
    private String apiKey;

    @Value("${cloudinary.api.secret}")
    private String apiSecret;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public Cloudinary cloudinaryConfig() {
        Map config = new HashMap();
        config.put("cloud_name", cloudName);
        config.put("api_key", apiKey);
        config.put("api_secret", apiSecret);
        Cloudinary cloudinary = new Cloudinary(config);
        return cloudinary;
    }
}
