package com.sist.di2;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration // �ڵ� �޸� �Ҵ�
public class LocationConfig {
	// Mybatis�� ����Ŭ ���� => DataSource => Ȯ�� (BasicDataSource)
	@Bean("ds")
	public BasicDataSource dataSource() {
		// 1. �޸� �Ҵ�
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("smincy");
		ds.setPassword("134679");
		return ds;
	}

	// MyBatis�� ���� => getConn, disConn
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();

		ssf.setDataSource(dataSource());

		Resource res = new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);

		return ssf.getObject();
	}

	@Bean("dao")
	public LocationDAO locDao() throws Exception {
		LocationDAO dao = new LocationDAO();
		dao.setSqlSessionFactory(sqlSessionFactory());

		return dao;
	}

}
