package com.icss.main;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.icss.controller"})
public class MainConfig {
	@Bean
	public UrlBasedViewResolver viewResolver(){
		UrlBasedViewResolver rsl=new UrlBasedViewResolver();
		rsl.setViewClass(JstlView.class);
		rsl.setPrefix("/");
		rsl.setSuffix(".jsp");
		return rsl;
	}
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver multiPartFileResolver(){
		CommonsMultipartResolver mprsl=new CommonsMultipartResolver();
		mprsl.setMaxUploadSize(1024L*1024L*10L);
		return mprsl;
	}
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
}
