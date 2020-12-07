package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserClient {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:beans.xml");
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		Connection conn = dataSource.getConnection(); // throws SQLException
		System.out.println(conn);
	}
}
