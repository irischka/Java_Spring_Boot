package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.model.request.ModelRequest;
import ua.model.view.ModelView;

import java.util.List;

public interface ModelService {

//  пошук всіх брендів
	List<String> findAllBrand();
	
//	Видалення моделей по id
	void delete(Integer id);

//  Збереження моделей 	
	void save(ModelRequest request);
	
//  пошук моделей за id	
	ModelRequest findOne(Integer id);

//  Пошку всіх моделей + фільтрація
	Page<ModelView> findAllModels(Pageable pageable);
}
