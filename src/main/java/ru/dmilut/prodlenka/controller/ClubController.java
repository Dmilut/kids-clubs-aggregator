package ru.dmilut.prodlenka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.dmilut.prodlenka.entity.Address;
import ru.dmilut.prodlenka.entity.User;
import ru.dmilut.prodlenka.service.AddressService;
import ru.dmilut.prodlenka.service.ClubService;

@Controller
public class ClubController {

	@Autowired
	private ClubService clubService;

	@Autowired
	private AddressService addressService;

	@ModelAttribute("user")
	public User constructUser() {

		return new User();
	}

	@RequestMapping(value = "/clubs", method = RequestMethod.GET)
	public String clubs(Model model) {
		model.addAttribute("clubs", clubService.findAllWithAddressesUnits());
		initModelList(model);
		return "clubs";
	}

	@RequestMapping(value = "/clubs", method = RequestMethod.POST)
	public String searchClubs(@RequestParam("city") String city, Model model) {
		String currentCity = null;
		if (!city.isEmpty()) {
			currentCity = city;
			model.addAttribute("clubs",
					clubService.findAllWithAddressesUnitsByQuery(city));
		} else {
			model.addAttribute("clubs", clubService.findAllWithAddressesUnits());
		}
		model.addAttribute("currentCity", currentCity);
		initModelList(model);

		return "clubs";
	}

	@RequestMapping(value = "/clubs/{id}", method = RequestMethod.GET)
	public String club(Model model, @PathVariable long id) {
		model.addAttribute("club", clubService.findOne(id));
		return "club-detail";
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
