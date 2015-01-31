package ru.dmilut.prodlenka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.service.UnitService;

@Controller
public class UnitController {

	@Autowired
	private UnitService unitService;

	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}

	@RequestMapping("/units")
	public String units(Model model) {
		model.addAttribute("units", unitService.findAll());
		return "units";
	}

}
