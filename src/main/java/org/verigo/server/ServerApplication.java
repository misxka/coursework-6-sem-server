package org.verigo.server;

import com.cloudinary.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ServerApplication.class, args);

        Cloudinary cloudinary = new Cloudinary(ctx.getEnvironment().getProperty("cloudinary.url"));
        SingletonManager manager = new SingletonManager();
        manager.setCloudinary(cloudinary);
        manager.init();
    }
}
