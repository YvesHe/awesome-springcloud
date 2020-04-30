package com.yveshe;

import com.yveshe.datasource.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//exclude 排序springboot自己对数据源,事务管理,JDBC的配置,也就是说我们要自己配置.
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class
})
@Slf4j
public class SpringcloudDatasourceMultiApplication implements CommandLineRunner {

    @Autowired
    private DynamicDataSource dynamicDataSource;

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDatasourceMultiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        DataSource fooDataSource = dynamicDataSource.getFooDataSource();
        showConnection(fooDataSource);

        DataSource barDataSource = dynamicDataSource.getBarDataSource();
        showConnection(barDataSource);
    }


    /**
     * 打印连接信息
     *
     * @throws SQLException
     */
    public void showConnection(DataSource dataSource) throws SQLException {
        log.warn(dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.warn(connection.toString());
        connection.close();
    }


}