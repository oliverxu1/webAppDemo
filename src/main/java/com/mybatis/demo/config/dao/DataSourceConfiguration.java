package com.mybatis.demo.config.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.mybatis.demo.dao")
public class DataSourceConfiguration {

    @Bean(name="dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setUsername( "root" );
        dataSource.setPassword( "123123" );
        //关闭连接后不自动commit
        dataSource.setDefaultAutoCommit(false);
        return dataSource;
    }
}
