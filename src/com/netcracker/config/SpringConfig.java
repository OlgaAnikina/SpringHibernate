package com.netcracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.netcracker")
@PropertySource(value = {"classpath:application.properties"})
public class SpringConfig {

    @Autowired
    Environment enviroment;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(enviroment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(enviroment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(enviroment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(enviroment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }


}
