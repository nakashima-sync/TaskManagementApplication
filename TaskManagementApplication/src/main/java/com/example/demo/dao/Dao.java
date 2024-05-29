package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class Dao {
	private final JdbcTemplate db;

	@Autowired
	public Dao(JdbcTemplate db) {
		this.db = db;
	}
}
