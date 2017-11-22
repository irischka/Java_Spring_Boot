package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.model.request.ModelRequest;
import ua.service.ModelService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/model")
@SessionAttributes("model")
public class AdminModelController {

	private final ModelService service;

	@Autowired
	public AdminModelController(ModelService service) {
		this.service = service;
	}
	
	@ModelAttribute("model")
	public ModelRequest getForm(){
		return new ModelRequest();
	}
	
	@GetMapping
	public String show(Model model1,@PageableDefault Pageable pageable ) {
		model1.addAttribute("models", service.findAllModels(pageable));
		model1.addAttribute("brands", service.findAllBrand());
		return "model";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "redirect:/admin/model";
	}
	
	@PostMapping
	public String save(@ModelAttribute("model") @Valid ModelRequest request, BindingResult br, SessionStatus status, Model model1, @PageableDefault Pageable pageable) {
		if(br.hasErrors()) return show(model1, pageable);
		service.save(request);	
		return cancel(status);
	}
	
	@GetMapping ("/update/{id}")
	public String update(@PathVariable Integer id, Model model1, @PageableDefault Pageable pageable) {
		model1.addAttribute("model", service.findOne(id));
		return show(model1, pageable);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/admin/model";
	}
	
}

