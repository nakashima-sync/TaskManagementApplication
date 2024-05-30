package com.example.demo.entity;

import java.sql.Date;

public class EntTask {
	private int task_id;
	private int depart_id;
	private String task_name;
	private Date task_limit;
	private String task_contents;
	private int task_checked;

	public EntTask() {
	}

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public int getDepart_id() {
		return depart_id;
	}

	public void setDepart_id(int depart_id) {
		this.depart_id = depart_id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public Date getTask_limit() {
		return task_limit;
	}

	public void setTask_limit(Date task_limit) {
		this.task_limit = task_limit;
	}

	public String getTask_contents() {
		return task_contents;
	}

	public void setTask_contents(String task_contents) {
		this.task_contents = task_contents;
	}

	public int getTask_checked() {
		return task_checked;
	}

	public void setTask_checked(int task_checked) {
		this.task_checked = task_checked;
	}

}