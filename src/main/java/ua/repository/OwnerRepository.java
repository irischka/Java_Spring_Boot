package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import ua.entity.Comment;
import ua.entity.Owner;
import ua.entity.User;
import ua.model.view.OwnerView;

public interface OwnerRepository extends JpaNameRepository<Owner, Integer> {

	Owner findByPhone(String phone);
	
//  пошук овнера за id
	@Query("SELECT o FROM Owner o LEFT JOIN o.user u  WHERE o.id = ?1")
    Owner findOneOwnerRequestNew(Integer id);
		
	@Query(value ="SELECT new ua.model.view.OwnerView(o.id, o.name, o.phone, o.count, o.address ) FROM Owner o", 
			countQuery="SELECT count(o.id) FROM Owner o")
	Page<OwnerView> FindAllOwnerView(Pageable pageable);

	@Query("SELECT u FROM User u LEFT JOIN u.owner o WHERE o.id=?1")
    User findOwnerComment(Integer id);

//  коментарі про овнера + посторіночна рпозбивка	
	@Query(value = "SELECT c FROM Comment c JOIN c.user u JOIN u.owner o WHERE o.id=?1 ORDER BY c DESC",
			countQuery="SELECT count(c.id) FROM Comment c JOIN c.user u JOIN u.owner o WHERE o.id=?1")
	Page<Comment> findAllComment(Integer id, Pageable pageable);
	
//  пошук овнера за cargo.id	
	@Query("SELECT o FROM Owner o LEFT JOIN o.cargos c  WHERE c.id = ?1")
    Owner findOneOwnersCargo(Integer id);

}
