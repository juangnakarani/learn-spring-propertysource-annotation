/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.propertysource.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 *
 * @author juang
 */
@Configuration
@ComponentScan(basePackages = {"com.mycompany.spring.propertysource"})
@PropertySource("classpath:data-access.properties")
public class AppConfig {
    //spring merekomendasikan penggunaan Environment
    @Autowired
    private Environment env;

    @Value("${user.name}")
    private String userName;

    @Value("${password.db}")
    private String passwordDb;

    //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
    
    //percobaan sederhana hasil read config ke sebuah class dengan methode IoC
    @Bean
    public DummyDataSource dataSource() {
        String userName = env.getProperty("user.name");
        String passwordDb = env.getProperty("password.db");
        return new DummyDataSource(userName, passwordDb);
    }

}
