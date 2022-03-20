package com.sist.di;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
/*
 *	 <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE" p:username="smincy"
		p:password="134679" />

		<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds" p:configLocation="classpath:Config.xml" />

		<!-- Mybatis 생성 -->
		<bean id="dao" class="com.sist.di.EmpDAO"
		p:sqlSessionFactory-ref="ssf" />
 * 
 */
import org.springframework.core.io.Resource;

// app.xml 대신 => XML 대신 자바로 설정(5)
@Configuration
public class EmpConfig {
	@Bean("ds")
	public BasicDataSource basicDataSource() {
		BasicDataSource ds = new BasicDataSource();

		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("smincy");
		ds.setPassword("134679");

		return ds;
	}

	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(basicDataSource());
		Resource res = new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		return ssf.getObject();
	}

	@Bean("dao")
	public EmpDAO empDao() throws Exception {
		
		/*
		 * <bean id="dao" class="com.sist.di.EmpDAO"
			p:sqlSessionFactory-ref="ssf" />
		 */
		
		EmpDAO dao = new EmpDAO();
		dao.setSqlSessionFactory(sqlSessionFactory());
		return dao;
	}

}
