package ua.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.entity.Cargo;
import ua.entity.Transporter;
import ua.model.filter.CargoFilter;
import ua.model.request.CargoRequest;
import ua.model.view.CargoView;
import ua.repository.*;
import ua.service.CargoService;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

	private final CargoRepository repository;
	
	private final CargoViewRepository viewRepository;
	
	private final TransporterRepository transporterRepository;
	
	private final FreeCargoProfileRepository freeCargoProfileRepository;
	
	private final ListOrderTransporterRepository listOrderTransporterRepository;
	
	public CargoServiceImpl(CargoRepository repository, CargoViewRepository viewRepository,
                            TransporterRepository transporterRepository, FreeCargoProfileRepository freeCargoProfileRepository,
                            ListOrderTransporterRepository listOrderTransporterRepository) {
		super();
		this.repository = repository;
		this.viewRepository = viewRepository;
		this.transporterRepository = transporterRepository;
		this.freeCargoProfileRepository = freeCargoProfileRepository;
		this.listOrderTransporterRepository = listOrderTransporterRepository;
	}

//  Всі товари	
	@Override
	public List<String> findAllGoods() {
		return repository.findAllGoods();
	}
	
//  Пошук міст
	@Override
	public List<String> findAllCity() {
		return repository.findAllCity();
	}
	
//	Відображення поточного вантажу для транспортера	
	@Override
	public List<Cargo> findAllConfirmCargo(String name) {
		return repository.FindOneConfirm(name);
	}
	
//  Пошук  товару по id
	@Override
	public CargoRequest findOne(Integer id) {
		Cargo cargo = repository.findOneRequest(id);
		CargoRequest request = new CargoRequest();
		request.setCityFrom(cargo.getCityFrom());
		request.setCityTo(cargo.getCityTo());
		request.setGoods(cargo.getGoods());
		request.setHeight(String.valueOf(cargo.getHeight()));
		request.setId(cargo.getId());
		request.setLength(String.valueOf(cargo.getLength()));
		request.setOwner(cargo.getOwner());
		request.setPrice(String.valueOf(cargo.getPrice()));
		request.setWeight(String.valueOf(cargo.getWeight()));
		request.setWidth(String.valueOf(cargo.getWidth()));
		request.setTransporters(cargo.getTransporters());
		return request;
	}

//  Вибір вільних вантажів + посторіночна розбивка та фільтрація	
	@Override
	public Page<CargoView> findAll(CargoFilter filter, Pageable pageable) {
		return viewRepository.findAll(filter, pageable);
	}
	
//  Вибір транспортера який перевозить чи перевозив товар
	@Override
	public List<Transporter> findOneTransporter(Integer id) {
		int queryLimit = 1;
		return transporterRepository.findOneTransporter(id,new PageRequest(0, queryLimit));
	}
	
//  Список товарів овнера в його кабінеті +фільтр
	@Override
	public Page<CargoView> findAllView(String name, CargoFilter filter, Pageable pageable) {
		return freeCargoProfileRepository.findAllFreeCargo(name, filter, pageable);
	}
	
//  Заявки на перевезення товарів у кабінеті транспортера
	@Override
	public Page<CargoView> findAllConfirmCargo(String name, Pageable pageable, CargoFilter filter) {
		return listOrderTransporterRepository.findAllOrder(name, filter, pageable) ;
	}
}
