package com.greatech.server.rkg.config.mysql;


import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = RKGDataSourceConfig.PACKAGE, sqlSessionTemplateRef = "RKGSqlSessionTemplate")
@PropertySource("classpath:application.properties")
public class RKGDataSourceConfig {

    static final String PACKAGE = "com.greatech.server.rkg.dao";

    @Value("${spring.datasource.greatech-rkg.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.greatech-rkg.url}")
    private String url;
    @Value("${spring.datasource.greatech-rkg.username}")
    private String username;
    @Value("${spring.datasource.greatech-rkg.password}")
    private String password;

    @Value("${mybatis.greatech-rkg.mapper-locations}")
    private String mapperLocations;
    @Value("${mybatis.greatech-rkg.type-aliases-package}")
    private String type_aliases_package;

    /**
     * 创建数据源
     */
    //commons.dbcp2 ---> destroyMethod = ""
    @Bean(name = "RKGDataSource", destroyMethod = "")
    @Primary
    public DataSource rkgDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaximumPoolSize(12);
        dataSource.setMinimumIdle(10);
        dataSource.setConnectionTestQuery("SELECT 1");
        return dataSource;
    }

    /**
     * 创建工厂
     */
    @Bean(name = "RKGSqlSessionFactory")
    @Primary
    public SqlSessionFactory rkgSqlSessionFactory(@Qualifier("RKGDataSource") DataSource RKGDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(RKGDataSource);
        sessionFactory.setTypeAliasesPackage(type_aliases_package);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(mapperLocations));
        return sessionFactory.getObject();
    }

    /**
     * 创建事务
     */
    @Bean(name = "RKGTransactionManager")
    @Primary
    public DataSourceTransactionManager rkgTransactionManager() {
        return new DataSourceTransactionManager(rkgDataSource());
    }

    /**
     * 创建模板
     */
    @Bean(name = "RKGSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("RKGSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
