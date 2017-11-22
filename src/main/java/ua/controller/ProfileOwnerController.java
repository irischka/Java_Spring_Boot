package ua.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.model.filter.CargoFilter;
import ua.model.request.OwnerRequest;
import ua.service.CargoService;
import ua.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
@SessionAttributes("owner")
public class ProfileOwnerController {


	private final UserService service;
	
	private final CargoService  cargoService;
	
	public ProfileOwnerController(UserService service, CargoService cargoService) {
		super();
		this.service = service;
		this.cargoService = cargoService;
	}

	@ModelAttribute("owner")
	public OwnerRequest getForm() {
		return new OwnerRequest();
	}

	@ModelAttribute("cargoFilter")
	public CargoFilter getFilter() {
		return new CargoFilter();
	}
	
// 	інфо про власника та товари
	@GetMapping
	public String show(Model model, Principal principal, @PageableDefault Pageable pageable, @ModelAttribute("cargoFilter") CargoFilter filter ){
		model.addAttribute("owner", service.findProfileOwner(principal.getName()));
		model.addAttribute("cargos", cargoService.findAllView(principal.getName(), filter, pageable));
		model.addAttribute("cities", cargoService.findAllCity());
		model.addAttribute("goodss", cargoService.findAllGoods());
		return "profile";
	}
		
//  оновлення інформації про овнера
	@PostMapping("/saveOwner")
	public String saveOwner(@ModelAttribute("owner")  OwnerRequest request, SessionStatus status) {
		service.saveOwner(request);
		return cancel(status);
	}
	
//	додати товар
	@PostMapping("/saveCargo")
	public String saveCargo(@ModelAttribute("owner")  OwnerRequest request, SessionStatus status) {
		service.saveCargo(request);
		return cancel(status);
	}
	
//  Заявки на конкретне cargo	
	@GetMapping("/{id}")
	public String update(@PathVariable Integer id, Model model) {
		model.addAttribute("cargo", cargoService.findOne(id));
		model.addAttribute("oneTransporter", cargoService.findOneTransporter(id));
		return "cargo-transporter-info";
	}
	

//  Видалення конкретної заявки
	@GetMapping("/delete/{id}/{transporterId}")
	public String delete(SessionStatus status, @PathVariable Integer id, @PathVariable Integer transporterId ) {
		service.deleteOrder(id, transporterId);
		return "redirect:/profile/{id}";
	}
	
//  підтвердження заявки, видалення всіх інших
	@GetMapping("/deleteAll/{id}/{transporterId}")
	public String deleteAll(SessionStatus status, @PathVariable Integer id, @PathVariable Integer transporterId ) {
		service.deleteAllOrder(id, transporterId);
		return "redirect:/profile/{id}";
	}	
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profile";
	}
	
}
