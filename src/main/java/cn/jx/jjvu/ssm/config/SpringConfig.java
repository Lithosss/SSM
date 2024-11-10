package cn.jx.jjvu.ssm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({JdbcConfig.class, MyBatisConfig.class, ServiceConfig.class})
public class SpringConfig {



}
