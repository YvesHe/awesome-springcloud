/*
 * YvesHe: a project for test.
 * Copyright (c) 2016-present, www.yveshe.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.yveshe.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 数据源配置
 * * @Configuration作用: 告诉spring, 这是一个配置类
 *
 * @author yveshe (yveshe@aliyun.com)
 * @create 04 30, 2020
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class DataSourceConfig {

    /**
     * @Bean作用: 该注解放在方法上, 会向spring容器自动生成一个名称为该方法名称,类型为返回值值类型的对象
     * @ConfigurationProperties注解作用: 绑定前缀, 比如前缀为foo.datasource, 会将配置属性中为该前缀的属性注入到DataSourceProperties中.
     */
    @Bean
    @ConfigurationProperties("foo.datasource")
    public DataSourceProperties fooDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource fooDataSource() {
        DataSourceProperties dataSourceProperties = fooDataSourceProperties();
        log.info("foo datasource: {}", dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public JdbcTemplate fooJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(fooDataSource());
        return jdbcTemplate;
    }


    /**
     * @Bean作用: 该注解放在方法上, 会向spring容器自动生成一个名称为该方法名称,类型为返回值值类型的对象
     * @Resource 作用: 从spring容器中找到一个参数类型为DataSource的实例注入到该方法中.
     */
    @Bean
    @Resource
    public PlatformTransactionManager fooTxManager(DataSource fooDataSource) {
        return new DataSourceTransactionManager(fooDataSource);
    }

    //////////////////////////////////////////////////////////////////////////////

    @Bean
    @ConfigurationProperties("bar.datasource")
    public DataSourceProperties barDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource barDataSource() {
        DataSourceProperties dataSourceProperties = barDataSourceProperties();
        log.info("bar datasource: {}", dataSourceProperties.getUrl());
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager barTxManager(DataSource barDataSource) {
        return new DataSourceTransactionManager(barDataSource);
    }

    @Bean
    public JdbcTemplate barJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(barDataSource());
        return jdbcTemplate;
    }


}