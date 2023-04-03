package com.flower.navigation.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;


/**
 * 
 * 
 * 数据库连接配置 读取sqlite db
 * @author flower
 *
 */
@Configuration
public class DataSourceConfig {
    @Value("${db.url}")
    private String dbUrl;

	@Bean(destroyMethod = "", name = "EmbeddedDataSource")
    public DataSource dataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
        dataSourceBuilder.url(dbUrl);
        dataSourceBuilder.type(SQLiteDataSource.class);
        return dataSourceBuilder.build();
    }
}
