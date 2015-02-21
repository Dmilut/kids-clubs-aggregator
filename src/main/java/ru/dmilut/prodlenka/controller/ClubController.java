package ru.dmilut.prodlenka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.dmilut.prodlenka.entity.Address;
import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.service.AddressService;
import ru.dmilut.prodlenka.service.ClubService;

@Controller
@RequestMapping("/clubs")
public class ClubController {

	@Autowired
	private ClubService clubService;

	@Autowired
	private AddressService addressService;

	@ModelAttribute("user")
	public User constructUser() {

		return new User();
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String clubs(Model model) {
		model.addAttribute("clubs", clubService.findAll());
		initModelList(model);
		return "clubs";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String searchClubs(@RequestParam("city") String city, Model model) {
		model.addAttribute("clubs", clubService.findAllByQuery(city));
		String currentCity = null;
		if(city != null) {
			currentCity = city;
		}
		model.addAttribute("currentCity", currentCity);
		initModelList(model);
		
		return "clubs";
	}

	private void initModelList(Model model) {
		List<Address> addressList = addressService.findAll();
		List<String> cityList = new ArrayList<>();
		for (Address address : addressList) {
			cityList.add(address.getCity());
		}
		
		model.addAttribute("cityList", cityList);
	}
}
