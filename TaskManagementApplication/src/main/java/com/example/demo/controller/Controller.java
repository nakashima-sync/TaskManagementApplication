package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
