package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.entity.Comment;
import ua.model.filter.TransporterFilter;
import ua.model.request.TransporterRequestNew;
import ua.model.view.TransporterIndexView;

import java.util.List;

public interface TransporterService {
	
//  топ 5 транспортерів 	
	List<TransporterIndexView> findAllTransporterIndexViev();
	
//  Пошку всіх брендів  
	List<String> findAllBrand();
	
//  Пошук всіх моделей	
	List<String> findAllModel();
	
//  Пошук всіх міст	
	List<String> findAllCity();
	
//  Пошук всіх статусів
	List<String> findAllState();
	
//  пошук транспортера за id
	TransporterRequestNew findOne(Integer id);

//  Всі транспортери у вигялі transporterIndexView, + фільтрація та посторіночна розбивка
	Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable);

//  Пошук коментарів що відносяться до транспортера 
	Page<Comment> findAllComent(Integer id, Pageable pageable);


}
 