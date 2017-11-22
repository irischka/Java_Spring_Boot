package ua.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.entity.State;
import ua.service.StateService;

@Controller
@RequestMapping("/admin/state")
@SessionAttributes("state")
public class AdminStateController {

	private final StateService service;
	
	@Autowired
	public AdminStateController(StateService service) {
		this.service = service;
	}
	
	@ModelAttribute("state")
	public State getForm() {
		return new State();
	}
	
	@GetMapping
	public String show(Model model) {
		model.addAttribute("states", service.findAll());
		return "state";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/state";
	}
	
	@PostMapping
	public String save(@ModelAttribute("state") State state, SessionStatus status) {
		service.save(state);	
		return cancel(status);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("state", service.findOne(id));
		return show(model);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/state";
	}
}
