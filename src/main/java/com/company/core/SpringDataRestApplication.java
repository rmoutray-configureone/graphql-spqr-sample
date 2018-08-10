package com.company.core;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringDataRestApplication extends SpringBootServletInitializer {
    
    private final Logger log = LoggerFactory.getLogger(SpringDataRestApplication.class);

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurerAdapter() {

            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
                config.setRepositoryDetectionStrategy(
                        RepositoryDetectionStrategy.RepositoryDetectionStrategies.ALL);
            }
        };
    }

    /**
     * This module gets automatically registered in the ObjectMapper by Spring. It is used to stop the forced 
     * lazy loading of linked repository entities that would otherwise happen during serialization.
     * @return the hibernate5Module
     */
    @Bean
    public Module hibernate5Module() {
        return new Hibernate5Module();
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringDataRestApplication.class);
    }
	
    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }
    
    /**
     * ServletContextListener to clean up SQL Server JDBC driver when the context is destroyed. Otherwise it does 
     * not clean up after itself, and causes a memory leak.
     * @return
     */
    @Bean
    protected ServletContextListener listener() {

        return new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent sce) {
            }

            @Override
            public final void contextDestroyed(ServletContextEvent sce) {

                ClassLoader cl = Thread.currentThread().getContextClassLoader();

                Enumeration<Driver> drivers = DriverManager.getDrivers();
                while (drivers.hasMoreElements()) {
                    Driver driver = drivers.nextElement();

                    if (driver.getClass().getClassLoader() == cl) {

                        try {
                            log.info("Deregistering JDBC driver {}", driver);
                            DriverManager.deregisterDriver(driver);
                            log.info("Deregistration of JDBC driver {} complete.", driver);

                        } catch (SQLException ex) {
                            log.error("Error deregistering JDBC driver {}", driver, ex);
                        }

                    }
                }
            }
        };
    }
}
