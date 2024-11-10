package cn.jx.jjvu.ssm.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@ComponentScan("cn.jx.jjvu.ssm")
@EnableTransactionManagement
public class ServiceConfig {
    @Bean("transactionManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(@Autowired DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
