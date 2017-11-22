package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.service.TransporterService;

import java.security.Principal;

@Controller
public class MainController {

	private final TransporterService service;
	
	public MainController(TransporterService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String index(Model model, Principal principal) {
		if(principal!=null) {
			model.addAttribute("message", "Hello " + principal.getName()+"!");
		}else {
			model.addAttribute("message", "Hello unauthorize user!");
		}
//  Топ 5 транспортерів
		model.addAttribute("transporters", service.findAllTransporterIndexViev());
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
}
