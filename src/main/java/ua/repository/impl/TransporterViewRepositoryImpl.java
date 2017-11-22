package ua.repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import ua.entity.*;
import ua.model.filter.TransporterFilter;
import ua.model.view.TransporterIndexView;
import ua.repository.TransporterViewRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

@Repository
public class TransporterViewRepositoryImpl implements TransporterViewRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<TransporterIndexView> cq = cb.createQuery(TransporterIndexView.class);
		Root<Transporter> root = cq.from(Transporter.class);
		cq.multiselect(root.get("id"), root.get("rate"), root.get("maxWeight"), root.get("photoUrl"), root.get("version"), root.get("name"), root.get("count"));
		PredicateBuilder builder = new PredicateBuilder(filter, root, cb);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<TransporterIndexView> content = em.createQuery(cq)
			.setFirstResult(pageable.getPageNumber())
			.setMaxResults(pageable.getPageSize())
			.getResultList();
		CriteriaBuilder cbCount = em.getCriteriaBuilder();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Transporter> rootCount = cqCount.from(Transporter.class);
		cqCount.select(cb.count(root));
		PredicateBuilder countBuilder = new PredicateBuilder(filter, rootCount, cbCount);
		Predicate countPredicate = countBuilder.toPredicate();
		if(countPredicate!=null) cqCount.where(countPredicate);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}
	
	private static class PredicateBuilder {
		
		final TransporterFilter filter;
		
		final Root<Transporter> root;
		
		final CriteriaBuilder cb;
		
		final List<Predicate> predicates = new ArrayList<>();
		
		Join<Transporter, Model> modelJoin;
		
		public PredicateBuilder(TransporterFilter filter, Root<Transporter> root, CriteriaBuilder cb) {
			this.filter = filter;
			this.root = root;
			this.cb = cb;
		}

		void filterByMinRate() {
			if(!filter.getMinRate().isEmpty()) {
				predicates.add(cb.ge(root.get("rate"), new BigDecimal(filter.getMinRate().replace(',', '.'))));
			}
		}

		void filterByMaxRate() {
			if(!filter.getMaxRate().isEmpty()) {
				predicates.add(cb.le(root.get("rate"), new BigDecimal(filter.getMaxRate().replace(',', '.'))));
			}
		}
		
		void filterByMinCount() {
			if(!filter.getMinCount().isEmpty()) {
				predicates.add(cb.ge(root.get("count"), new Integer(filter.getMinCount())));
			}
		}

		void filterByMaxCount() {
			if(!filter.getMaxCount().isEmpty()) {
				predicates.add(cb.le(root.get("count"),  new Integer(filter.getMaxCount())));
			}
		}
		
		void filterByMinWeight() {
			if(!filter.getMinWeight().isEmpty()) {
				predicates.add(cb.ge(root.get("maxWeight"), new Integer(filter.getMinWeight())));
			}
		}

		void filterByMaxWeight() {
			if(!filter.getMaxWeight().isEmpty()) {
				predicates.add(cb.le(root.get("maxWeight"),  new Integer(filter.getMaxWeight())));
			}
		}
		
		void filterByMinAge() {
			if(!filter.getMinAge().isEmpty()) {
				predicates.add(cb.ge(root.get("age"), new Integer(filter.getMinAge())));
			}
		}

		void filterByMaxAge() {
			if(!filter.getMaxAge().isEmpty()) {
				predicates.add(cb.le(root.get("age"),  new Integer(filter.getMaxAge())));
			}
		}
		
		void filterByPhone() {
			if(!filter.getPhones().isEmpty()) {
				predicates.add(cb.like(root.get("phone"), new String(filter.getPhones())+"%"));
			}
		}
		
		void filterByName() {
			if(!filter.getNames().isEmpty()) {
				predicates.add(cb.like(root.get("name"), new String(filter.getNames())+"%"));
			}
		}
		
//		void filterByDate() {
//			if(!filter.getDate().isEmpty()) {
//				predicates.add(cb.equal(root.get("dateArrive"), new String(filter.getDate())));
//			}
//		}
		
		void filterByMinCarAge() {
			if(!filter.getMinCarAge().isEmpty()) {
				predicates.add(cb.ge(root.get("carAge"), new Integer(filter.getMinCarAge())));
			}
		}

		void filterByMaxCarAge() {
			if(!filter.getMaxCarAge().isEmpty()) {
				predicates.add(cb.le(root.get("carAge"),  new Integer(filter.getMaxCarAge())));
			}
		}
		
		
		void findByModelId() {
			if(!filter.getModelIds().isEmpty()) {
				modelJoin = root.join("model");
				predicates.add(modelJoin.get("name").in(Arrays.asList(filter.getModelIds())));
			}
		}
		
		void findByCityId() {
			if(!filter.getCityIds().isEmpty()) {
				Join<Transporter, City> cityJoin = root.join("cityArrive");
				predicates.add(cityJoin.get("name").in(filter.getCityIds()));
			}
		}
		
		void findByBrandId() {
			if(!filter.getBrandIds().isEmpty()) {
				if(modelJoin==null) modelJoin = root.join("model");
				Join<Model, Brand> brandJoin = modelJoin.join("brand");
				predicates.add(brandJoin.get("name").in(filter.getBrandIds()));
			}
		}
		
		void findByStateId() {
			if(!filter.getStateIds().isEmpty()) {
				Join<Transporter, State> stateJoin = root.join("state");
				predicates.add(stateJoin.get("name").in(filter.getStateIds()));
			}
		}
		
		Predicate toPredicate() {
			filterByMinRate();
			filterByMaxRate();
			filterByMinCount();
			filterByMaxCount();	
			filterByMinWeight();
			filterByMaxWeight();
			filterByMinAge();
			filterByMaxAge();
			filterByMinCarAge();
			filterByMaxCarAge();
			filterByPhone();
			findByBrandId();
			findByModelId();
			findByCityId();
			findByStateId();
			filterByName();
//			filterByDate();
			return predicates.isEmpty() ? null : cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}
}