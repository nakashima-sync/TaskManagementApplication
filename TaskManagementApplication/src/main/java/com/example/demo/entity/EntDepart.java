package com.example.demo.entity;

import java.util.List;

public class EntDepart {
	private int id;
	private int project_id;
	private int user_id;
	private String user_name;
	private List<EntTask> user_task;

	public EntDepart() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public List<EntTask> getUser_task() {
		return user_task;
	}

	public void setUser_task(List<EntTask> user_task) {
		this.user_task = user_task;
	}

}
