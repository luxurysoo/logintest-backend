package com.innoinc.logintestbackend.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({"classpath:/db.properties"})
@MapperScan(value="com.innoinc.logintestbackend.dao", sqlSessionFactoryRef="postgresSqlSessionFactory")
public class PostgresDatabaseConfig {
	
	@Bean(name = "postgresDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.postgres.datasource")
    public DataSource postgresDataSource() {
		return DataSourceBuilder.create().build();
    }
 
    @Bean(name = "postgresSqlSessionFactory")
    @Primary
    public SqlSessionFactory postgresSqlSessionFactory(@Qualifier("postgresDataSource") DataSource postgresDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(postgresDataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.innoinc.logintestbackend.model");
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
 
    @Bean(name = "postgresSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate postgresSqlSessionTemplate(SqlSessionFactory postgresSqlSessionFactory) throws Exception {
 
        return new SqlSessionTemplate(postgresSqlSessionFactory);
    }
    
    @Bean(name = "postgresTxManager")
    public PlatformTransactionManager postgresTxManager(DataSource postgresDataSource) {
        return new DataSourceTransactionManager(postgresDataSource);
    }
    
}
