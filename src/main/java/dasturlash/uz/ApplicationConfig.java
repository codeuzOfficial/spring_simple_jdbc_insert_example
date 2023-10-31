package dasturlash.uz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@ComponentScan(basePackages = "dasturlash.uz")
@Configuration
public class ApplicationConfig {

    @Bean
    public SimpleJdbcInsert simpleJdbcInsert() {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource());
        return simpleJdbcInsert;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/java_db");
        dataSource.setUsername("java_db_user");
        dataSource.setPassword("root");

        return dataSource;
    }

}
