package com.ostanin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.ostanin", "com.ostanin.dao", "com.ostanin.service"})
public class JDBCConfig {

    @Bean
    public JdbcTemplate jdbcTemplate() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/restaurant?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Samara");
        dataSource.setUsername("root");
        dataSource.setPassword("kirill");
        return new JdbcTemplate(dataSource);
    }

}
