package com.song.study.multidatasource.config;

import com.song.study.multidatasource.db.router.DataSourceType;
import com.song.study.multidatasource.db.router.DynamicDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.song.study.multidatasource.db.repository.mapper")
@PropertySource(value = "classpath:dataSource.properties")
public class DynamicDataSourceConfig implements ImportBeanDefinitionRegistrar, EnvironmentAware {
    private DataSource businessDS;
    private DataSource bigDateDS;

    @Override
    public void setEnvironment(Environment environment) {
        businessDS = initDataSource(environment, DataSourceType.Business.name());
        bigDateDS = initDataSource(environment, DataSourceType.BigData.name());
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<Object, Object> targetDataSources = new HashMap();
        targetDataSources.put(DataSourceType.Business, businessDS);
        targetDataSources.put(DataSourceType.BigData, bigDateDS);

        DynamicDataSource.addDataSourceType(DataSourceType.BigData);
        DynamicDataSource.addDataSourceType(DataSourceType.Business);

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
    }

    public DataSource initDataSource(Environment environment, String prefix) {
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment, prefix);

        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setPoolName(prefix + "HikariDataSourcePool");

        hikariConfig.setDriverClassName(propertyResolver.getProperty(".database.driverClassName"));
        hikariConfig.setJdbcUrl(propertyResolver.getProperty(".database.url"));
        hikariConfig.setUsername(propertyResolver.getProperty(".database.username"));
        hikariConfig.setPassword(propertyResolver.getProperty(".database.password"));
        hikariConfig.setMaxLifetime(propertyResolver.getProperty(".connection.maxLifeTime", Integer.class, 120000));
        hikariConfig.setConnectionTimeout(propertyResolver.getProperty(".connection.timeout", Integer.class, 2000));
        hikariConfig.setMinimumIdle(propertyResolver.getProperty(".pool.minPoolSize", Integer.class, 20));
        hikariConfig.setMaximumPoolSize(propertyResolver.getProperty(".pool.maxPoolSize", Integer.class, 300));
        hikariConfig.setConnectionInitSql("SELECT 1");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }
}