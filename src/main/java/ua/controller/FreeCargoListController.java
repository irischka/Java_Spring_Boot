package ua.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.model.filter.CargoFilter;
import ua.service.CargoService;
import ua.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/cargo")
public class FreeCargoListController {
	
	private final CargoService service;
	
	private final UserService userService;
	
	public FreeCargoListController(CargoService service, UserService userService) {
		super();
		this.service = service;
		this.userService = userService;
	}

	@ModelAttribute("cargoFilter")
	public CargoFilter getFilter() {
		return new CargoFilter();
	}
	
//  Відображення вільних вантажів
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("cargoFilter") CargoFilter filter) {
		model.addAttribute("cargos", service.findAll(filter, pageable));
		model.addAttribute("goodss", service.findAllGoods());
		model.addAttribute("cities", service.findAllCity());
	    return "list-free-cargo";
	}

//  Взяти в роботу для транспортера, на сторінці cargo	
	@PostMapping("/{id}")
	public String addCargo(Principal principal,SessionStatus status, @PathVariable Integer id) {
		userService.addCargo(principal.getName(), id);
		return "redirect:/cargo";
	}

//  інфо про товар	
	@GetMapping("/{id}")
	public String info(@PathVariable Integer id, Model model ) {
		model.addAttribute("cargo", service.findOne(id));
		return "cargo-info";
	}
	
//  Взяти в роботу для транспортера, на сторінці cargo/id		
	@PostMapping("/info/{id}")
	public String addCargo1(Principal principal,SessionStatus status, @PathVariable Integer id) {
		userService.addCargo(principal.getName(), id);
		return "redirect:/cargo/{id}";
	}
}
