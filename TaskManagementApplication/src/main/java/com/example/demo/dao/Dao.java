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
		db.update("INSERT INTO `task`(task_name,depart_id,task_contents,task_limit,task_checked) VALUES(?,?,?,?,?)",
				entity.getTask_name(), entity.getDepart_id(), entity.getTask_contents(), entity.getTask_limit(),
				entity.getTask_checked());
	}

	public EntTask getTask(int task_id) {
		Map<String, Object> result = db.queryForMap("SELECT * FROM `project` WHERE project_id = ?", task_id);
		EntTask entity = new EntTask();
		entity.setDepart_id((int) result.get("depart_id"));
		entity.setTask_checked((int) result.get("task_checked"));
		entity.setTask_contents((String) result.get("task_contents"));
		entity.setTask_id((int) result.get("task_id"));
		entity.setTask_limit((Date) result.get("task_limit"));
		entity.setTask_name((String) result.get("task_name"));
		return entity;
	}

	public List<EntTask> getTaskOfDepart(int depart_id) {
		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM `task` WHERE depart_id = ?", depart_id);
		List<EntTask> resultDb2 = new ArrayList<EntTask>();
		for (Map<String, Object> result1 : resultDb1) {
			EntTask entity = new EntTask();
			entity.setDepart_id((int) result1.get("depart_id"));
			entity.setTask_checked((int) result1.get("task_checked"));
			entity.setTask_contents((String) result1.get("task_contents"));
			entity.setTask_id((int) result1.get("task_id"));
			entity.setTask_limit((Date) result1.get("task_limit"));
			entity.setTask_name((String) result1.get("task_name"));
			resultDb2.add(entity);
		}
		return resultDb2;
	}

	public List<EntDepart> getDepartOfProject(int project_id) {
		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM `depart` WHERE project_id = ?",
				project_id);
		List<EntDepart> resultDb2 = new ArrayList<EntDepart>();
		for (Map<String, Object> depart : resultDb1) {
			EntDepart entity = new EntDepart();
			entity.setId((int) depart.get("depart_id"));
			entity.setUser_id((int) depart.get("user_id"));
			entity.setUser_name((String) db
					.queryForMap("SELECT user_name FROM `user` WHERE user_id = ?", new Object[] { entity.getUser_id() })
					.get("user_name"));
			entity.setUser_task(this.getTaskOfDepart(entity.getId()));
			resultDb2.add(entity);
		}
		return resultDb2;
	}

	public List<EntUser> getAllUser() {
		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM `user`");
		List<EntUser> resultDb2 = new ArrayList<EntUser>();
		for (Map<String, Object> result1 : resultDb1) {
			EntUser entity = new EntUser();
			entity.setUser_id((int) result1.get("user_id"));
			entity.setUser_name((String) result1.get("user_name"));
			resultDb2.add(entity);
		}
		return resultDb2;
	}

	public List<EntProject> getAllProject() {
		List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM `project`");
		List<EntProject> resultDb2 = new ArrayList<EntProject>();
		for (Map<String, Object> result1 : resultDb1) {
			EntProject entity = new EntProject();
			entity.setProject_id((int) result1.get("project_id"));
			entity.setProject_name((String) result1.get("project_name"));
			resultDb2.add(entity);
		}
		return resultDb2;
	}

	public EntProject getProject(int project_id) {
		Map<String, Object> result = db.queryForMap("SELECT * FROM `project` WHERE project_id = ?", project_id);
		EntProject entity = new EntProject();
		entity.setProject_id((int) result.get("project_id"));
		entity.setProject_name((String) result.get("project_name"));
		return entity;
	}

	public void update(EntProject entity) {
		db.update("UPDATE `project` SET project_name=? WHERE project_id=?",
				entity.getProject_name(), entity.getProject_id());
	}

	public void update(EntUser entity) {
		db.update("UPDATE `user` SET user_name=? WHERE user_id=?",
				entity.getUser_name(), entity.getUser_id());
	}

	public void update(EntTask entity) {
		db.update("UPDATE `task` SET task_name=?,depart_id=?,contents=?,date_limit=?,checked=? WHERE task_id=?",
				entity.getTask_name(), entity.getDepart_id(), entity.getTask_contents(), entity.getTask_limit(),
				entity.getTask_checked(), entity.getTask_id());
	}

	public void delete(String tableName, int id) {
		db.update("DELETE FROM `" + tableName + "` WHERE " + tableName + "_id=?", id);
	}
}
