package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.Dao;
import com.example.demo.entity.EntProject;
import com.example.demo.entity.EntTask;
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
		model.addAttribute("Tasklist",dao.taskOfDepart());
		return "home";
	}

	@RequestMapping("/project")
	public String project(Model model) {
		return "project.html";
	}

	@RequestMapping("/home/{id}")
	public String project_view(@PathVariable Long id, Model model) {
		return "home.html";
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
		System.out.println("データベース登録完了");
		return "redirect:user_view";
	}


	@RequestMapping("/user_view")
	public String user_view(Model model) {
		model.addAttribute("user_list", dao.getAllUser());
		return "user_view";
	}


	@RequestMapping("/project_add")
	public String project_add(Model model, EntProject entproject) {
		dao.insert(entproject);
		return "redirect:/home";

	}

	@RequestMapping("/task_add")
	public String task_add(Model model, EntTask enttask) {
		dao.insert(enttask);
		return "redirect:/home";

	}

	@RequestMapping("/task_edit")
	public String task_edit(Model model, EntTask enttask) {
		return "task_edit";
	
	}

	@RequestMapping("/task_edit_db")
	public String task_edit_db(Model model, EntTask enttask) {
		enttask.setDepart_id(1);
		enttask.setTask_checked(1);
		dao.insert(enttask);
		return "redirect:/home";

	}



	@RequestMapping("/project/delete/{id}")
	public String project_delete(@PathVariable Long id) {
		dao.delete("project", id);
		return "redirect:/home";
	}

	@RequestMapping("/user/delete/{id}")
	public String user_delete(@PathVariable Long id) {
		dao.delete("user", id);
		return "redirect:/home";
	}

	@RequestMapping("/task/delete/{id}")
	public String task_delete(@PathVariable Long id) {
		dao.delete("task", id);
		return "redirect:/home";
	}
	
	@RequestMapping("/task/update")
	public String task_update(EntTask enttask) {
		dao.update(enttask);
		return "redirect:task";
	}
	
}
