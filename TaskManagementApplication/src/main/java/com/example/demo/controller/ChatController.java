package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.Dao;
import com.example.demo.entity.EntUser;

@Controller
public class ChatController {

	private final Dao dao; 

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
		return "user_add";
	}
	@RequestMapping("/user_add_db")
	public String user_add(Model model, EntUser entuser) {
		System.out.println(entuser.toString());
		dao.insert(entuser);
		System.out.println("完了");
		return "redirect:/user_add";
	}
}
