package ua.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.model.request.OwnerRequest;
import ua.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration/owner")
@SessionAttributes("owner")
public class OwnerRegistrationController {

	private final UserService service;

	public OwnerRegistrationController(UserService service) {
		this.service = service;
	}
	
	@ModelAttribute("owner")
	public OwnerRequest getForm() {
		return new OwnerRequest();
	}
	
	@GetMapping
	public String show(Model model) {
		return "owner-registration";
	}
	
	@PostMapping
	public String save(@ModelAttribute("owner") @Valid OwnerRequest request, BindingResult br, Model model ) {
		if(br.hasErrors()) return show(model);
		service.save(request);
		return "redirect:/login";
		}
}
