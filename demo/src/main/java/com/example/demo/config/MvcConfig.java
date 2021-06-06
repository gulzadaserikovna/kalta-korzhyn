package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public static Path getPath() {
        Path path = FileSystems.getDefault().getPath("files").toAbsolutePath();
        File filesDir = new File(path.toUri());
        if (!filesDir.exists()) {
            filesDir.mkdir();
        }
        return path;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations(String.valueOf(getPath().toUri()));
    }
}
