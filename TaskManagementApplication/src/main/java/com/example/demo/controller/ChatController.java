package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.Dao;
import com.example.demo.entity.EntProject;
import com.example.demo.entity.EntUser;

@Controller
public class ChatController {

	public final Dao dao; 

	@Autowired
	public ChatController(Dao dao) {
		this.dao = dao;
	}

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

	@RequestMapping("/user_add")
	public String user(Model model) {
		return "user_add.html";
	}
	@RequestMapping("/user_add_db")
	public String user_add(Model model, EntUser entuser) {
		dao.insert(entuser);
		System.out.println("データベース登録完了");
		return "home.html";
	}

	@RequestMapping("/project_add")
	public String project_add(Model model, EntProject entproject) {
		dao.insert(entproject);
		return "redirect:/project";
	
	}
}
