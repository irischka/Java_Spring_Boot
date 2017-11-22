package ua.repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import ua.entity.*;
import ua.model.filter.CargoFilter;
import ua.model.view.CargoView;
import ua.repository.ListOrderTransporterRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

@Repository
public class ListOrderTransporterRepositoryImpl implements ListOrderTransporterRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<CargoView> findAllOrder(String name, CargoFilter filter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CargoView> cq = cb.createQuery(CargoView.class);
		Root<Cargo> root = cq.from(Cargo.class);
//Integer id, Integer ownerId, Goods goods, String weight, String height, String width, String length, City cityFrom, City cityTo, Owner owner, String price,Integer transporterId, String status
		cq.multiselect(root.get("id"), root.get("goods"), root.get("weight"), root.get("height"), root.get("width"), root.get("length"),root.get("cityFrom"), root.get("cityTo"),root.get("owner"), root.get("price"), root.get("transporterId"), root.get("status") );
		Join<Cargo,Transporter> ownerJoin= root.join("transporters");
		Join<Transporter, User> userJoin = ownerJoin.join("user");
		PredicateBuilder builder = new PredicateBuilder(filter, root, cb);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(cb.and(cb.equal(userJoin.get("email"), name)), predicate);
		else {cq.where(cb.equal(userJoin.get("email"), name));}
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<CargoView> content = em.createQuery(cq)
			.setFirstResult(pageable.getPageNumber())
			.setMaxResults(pageable.getPageSize())
			.getResultList();
		CriteriaBuilder cbCount = em.getCriteriaBuilder();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Cargo> rootCount = cqCount.from(Cargo.class);
		cqCount.select(cb.count(root));
		PredicateBuilder countBuilder = new PredicateBuilder(filter, rootCount, cbCount);
		Predicate countPredicate = countBuilder.toPredicate();
		if(countPredicate!=null) cqCount.where(countPredicate);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}
private static class PredicateBuilder {
		
		final CargoFilter filter;
		
		final Root<Cargo> root;
		
		final CriteriaBuilder cb;
		
		final List<Predicate> predicates = new ArrayList<>();
		
		public PredicateBuilder(CargoFilter filter, Root<Cargo> root, CriteriaBuilder cb) {
			this.filter = filter;
			this.root = root;
			this.cb = cb;
		}

		void filterByMinWeight() {
			if(!filter.getMinWeight().isEmpty()) {
				predicates.add(cb.ge(root.get("weight"), new Integer(filter.getMinWeight())));
			}
		}

		void filterByMaxWeight() {
			if(!filter.getMaxWeight().isEmpty()) {
				predicates.add(cb.le(root.get("weight"), new Integer(filter.getMaxWeight())));
			}
		}
		
		void filterByMinHeight() {
			if(!filter.getMinHeight().isEmpty()) {
				predicates.add(cb.ge(root.get("height"), new Integer(filter.getMinHeight())));
			}
		}

		void filterByMaxHeight() {
			if(!filter.getMaxHeight().isEmpty()) {
				predicates.add(cb.le(root.get("height"), new Integer(filter.getMaxHeight())));
			}
		}
		
		void filterByMinWidth() {
			if(!filter.getMinWidth().isEmpty()) {
				predicates.add(cb.ge(root.get("width"), new Integer(filter.getMinWidth())));
			}
		}

		void filterByMaxWidth() {
			if(!filter.getMaxWidth().isEmpty()) {
				predicates.add(cb.le(root.get("width"), new Integer(filter.getMaxWidth())));
			}
		}
		
		void filterByMinLength() {
			if(!filter.getMinLength().isEmpty()) {
				predicates.add(cb.ge(root.get("length"), new Integer(filter.getMinLength())));
			}
		}

		void filterByMaxLength() {
			if(!filter.getMaxLength().isEmpty()) {
				predicates.add(cb.le(root.get("length"), new Integer(filter.getMaxLength())));
			}
		}
		
		void filterByMinPrice() {
			if(!filter.getMinPrice().isEmpty()) {
				predicates.add(cb.ge(root.get("price"), new Integer(filter.getMinPrice())));
			}
		}

		void filterByMaxPrice() {
			if(!filter.getMaxPrice().isEmpty()) {
				predicates.add(cb.le(root.get("price"), new Integer(filter.getMaxPrice())));
			}
		}
		
		void findByCityId() {
			if(!filter.getCityIds().isEmpty()) {
				Join<Cargo, City> cityJoin = root.join("cityFrom");
				predicates.add(cityJoin.get("name").in(filter.getCityIds()));
			}
		}
		
		void findByCityToId() {
			if(!filter.getCityToIds().isEmpty()) {
				Join<Cargo, City> cityJoin = root.join("cityTo");
				predicates.add(cityJoin.get("name").in(filter.getCityToIds()));
			}
		}
		
		void findByGoodsId() {
			if(!filter.getGoodsIds().isEmpty()) {
				Join<Cargo, Goods> goodsJoin = root.join("goods");
				predicates.add(goodsJoin.get("name").in(filter.getGoodsIds()));
			}
		}
		
	
		
		Predicate toPredicate() {
			filterByMinWeight();
			filterByMaxWeight();
			filterByMinHeight();
			filterByMaxHeight();
			filterByMinWidth();
			filterByMaxWidth();
			filterByMinLength();
			filterByMaxLength();
			filterByMinPrice();
			filterByMaxPrice();
			findByCityId();
			findByCityToId();
			findByGoodsId();
			return predicates.isEmpty() ? null : cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}
	

}
