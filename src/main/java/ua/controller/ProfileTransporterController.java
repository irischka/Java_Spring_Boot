package ua.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ua.model.filter.CargoFilter;
import ua.model.request.FileRequest;
import ua.model.request.TransporterRequestNew;
import ua.service.CargoService;
import ua.service.FileWritter;
import ua.service.TransporterService;
import ua.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/profileT")
@SessionAttributes("transporter")
public class ProfileTransporterController {

	private final UserService service;
	
	private final TransporterService service2;
	
	private final CargoService cargoService;
	
	private final FileWritter writter;
	
	public ProfileTransporterController(UserService service, TransporterService service2, CargoService cargoService,
                                        FileWritter writter) {
		super();
		this.service = service;
		this.service2 = service2;
		this.cargoService = cargoService;
		this.writter = writter;
	}

	@ModelAttribute("transporter")
	public TransporterRequestNew getForm() {
		return new TransporterRequestNew();
	}
	
	@ModelAttribute("FileRequest")
	public FileRequest getForm1() {
	return new FileRequest();
	}
	
	@ModelAttribute("cargoFilter")
	public CargoFilter getFilter() {
		return new CargoFilter();
	}

//  кабінет транспортера	
	@GetMapping
	public String show(Model model, Principal principal,@PageableDefault Pageable pageable, @ModelAttribute("cargoFilter") CargoFilter filter) {
		model.addAttribute("transporter", service.findProfileTransporter(principal.getName()));
		model.addAttribute("cargoes", cargoService.findAllConfirmCargo(principal.getName()));
		model.addAttribute("order", cargoService.findAllConfirmCargo(principal.getName(),pageable, filter));
		model.addAttribute("models", service.findAllModels());
		model.addAttribute("cities", service2.findAllCity());
		model.addAttribute("states", service2.findAllState());
		model.addAttribute("goods", cargoService.findAllGoods());
		return "profile-transporter";
	}

//  оновлення інформації про транспортера	
	@PostMapping
	public String save(@ModelAttribute("transporter") TransporterRequestNew request, SessionStatus status) {
		service.saveTransporter(request);
		return cancel(status);
	}
	
//  підтвердження заявки на перевезення cargo	
	@GetMapping("/order/{id}")
	public String orderCargo(@ModelAttribute("transporter") TransporterRequestNew request, SessionStatus status, @PathVariable Integer id, Principal principal) {
		service.orderCargo(id, principal.getName());
		return cancel(status);
	}

//  завершення перевезення	
	@GetMapping("/complete/{id}")
	public String complete(@ModelAttribute("transporter") TransporterRequestNew request, SessionStatus status, @PathVariable Integer id, Principal principal) {
		service.completeTrip(id, principal.getName());
		return cancel(status);
	}

//  завантаження фото 	
	@PostMapping("/saveFile")
	public String saveFile(@ModelAttribute("FileRequest") FileRequest request, Principal principal,SessionStatus status) {
		writter.write(request.getFile(), principal.getName()) ;
		return cancel(status);
	}
	
//  відміна заявки на перевезення, видалення	
	@GetMapping("/delete/{id}")
	public String delete(Principal principal,SessionStatus status, @PathVariable Integer id) {
		service.delete(principal.getName(), id);
		return cancel(status);
	}
	
	@GetMapping("/cancel")
	public String cancel(SessionStatus status) {
		status.setComplete();
		return "redirect:/profileT";
	}

}
