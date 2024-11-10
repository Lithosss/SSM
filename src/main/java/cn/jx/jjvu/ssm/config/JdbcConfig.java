package cn.jx.jjvu.ssm.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


@PropertySource("classpath:db.properties")
public class JdbcConfig {
    @Value("${mysql.driver}")
    private String driver;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.maxTotal}")
    private int maxTotal;
    @Value("${mysql.minPoolSize}")
    private int minPoolSize;
    @Value("${mysql.initialSize}")
    private int initialSize;


    @Bean("dataSource")
    public DataSource getDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        dataSource.setMaxPoolSize(maxTotal);
        dataSource.setMinPoolSize(minPoolSize);
        dataSource.setInitialPoolSize(initialSize);

        return dataSource;
    }


}
