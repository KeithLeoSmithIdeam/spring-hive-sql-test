package com.dentsu.sample.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.hadoop.security.UserGroupInformation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class HiveDataSourceConfig {

	@Value("${dentsu.hive.connectionURL}")
	private String hiveConnectionURL;

	@Value("${dentsu.hive.username}")
	private String userName;

	@Value("${dentsu.hive.password}")
	private String password;

	public DataSource getHiveDataSource() throws IOException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(this.hiveConnectionURL);
		dataSource.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
		dataSource.setUsername(this.userName);
		dataSource.setPassword(this.password);
		return dataSource;
	}
	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJDBCTemplate() throws IOException {
		return new JdbcTemplate(getHiveDataSource());
	}
}

