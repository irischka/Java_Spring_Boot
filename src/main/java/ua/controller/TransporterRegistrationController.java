package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.model.request.TransporterRequestNew;
import ua.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration/transporter")
@SessionAttributes("transporter")
public class TransporterRegistrationController {

	private final UserService service;
	
	public TransporterRegistrationController(UserService service) {
		this.service = service;
	}

	@ModelAttribute("transporter")
	public TransporterRequestNew getForm() {
		return new TransporterRequestNew();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("models", service.findAllModels());
		return "transporter-registration";
	}
	
	@PostMapping
	public String save(@ModelAttribute("transporter") @Valid TransporterRequestNew request, BindingResult br, Model model) {
		if(br.hasErrors()) return show(model);
		service.save(request);
		return "redirect:/login";
	}
}
