package pe.edu.i202210933.cl1_jpa_data_ponce_rosa.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConexionesConfig {

    @Value("${DB_WORLD_URL}")
    private String dbWordUrl;
    @Value("${DB_WORLD_USER}")
    private String dbWordUser;
    @Value("${DB_WORLD_PASS}")
    private String dbWordPass;
    @Value("${DB_WORLD_DRIVER}")
    private String dbWordDriver;

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariConfig  config = new HikariConfig ();
        config.setJdbcUrl(dbWordUrl);
        config.setUsername(dbWordUser);
        config.setPassword(dbWordPass);
        config.setDriverClassName(dbWordDriver);

        config.setMaximumPoolSize(30);
        config.setMinimumIdle(4);
        config.setIdleTimeout(240000);
        config.setConnectionTimeout(45000);

        return new HikariDataSource(config);
    }
}
