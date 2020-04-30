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
package com.yveshe.datasource;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author yveshe (yveshe@aliyun.com)
 * @create 04 30, 2020
 * @since 1.0.0
 */
@Slf4j
@Component
@Data
public class DynamicDataSource {

    //为什么不能使用@Autowired了,因为有多个对象了
    @Resource(name = "fooDataSource")
    private DataSource fooDataSource;

    @Resource(name = "barDataSource")
    private DataSource barDataSource;

    /**
     * 打印连接信息
     *
     * @throws SQLException
     */
    public void showConnection() throws SQLException {
        log.warn(fooDataSource.toString());
        Connection conn1 = fooDataSource.getConnection();
        log.warn(conn1.toString());
        conn1.close();

        log.warn(barDataSource.toString());
        Connection conn = barDataSource.getConnection();
        log.warn(conn.toString());
        conn.close();
    }

}

