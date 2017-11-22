package ua.controller;


import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.model.filter.TransporterFilter;
import ua.model.request.CommentRequest;
import ua.model.request.TransporterRequestNew;
import ua.repository.CommentRepository;
import ua.service.TransporterService;
import ua.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/transporter")
public class TransporterIndexViewController {

	private final TransporterService service;
	
	private final UserService userService;
	
	private final CommentRepository repository;
	
	public TransporterIndexViewController(TransporterService service, UserService userService,
			CommentRepository repository) {
		super();
		this.service = service;
		this.userService = userService;
		this.repository = repository;
	}

	@ModelAttribute("transporterFilter")
	public TransporterFilter getFilter() {
		return new TransporterFilter();
	}
	
	@ModelAttribute("comment")
	public CommentRequest getForm() {
		return new CommentRequest();
	}
	
	@ModelAttribute("transporter")
	public TransporterRequestNew getFormRate() {
		return new TransporterRequestNew();
	}
	
//  Відображення сторінки із транспортерами(transporter/{id})
	@GetMapping 
	public String show(Model model, @ModelAttribute("transporterFilter") TransporterFilter filter, @PageableDefault Pageable pageable) {
		model.addAttribute("brands", service.findAllBrand());
		model.addAttribute("models", service.findAllModel());
		model.addAttribute("cities", service.findAllCity());
		model.addAttribute("states", service.findAllState());
		model.addAttribute("transporters", service.findAll(filter, pageable));
		return "transporter-index-view";
	}

//  Додавання коментаря	
	@PostMapping("/{id}")
	public String addComment(@ModelAttribute("comment") CommentRequest request , @PathVariable Integer id, Principal principal, @PageableDefault Pageable pageable) {
		userService.saveComment(request, id, principal.getName());	
		return "redirect:/transporter/{id}"+buildParams(pageable);
	}
	
//  Відображння інформації про транспортера (transporter/{id})
	@GetMapping("/{id}")
	public String show(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, Principal principal ) {
		model.addAttribute("transporter", service.findOne(id));
		model.addAttribute("comments", service.findAllComent(id, pageable));
// перевірка чи користувався авторизований овнер  послугами даного транспортера
		String name = repository.cheackCargoUseTransporter(id, principal.getName());
		if(name !=null) model.addAttribute("message", "allowed");
		return "transporter-view";
	}
	
//  рейтинг
	@PostMapping("/rate/{id}")
	private String rate(@ModelAttribute("transporter") TransporterRequestNew request, @PathVariable Integer id, Pageable pageable) {
		userService.addRate(request, id);
		return "redirect:/transporter/{id}"+buildParams(pageable);
	}
	
		
	private String buildParams(Pageable pageable) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		return buffer.toString();
	}
}
