package com.example.mail;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;


@SpringBootApplication
public class MailApplication {
	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties p = new Properties();
		p.setProperty("helperDialect", "Mysql");
		p.setProperty("supportMethodsArguments", "true");
		p.setProperty("reasonable", "false");
		p.setProperty("params", "count=countSql");
		pageHelper.setProperties(p);
		return pageHelper;
	}
	/**
	 * 给mybatis注入分页插件
	 * 防止mybatis分页插件不生效
	 **/
	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);
	}
}


