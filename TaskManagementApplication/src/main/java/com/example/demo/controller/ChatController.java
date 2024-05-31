package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.Dao;
import com.example.demo.entity.EntDepart;
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
		model.addAttribute("projectList", dao.getAllProject());
		model.addAttribute("userList", dao.getAllUser());
		return "home.html";
	}

	@RequestMapping("/home/{id}")
	public String project_view(@PathVariable("id") int id, Model model) {
		model.addAttribute("projectid", id);
		model.addAttribute("projectList", dao.getAllProject());
		model.addAttribute("departList", dao.getDepartOfProject(id));
		return "home_task";
	}

	@RequestMapping("/project_add")
	public String project_add(Model model, EntProject entproject) {
		return "project_add.html";
	}

	@RequestMapping("/project_add_db")
	public String project_add_db(Model model, EntProject entproject) {
		dao.insert(entproject);
		return "redirect:/home";
	}

	@RequestMapping("/user_add")
	public String user_add(Model model, EntUser entuser) {
		return "user_add";
	}

	@RequestMapping("/user_add_db")
	public String user_add_db(Model model, EntUser entuser) {
		dao.insert(entuser);
		return "redirect:home";
	}

	@RequestMapping("/project_setting/{id}")
	public String project_setting(@PathVariable("id") int id, Model model, EntProject entproject, EntDepart entdepart) {
		model.addAttribute("projectData", dao.getProject(id));
		model.addAttribute("userList", dao.getAllUser());
		return "project_setting";
	}

	@RequestMapping("/project_setting_db")
	public String project_setting_db(Model model, EntProject entproject) {
		dao.update(entproject);
		return "redirect:/project_setting";
	}

	@RequestMapping("/task_add/{id}")
	public String task_add(@PathVariable("id") int id,Model model, EntTask enttask, EntDepart entdepart) {
		model.addAttribute("depart_id", id);
		return "task_add";
	}

	@RequestMapping("/task_add_db/{id}")
	public String task_add_db(@PathVariable("id") int id,Model model, EntTask enttask, EntDepart entdepart) {
		enttask.setDepart_id(id);
		enttask.setTask_checked(0);
		List<EntDepart> list = dao.getProjectOfDepart(enttask.getDepart_id());
		int project_id = list.get(0).getProject_id(); 	
		dao.insert(enttask);
		return "redirect:/home/" + project_id ; 
	}

	@RequestMapping("/task_edit/{id}")
	public String task_edit(@PathVariable int id, Model model, EntTask enttask, EntDepart entdepart) {
		model.addAttribute("taskData", dao.getTask(id));
		return "task_edit.html";
	}

	@RequestMapping("/task_edit_db")
	public String task_edit_db(Model model, EntTask enttask, EntDepart entdepart) {
		dao.update(enttask);
		return "redirect:/home/" + entdepart.getProject_id();
	}

	@RequestMapping("/project/delete/{id}")
	public String project_delete(@PathVariable int id) {
		dao.delete("project", id);
		return "redirect:/home";
	}

	@RequestMapping("/task/delete/{id}")
	public String task_delete(@PathVariable int id, EntDepart entdepart) {
		dao.delete("task", id);
		return "redirect:/home/" + entdepart.getProject_id();
	}

	@RequestMapping("/task/checked/{task_id}/{depart_id}")
	public String task_checked(@PathVariable("task_id") int task_id, @PathVariable("depart_id") int depart_id) {
		EntTask enttask = dao.getTask(task_id);		
		enttask.setTask_checked(1 - enttask.getTask_checked());
		dao.update(enttask);
		return "redirect:/home/" + depart_id;
	}

	@RequestMapping("/user_edit/{id}")
	public String user_edit(@PathVariable int id, Model model, EntUser entuser) {
		model.addAttribute("userData", dao.getUser(id));
		return "user_edit";
	}

	@RequestMapping("/user_edit_db")
	public String user_edit_db(Model model, EntUser entuser) {
		dao.update(entuser);
		return "redirect:user_view";
	}

	@RequestMapping("/user/delete/{id}")
	public String user_delete(@PathVariable int id) {
		dao.delete("user", id);
		return "redirect:/home";
	}
}
