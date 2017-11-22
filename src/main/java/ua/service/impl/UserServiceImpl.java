package ua.service.impl;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.entity.*;
import ua.model.request.CommentRequest;
import ua.model.request.OwnerRequest;
import ua.model.request.TransporterRequestNew;
import ua.repository.*;
import ua.service.UserService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository repository;
	
	private final OwnerRepository ownerRepository;
	
	private final TransporterRepository transporterRepository;
	
	private final CargoRepository cargoRepository;
	
	private final PasswordEncoder encoder; 
	
	private final CommentRepository commentRepository;

	
	public UserServiceImpl(UserRepository repository, OwnerRepository ownerRepository,
			TransporterRepository transporterRepository, CargoRepository cargoRepository, PasswordEncoder encoder,
			CommentRepository commentRepository) {
		super();
		this.repository = repository;
		this.ownerRepository = ownerRepository;
		this.transporterRepository = transporterRepository;
		this.cargoRepository = cargoRepository;
		this.encoder = encoder;
		this.commentRepository = commentRepository;
	}

//  збереження зареєстрованого транспортера	
	@Override
	public void save(TransporterRequestNew request) {
		User user = new User();
		State state = transporterRepository.findFreeState();
		City city = transporterRepository.findCityNotSelected();
		user.setEmail(request.getEmail());
		user.setPassword(encoder.encode(request.getPassword()));
		user.setRole(Role.ROLE_TRANSPORTER);
		user.setId(request.getUserId());
		Transporter transporter = new Transporter();
		transporter.setId(request.getId());
		transporter.setAge(Integer.valueOf(request.getAge()));
		transporter.setCarAge(Integer.valueOf(request.getCarAge()));
		transporter.setMaxWeight(Integer.valueOf(request.getMaxWeight()));
		transporter.setName(request.getName());
		transporter.setPhone(request.getPhone());
		transporter.setModel(request.getModel());
		transporter.setPhotoUrl("завантаження.png");
		transporter.setCityArrive(city);
		transporter.setDateArrive(request.getDateArrive());
		transporter.setState(state);
		transporter.setRate(new BigDecimal(0));
		transporter.setSumRate(BigDecimal.valueOf(0));
		transporter.setUser(user);
		user.setTransporter(transporter);
		repository.save(user);
	}

//  збереження зареєстрованого овнера	
	@Override
	public void save(OwnerRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(encoder.encode(request.getPassword()));
		user.setRole(Role.ROLE_OWNER);
		Owner owner = new Owner();
		owner.setId(request.getId());
		owner.setName(request.getName());
		owner.setPhone(request.getPhone());
		owner.setAddress(request.getAddress());
		owner.setUser(user);
		user.setOwner(owner);
		repository.save(user);
	}
	
//  оновлення інфо про транспортера в кабінеті	
	@Override
	public void saveTransporter(TransporterRequestNew request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(encoder.encode(request.getPassword()));
		user.setRole(Role.ROLE_TRANSPORTER);
		user.setId(request.getUserId());
		Transporter transporter = new Transporter();
		transporter.setId(request.getId());
		transporter.setName(request.getName());
		transporter.setPhone(request.getPhone());
		transporter.setAge(Integer.valueOf(request.getAge()));
		transporter.setModel(request.getModel());
		transporter.setMaxWeight(Integer.valueOf(request.getMaxWeight()));
		transporter.setCarAge(Integer.valueOf(request.getCarAge()));
		transporter.setCityArrive(request.getCityArrive());
		transporter.setDateArrive(request.getDateArrive());
		transporter.setRate(new BigDecimal(request.getRate().replace(',', '.')));
		transporter.setState(request.getState());
		transporter.setCount(Integer.valueOf(request.getCount()));
		transporter.setPhotoUrl(request.getPhotoUrl());
		transporter.setUser(user);
		transporterRepository.save(transporter);
	}

// Оновлення інформації в профайлі	
	@Override
	public void saveOwner(OwnerRequest request) {
		User user = new User();
		user.setId(request.getUserId());
		Owner owner = new Owner();
		owner.setId(request.getId());
		owner.setName(request.getName());
		owner.setPhone(request.getPhone());
		owner.setAddress(request.getAddress());
		owner.setCount(Integer.valueOf(request.getCount()));
		owner.setUser(user);
		user.setOwner(owner);
		ownerRepository.save(owner);
		
	}

//  Додавання нового товару в профайлі owner
	@Override
	public void saveCargo(OwnerRequest request) {
		Owner owner = new Owner();
		owner.setId(request.getId());
		Cargo cargo = new Cargo();
		cargo.setCityFrom(request.getCityFrom());
		cargo.setCityTo(request.getCityTo());
		cargo.setGoods(request.getGoods());
		cargo.setHeight(Integer.valueOf(request.getHeight()));
		cargo.setLength(Integer.valueOf(request.getLength()));
		cargo.setPrice(new BigDecimal(request.getPrice().replaceAll(",", ".")));	
		cargo.setWeight(Integer.valueOf(request.getWeight()));
		cargo.setWidth(Integer.valueOf(request.getWidth()));
		cargo.setTransporterId(0);
		cargo.setStatus("Free");
		cargo.setOwner(owner);
		cargoRepository.save(cargo);
	}

//  Додавання коментарря до транспортера	
	@Override
	public void saveComment(CommentRequest request, Integer id, String email) {
		OwnerRequest owner = repository.findProfileOwnerRepository(email);
		Comment comment = new Comment();
		User user = transporterRepository.findUserWithID(id);
		comment.setComment(request.getComment());
		comment.setSenderId(owner.getId());
		comment.setSenderName(owner.getName());
		comment.setUser(user);
		commentRepository.save(comment);
		
	}

//  рейтинг для транспортера	
	@Override
	public void addRate(TransporterRequestNew request, Integer id) {
//		Transporter transporter = transporterRepository.findOneRequest(id);
//        BigDecimal sumRate = transporter.getSumRate();
//		BigDecimal newRate = new BigDecimal(request.getRate().replace(',', '.'));
//		int countVotes = transporter.getCountVotes()+1;
//		sumRate = sumRate.add(newRate);
//		BigDecimal serRate = sumRate.divide(BigDecimal.valueOf(countVotes),    MathContext.DECIMAL128);
//		transporter.setCountVotes(countVotes);
//		transporterRepository.save(transporter);
//		int maxCountVotes = transporterRepository.findMaxCountVotes();
//		double a = Math.pow(maxCountVotes, (0.2));
//	    double log = Math.log10(countVotes)/Math.log10(a);
//	    BigDecimal rate =  serRate.add(BigDecimal.valueOf(log).divide(BigDecimal.valueOf(2)),   MathContext.DECIMAL128);
//		transporter.setSumRate(sumRate);
//		transporter.setRate(rate);
//		transporterRepository.save(transporter);
		Transporter transporter = transporterRepository.findOneRequest(id);
        BigDecimal sumRate = transporter.getSumRate();
		BigDecimal newRate = new BigDecimal(request.getRate().replace(',', '.'));
		int countVotes = transporter.getCountVotes()+1;
		sumRate = sumRate.add(newRate);
		BigDecimal serRate = sumRate.divide(BigDecimal.valueOf(countVotes), MathContext.DECIMAL128);
		transporter.setSumRate(sumRate);
		transporter.setRate(serRate.multiply(BigDecimal.valueOf(20)));
		transporter.setCountVotes(countVotes);
		transporterRepository.save(transporter);
	}

//  додавання коментаря овнеру	
	@Override
	public void saveCommentOwner(CommentRequest request, Integer id, String email) {
		Transporter transporter = repository.findProfileTransporterRepository(email);
		Comment comment = new Comment();
		User user = repository.findUserWithOwnId(id);
		comment.setComment(request.getComment());
		comment.setSenderId(transporter.getId());
		comment.setSenderName(transporter.getName());
		comment.setPhotoUrl(transporter.getPhotoUrl());
		comment.setUser(user);
		commentRepository.save(comment);
		
	}

//  Взяти в роботу, для транспортера
	@Override
	public void addCargo(String name, Integer id) {
		Transporter transporter = repository.findProfileTransporterRepository(name);
		Cargo cargo =  cargoRepository.findOneRequest(id);
		transporter.getCargos().add(cargo);
		transporterRepository.save(transporter);
	}
	
//  відміна заявки на перевезення, видалення	
	@Override
	public void delete(String name, Integer id) {
		Transporter transporter = repository.findProfileTransporterRepository(name);
		Cargo cargo =  cargoRepository.findOneRequest(id);
		cargo.getTransporters().remove(transporter);
		transporter.getCargos().remove(cargo);
		transporterRepository.save(transporter);
	}

//  Видалення заявки транспортера на перевезення певного товару 	
	@Override
	public void deleteOrder(Integer id, Integer transporterId) {
		Cargo cargo =  cargoRepository.findOneRequest(id);
		Transporter transporter = transporterRepository.findOne(transporterId);
		cargo.getTransporters().remove(transporter);
		transporter.getCargos().remove(cargo);
		cargoRepository.save(cargo);
	}
	
//  Підтвердження однієї заяви і видалення всіх інших
	@Override
	public void deleteAllOrder( Integer id, Integer transporterId) {
		List<Cargo> cargos = cargoRepository.findAllRequest(transporterId);
		List<Transporter> transporters = transporterRepository.findAll(id);
		Cargo cargo = cargoRepository.findOneRequest(id);
		Transporter transporter = transporterRepository.findOneRequest(transporterId);
		cargo.setTransporterId(transporter.getId());
		cargo.setStatus("In the way");
		transporter.getCargos().removeAll(cargos);
		cargo.getTransporters().removeAll(transporters);
		cargoRepository.save(cargo);
	}

//  пошук авторизованого транспортера
	@Override
	public TransporterRequestNew findProfileTransporter(String string) {
		Transporter transporter = repository.findProfileTransporterRepository(string);
		TransporterRequestNew request = new TransporterRequestNew();
		User user = repository.findProfileUserRepository(string);
		request.setEmail(user.getEmail());
		request.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_TRANSPORTER);
		request.setUserId(user.getId());
		request.setId(transporter.getId());
		request.setName(transporter.getName());
		request.setPhone(transporter.getPhone());
		request.setAge(String.valueOf(transporter.getAge()));
		request.setModel(transporter.getModel());
		request.setMaxWeight(String.valueOf(transporter.getMaxWeight()));
		request.setCarAge(String.valueOf(transporter.getCarAge()));
		request.setCityArrive(transporter.getCityArrive());
		request.setDateArrive(transporter.getDateArrive());
		request.setRate(String.valueOf(transporter.getRate()));
		request.setState(transporter.getState());
		request.setCount(String.valueOf(transporter.getCount()));
		request.setPhotoUrl(transporter.getPhotoUrl());
		request.setCargos(transporter.getCargos());
		return request;
	}
	
//  Для пошуку авторизованого овнера, профайл
	@Override
	public OwnerRequest findProfileOwner(String string) {
		return repository.findProfileOwnerRepository(string);
	}

//  пошук моделей	
	@Override
	public List<String> findAllModels() {
		return repository.findAllModels();
	}

//  підтвердження заявки на перевезення cargo	
	@Override
	public void orderCargo(Integer id, String name) {
		Cargo cargo = cargoRepository.findOne(id);
		State state = transporterRepository.findNotFreeState();	
		Transporter transporter = repository.findProfileTransporterRepository(name);
		transporter.setCityArrive(cargo.getCityTo());
		transporter.setState(state);
		transporterRepository.save(transporter);
	}
	
//  завершення перевезення	
	@Override
	public void completeTrip(Integer id, String name) {
		Transporter transporter = repository.findProfileTransporterRepository(name);
		Cargo cargo = cargoRepository.findOne(id);
		Owner owner = ownerRepository.findOneOwnersCargo(id);
		State state = transporterRepository.findFreeState();
		transporter.setState(state);
		cargo.setStatus("Completed");
		owner.setCount(owner.getCount()+1);
		transporter.setCount(transporter.getCount()+1);
		ownerRepository.save(owner);
		transporterRepository.save(transporter);
		cargoRepository.save(cargo);
	}

	
}
