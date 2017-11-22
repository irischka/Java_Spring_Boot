package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.entity.Comment;
import ua.entity.Owner;
import ua.model.filter.OwnerFilter;
import ua.model.request.OwnerRequestNew;
import ua.model.view.OwnerView;

import java.util.List;

public interface OwnerService {

	List<Owner> findAllOwner();

	Page<OwnerView> findAll(Pageable pageable);
	
	void save(OwnerRequestNew request);

//  пошук овнера за id	
	OwnerRequestNew findOneOwner(Integer id);
	
	void delete(Integer id);

//  пошук всіх овнерів + фільтрація + посторіночна розбивка	
	Page<OwnerView> findAll(OwnerFilter filter, Pageable pageable);

//  коментарі про овнера + посторіночна рпозбивка	
	Page<Comment> findAllComentOwner(Integer id, Pageable pageable);

}
