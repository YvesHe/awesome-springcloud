package com.yvehse.springclouddatasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement //启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
public class SpringcloudDatasourceApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudDatasourceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    /**
     * 打印连接信息
     *
     * @throws SQLException
     */
    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }


    /**
     * 通过jdbacTemplate的方式查询数据
     */
    private void showData() {
        jdbcTemplate.queryForList("SELECT * FROM FOO").forEach(row -> log.info(row.toString()));
    }
}
