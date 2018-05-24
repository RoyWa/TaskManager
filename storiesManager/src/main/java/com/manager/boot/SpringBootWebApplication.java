package com.manager.boot;

import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = { "com.manager" })
@ImportResource("classpath:manager.xml")
//@EntityScan(basePackages = "com.manager.persistent.entity")
@ComponentScan(basePackages = "com.manager")
@EnableAutoConfiguration(
        exclude = { org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class })
public class SpringBootWebApplication extends SpringBootServletInitializer {

    private static final Logger log = LogManager.getLogger(SpringBootWebApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    @PostConstruct
    void setUTCTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent sce) {
                log.info("Manager server is started");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                log.info("Manager server is down");
            }
        };
    }

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SpringBootWebApplication.class);
        //        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
