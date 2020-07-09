package com.dentsu.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringHiveJdbcTemplateApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void SqlTest1()
	{
		String Sql = "select\n" +
				"  google_campaign_manager__gm_na_api.site_dcm," +
				"  google_campaign_manager__gm_na_api.activity," +
				" count(*) " +
				"      from google_campaign_manager__gm_na_api" +
				"      group by " +
				"            google_campaign_manager__gm_na_api.site_dcm," +
				"            google_campaign_manager__gm_na_api.activity" +
				"            Limit 5;";
		List<Map<String, Object>> rows = null;
		rows = jdbcTemplate.queryForList(Sql);
	}

}
