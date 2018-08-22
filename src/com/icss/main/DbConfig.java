package com.icss.main;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@MapperScan(basePackages={"com.icss.dao"})
@ComponentScan("com.icss.service")
@EnableTransactionManagement
public class DbConfig {
	@Bean
	public DataSource dataSource() throws Exception{
		ComboPooledDataSource pool=new ComboPooledDataSource();
		pool.setJdbcUrl("jdbc:mysql://localhost:3306/stu2016");
		pool.setDriverClass("com.mysql.jdbc.Driver");
		pool.setUser("root");
		pool.setPassword("127");
		return pool;
	}
	@Bean
	public SqlSessionFactory sessionFactory() throws Exception{
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(this.dataSource());
		return bean.getObject();
	}
	@Bean
	public PlatformTransactionManager transcationManager() throws Exception{
		DataSourceTransactionManager txm=new DataSourceTransactionManager(this.dataSource());
		return txm;
	}
}
