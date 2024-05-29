package com.example.demo.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntDepart;
import com.example.demo.entity.EntProject;
import com.example.demo.entity.EntTask;
import com.example.demo.entity.EntUser;

@Repository
public class Dao {
	private final JdbcTemplate db;

	@Autowired
	public Dao(JdbcTemplate db) {
		this.db = db;
	}

	public void insert(EntProject entity) {
		db.update("INSERT INTO `project`(project_name) VALUES(?)", entity.getProject_name());
	}

	public void insert(EntUser entity) {
		db.update("INSERT INTO `user`(user_name) VALUES(?)", entity.getUser_name());
	}

	public void insert(EntDepart entity) {
		db.update("INSERT INTO `depart`(user_id,project_id) VALUES(?,?)", entity.getUser_id(), entity.getProject_id());
	}

	public void insert(EntTask entity) {
		db.update("INSERT INTO `task`(task_name,depart_id,contents,date_limit,checked) VALUES(?,?,?,?)",
				entity.getTask_name(), entity.getDepart_id(), entity.getTask_contents(), entity.getTask_limit(),
				entity.getTask_checked());
	}

	public List<EntTask> taskOfDepart(int depart_id) {
		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM `task` WHERE depart_id = ?", depart_id);
		List<EntTask> resultDb2 = new ArrayList<EntTask>();
		for (Map<String, Object> result1 : resultDb1) {
			EntTask entity = new EntTask();
			entity.setDepart_id((int) result1.get("depart_id"));//result1.get("depart_id") = depart_id(�����������)
			entity.setTask_checked((int) result1.get("checked"));
			entity.setTask_contents((String) result1.get("contents"));
			entity.setTask_id((int) result1.get("task_id"));
			entity.setTask_limit((Date) result1.get("date_limit"));
			entity.setTask_name((String) result1.get("task_name"));
			resultDb2.add(entity);
		}
		return resultDb2;
	}

	public void update(Long id, EntTask entity) {
		db.update("UPDATE `task` SET task_name=?,depart_id=?,contents=?,date_limit=?,checked=? WHERE task_id=?",
				entity.getTask_name(), entity.getDepart_id(), entity.getTask_contents(), entity.getTask_limit(),
				entity.getTask_checked(), entity.getTask_id());
	}
}
