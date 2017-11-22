package ua.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ua.entity.Goods;
import ua.model.filter.SimpleFilter;
import ua.repository.GoodsRepository;
import ua.service.GoodsService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class GoodsServiceImpl extends CrudServiceImpl<Goods, Integer> implements GoodsService {
	
	private final GoodsRepository repository;

	public GoodsServiceImpl(GoodsRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Goods findByName(String name) {
		return repository.findByName(name);
	}

//  Всі товари + фільтрація + розбивка	
	@Override
	public Page<Goods> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(filter(filter), pageable);
	}
	
	private Specification<Goods> filter (SimpleFilter filter){
		return new Specification<Goods>() {
			@Override
			public Predicate toPredicate(Root<Goods> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if(filter.getSearch().isEmpty())return null;
				return cb.like(root.get("name"), filter.getSearch()+"%");
			}
		};
	}

}
