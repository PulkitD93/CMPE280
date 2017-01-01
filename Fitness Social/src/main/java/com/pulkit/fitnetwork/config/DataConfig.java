package com.pulkit.fitnetwork.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sound.midi.SysexMessage;
import javax.sql.DataSource;

@Configuration
public class DataConfig {

    @Bean
    public BasicDataSource dataSource() {
        String hostname = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String connectionUrl = "jdbc:mysql://" + hostname + ":" + port + "/fitbitsocialnetwork";
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl(connectionUrl);
        basicDataSource.setUsername("adminFHATqUN");
        basicDataSource.setPassword("JWZXK8p1EU-l");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxTotal(10);
        return basicDataSource;
    }

    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
