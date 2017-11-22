package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.entity.Cargo;
import ua.entity.Transporter;
import ua.model.filter.CargoFilter;
import ua.model.request.CargoRequest;
import ua.model.view.CargoView;

import java.util.List;

public interface CargoService {

//  Всі товари
	List<String> findAllGoods();
	
//	Знайти всі міста
	List<String> findAllCity();
	
//  Пошук  товару по id	
	CargoRequest findOne(Integer id);

//  Вибір вільних вантажів + посторіночна розбивка та фільтрація	
	Page<CargoView> findAll(CargoFilter filter, Pageable pageable);

//	Відображення поточного вантажу для транспортера
	List<Cargo> findAllConfirmCargo(String name);

//  Вибір транспортера який перевозить чи перевозив товар
	List<Transporter> findOneTransporter(Integer id);

//  Список товарів овнера в його кабінеті + фільтр
	Page<CargoView> findAllView(String name, CargoFilter filter, Pageable pageable);

//  Заявки на перевезення товарів у кабінеті транспортера
	Page<CargoView> findAllConfirmCargo(String name, Pageable pageable, CargoFilter filter);
	
}
