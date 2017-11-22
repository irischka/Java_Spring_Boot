package ua.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.model.filter.OwnerFilter;
import ua.model.request.CommentRequest;
import ua.repository.CommentRepository;
import ua.service.OwnerService;
import ua.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/owner")
public class OwnerListController {

	private final OwnerService service;
	
	private final UserService userService;
	
	private final CommentRepository repository;
		
	public OwnerListController(OwnerService service, UserService userService, CommentRepository repository) {
		super();
		this.service = service;
		this.userService = userService;
		this.repository = repository;
	}

	@ModelAttribute("ownerFilter")
	public OwnerFilter getFilter() {
		return new OwnerFilter();
	}
	
	@ModelAttribute("comment")
	public CommentRequest  getForm() {
		return new CommentRequest();
	}
	
//  відображення всіх овнерів + фільтрація+ посторіночна розбивка
	@GetMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("ownerFilter") OwnerFilter filter) {
		model.addAttribute("owners", service.findAll(filter, pageable));
		return "list-owners";
	}

//  інформація про овнера, коментарі + посторіночна розбивка
	@GetMapping("/{id}")
	public String show(@PathVariable Integer id, Model model, @PageableDefault Pageable pageable, Principal principal) {
		model.addAttribute("owner", service.findOneOwner(id));
		model.addAttribute("comments", service.findAllComentOwner(id, pageable));
// перевірка чи транспортер перевозив товар даного овнера
		String name = repository.cheackTransporterUsecargo(id, principal.getName());
		if(name !=null) model.addAttribute("message", "allowed");
		return "owner-info";
	}
	
//  додавання коментаря + валідація	
	@PostMapping("/{id}")
	public String addComment(@ModelAttribute("comment")@Valid CommentRequest request ,BindingResult br, @PathVariable Integer id, Principal principal, Model model, @PageableDefault Pageable pageable, Principal principal2) {
		if(br.hasErrors()) return show(id, model, pageable, principal);
		userService.saveCommentOwner(request, id, principal.getName());	
		return "redirect:/owner/{id}"+buildParams(pageable);
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
