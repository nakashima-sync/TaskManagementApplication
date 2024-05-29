package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.EntProject;

public class Controller {
	@RequestMapping("/home")
	public String home(Model model) {
		return "home.html";
	}

	@RequestMapping("/project")
	public String project(Model model) {
		return "project.html";
	}

	@RequestMapping("/project/{id}")
	public String projectView(@PathVariable Long id, Model model) {
		return "redirect:/project";
	}

	@RequestMapping("/task/{id}")
	public String task(@PathVariable Long id, Model model) {
		return "task.html";
	}

	@RequestMapping("/user")
	public String user(Model model) {
		return "user.html";
	}

	@RequestMapping("/project_add")
	public String project_add(Model model) {
		EntProject entproject=new EntProject();
		entproject.setProject_id(entproject.getProject_id());
		entproject.setProject_name(entproject.getProject_name());		
		dao.insertDb(entproject);
		return "redirect:project";
	
		return "home.html";

	}
}
