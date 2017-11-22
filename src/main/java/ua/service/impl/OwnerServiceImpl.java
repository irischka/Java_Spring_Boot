package ua.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.entity.Comment;
import ua.entity.Owner;
import ua.entity.User;
import ua.model.filter.OwnerFilter;
import ua.model.request.OwnerRequestNew;
import ua.model.view.OwnerView;
import ua.repository.OwnerRepository;
import ua.repository.OwnerViewRepository;
import ua.service.OwnerService;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

	private final OwnerRepository repository;
	
	private final OwnerViewRepository viewRepository;
	
	public OwnerServiceImpl(OwnerRepository repository, OwnerViewRepository viewRepository) {
		super();
		this.repository = repository;
		this.viewRepository = viewRepository;
	}

	@Override
	public List<Owner> findAllOwner() {
		return repository.findAll();
	}

	@Override
	public Page<OwnerView> findAll(Pageable pageable) {
		return repository.FindAllOwnerView(pageable);
	}

	@Override
	public void save(OwnerRequestNew request) {
		Owner owner = new Owner();
		owner.setId(request.getId());
		owner.setAddress(request.getAddress());
		owner.setCount(Integer.valueOf(request.getCount()));
		owner.setName(request.getName());
		owner.setPhone(request.getPhone());
		repository.save(owner);
	}

//  пошук овнера за id	
	@Override
	public OwnerRequestNew findOneOwner(Integer id) {
		Owner owner = repository.findOneOwnerRequestNew(id);
		User user = repository.findOwnerComment(id);
		OwnerRequestNew request = new OwnerRequestNew();
		request.setId(owner.getId());
		request.setAddress(owner.getAddress());
		request.setCount(String.valueOf(owner.getCount()));
		request.setName(owner.getName());
		request.setPhone(owner.getPhone());
		request.setComments(user.getComments());
		return request;
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

//  пошук всіх овнерів + фільтрація + посторіночна розбивка		
	@Override
	public Page<OwnerView> findAll(OwnerFilter filter, Pageable pageable) {
		return viewRepository.findAll(filter, pageable);
	}

//  коментарі про овнера + посторіночна рпозбивка	
	@Override
	public Page<Comment> findAllComentOwner(Integer id, Pageable pageable) {
		return repository.findAllComment(id,pageable);
	}
}
