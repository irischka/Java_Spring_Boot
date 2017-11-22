package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.entity.Transporter;
import ua.entity.User;
import ua.model.request.OwnerRequest;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
//  пошук моделей	
	@Query("SELECT m.name FROM Model m")
	List<String> findAllModels();
	
//  Для пошуку авторизованого овнера, профайл
	@Query("SELECT new ua.model.request.OwnerRequest(o.id, u.id, u.email, u.password, o.name, o.phone,  o.address, o.count) FROM Owner o LEFT JOIN  o.user u WHERE u.email=?1")
    OwnerRequest findProfileOwnerRepository(String string);

//  Пошук авторизованого транспортера	
	@Query("SELECT t FROM Transporter t LEFT JOIN  t.user u  LEFT JOIN FETCH t.cityArrive c  LEFT JOIN FETCH t.state s WHERE u.email=?1")
    Transporter findProfileTransporterRepository(String string);

//  пошук авторизованого користувача	
	@Query("SELECT u FROM User u LEFT JOIN  u.transporter t WHERE u.email=?1")
	User findProfileUserRepository(String string);

//  пошук користувача за owner.id
	@Query("SELECT u FROM User u LEFT JOIN  u.owner o WHERE o.id=?1")
	User findUserWithOwnId(Integer id);
	
}
