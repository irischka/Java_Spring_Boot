package ua.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.entity.Model;
import ua.model.request.ModelRequest;
import ua.model.view.ModelView;
import ua.repository.ModelRepository;
import ua.service.ModelService;

import java.util.List;

@Service
public class ModelServiceImpl  implements ModelService {
	
	private final ModelRepository repository;
	
	@Autowired
	public ModelServiceImpl(ModelRepository repository) {
		this.repository = repository;
	}

//  пошук всіх брендів	
	@Override
	public List<String> findAllBrand() {
		return repository.findAllBrand();
	}

//	Видалення моделей по id	
	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

//  Збереження моделей 		
	@Override
	public void save(ModelRequest request) {
		Model model= new Model();
		model.setId(request.getId());
		model.setName(request.getName());
		model.setBrand(request.getBrand());
		repository.save(model);
	}

//  пошук моделей за id		
	@Override
	public ModelRequest findOne(Integer id) {
		Model model = repository.findOneRequest(id);
		ModelRequest request = new ModelRequest();
		request.setBrand(model.getBrand());
		request.setId(model.getId());
		request.setName(model.getName());
		return request;
	}

//  Пошку всіх моделей + фільтрація
	@Override
	public Page<ModelView> findAllModels(Pageable pageable) {
		return repository.FindAllView(pageable);
	}

	


}
