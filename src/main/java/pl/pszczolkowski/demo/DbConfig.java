package pl.pszczolkowski.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("USE mojabaza");
        return jdbcTemplate;
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void createTable(){
//        getJdbcTemplate().update("USE mojabaza");
//        getJdbcTemplate().update("CREATE TABLE cars(car_id int, mark varchar(255), model varchar(255), color varchar(255),  productionDate int, PRIMARY KEY (car_id))");
//    }
}
