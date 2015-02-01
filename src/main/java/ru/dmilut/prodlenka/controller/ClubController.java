package ru.dmilut.prodlenka.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.service.ClubService;
import ru.dmilut.prodlenka.service.UnitService;
import ru.dmilut.prodlenka.service.UserService;

@Controller
public class ClubController {

	@Autowired
	private ClubService clubService;
	
	@ModelAttribute("user")
	public User constructUser() {

		return new User();
	}

	@RequestMapping("/clubs")
	public String units(Model model) {
		model.addAttribute("clubs", clubService.findAll());

		return "clubs";
	}

	/*@RequestMapping("/unit/remove/{id}")
	public String removeUnit(@PathVariable long id, Principal principal) {
		String name = principal.getName();
		if (name.equals("admin")) {
			unitService.delete(id);
		}

		return "redirect:/units.html";
	}*/

}
