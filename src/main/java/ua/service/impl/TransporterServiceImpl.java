package ua.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.entity.Comment;
import ua.entity.Transporter;
import ua.entity.User;
import ua.model.filter.TransporterFilter;
import ua.model.request.TransporterRequestNew;
import ua.model.view.TransporterIndexView;
import ua.repository.TransporterRepository;
import ua.repository.TransporterViewRepository;
import ua.service.TransporterService;

import java.util.List;

@Service
public class TransporterServiceImpl implements TransporterService {

	private final TransporterRepository repository;
	
	private final TransporterViewRepository viewRepository;

	public TransporterServiceImpl(TransporterRepository repository, TransporterViewRepository viewRepository) {
		super();
		this.repository = repository;
		this.viewRepository = viewRepository;
	}

//  Пошку всіх брендів	
	@Override
	public List<String> findAllBrand() {
		return repository.findAllBrand();
	}

//  Пошук всіх моделей		
	@Override
	public List<String> findAllModel() {
		return repository.findAllModel();
	}

//  Пошук всіх міст		
	@Override
	public List<String> findAllCity() {
		return repository.findAllCity();
	}
	
//  Пошук всіх статусів	
	@Override
	public List<String> findAllState() {
		return repository.findAllState();
	}
	
//  топ 5 транспортерів 	
	@Override
	public List<TransporterIndexView> findAllTransporterIndexViev() {
		int queryLimit = 5;
		return repository.findFiveTransporter(new PageRequest(0, queryLimit));
	}
	
//  пошук транспортера за id
	@Override
	public TransporterRequestNew findOne(Integer id) {
		Transporter transporter = repository.findOneRequest(id);
		User user = repository.findUserWithID(id);
		TransporterRequestNew request = new TransporterRequestNew();
		request.setAge(String.valueOf(transporter.getAge()));
		request.setCarAge(String.valueOf(transporter.getCarAge()));
		request.setCityArrive(transporter.getCityArrive());
		request.setCount(String.valueOf(transporter.getCount()));
		request.setDateArrive(transporter.getDateArrive());
		request.setId(transporter.getId());
		request.setMaxWeight(String.valueOf(transporter.getMaxWeight()));
		request.setModel(transporter.getModel());
		request.setName(String.valueOf(transporter.getName()));
		request.setPhone(String.valueOf(transporter.getPhone()));
		request.setRate(String.valueOf(transporter.getRate()));
		request.setState(transporter.getState());
		request.setPhotoUrl(transporter.getPhotoUrl());
		request.setComments(user.getComments());
		return request;
	}

//  Всі транспортери у вигялі transporterIndexView, + фільтрація та посторіночна розбивка	
	@Override
	public Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable) {
		return viewRepository.findAll(filter, pageable);
	}


//  Пошук коментарів що відносяться до транспортера	
	@Override
	public Page<Comment> findAllComent(Integer id, Pageable pageable) {
		return repository.findAllComment(id, pageable);
	}

}
