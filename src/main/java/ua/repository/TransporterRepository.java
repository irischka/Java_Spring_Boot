package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ua.entity.*;
import ua.model.view.TransporterIndexView;

import java.util.List;

public interface TransporterRepository extends JpaNameRepository<Transporter, Integer>, JpaSpecificationExecutor<Transporter> {
	
	Transporter findByPhone(String phone);

//  Пошку всіх брендів
	@Query("SELECT b.name FROM Brand b")
	List<String> findAllBrand();

//  Пошук всіх моделей		
	@Query("SELECT m.name FROM Model m")
	List<String> findAllModel();

//  Пошук всіх міст		
	@Query("SELECT c.name FROM City c")
	List<String> findAllCity(); 
	
//  Пошук всіх статусів
	@Query("SELECT s.name FROM State s")
	List<String> findAllState();

//  Пошук коментарів що відносяться до транспортера	
	@Query(value="SELECT c FROM Comment c  JOIN c.user u JOIN u.transporter t WHERE t.id = ?1 ORDER BY c DESC",
			countQuery="SELECT count(c.id) FROM Comment c JOIN c.user u JOIN u.transporter t WHERE t.id = ?1")
	Page<Comment> findAllComment(Integer id, Pageable pageable);
    
//  топ 5 транспортерів 
	@Query(value="SELECT new ua.model.view.TransporterIndexView(t.id, t.rate, t.maxWeight, t.name, t.count, t.photoUrl)  FROM Transporter t ORDER BY t.rate DESC")
	List<TransporterIndexView> findFiveTransporter(Pageable pageable);
	
//  пошук транспортера за id	
	@Query("SELECT t FROM Transporter t JOIN FETCH t.model m JOIN FETCH t.cityArrive c JOIN FETCH t.state s LEFT JOIN t.user u WHERE t.id=?1")
    Transporter findOneRequest(Integer id);
	
//  знайти всіх транспортерів за cargo.id для видалення	
	@Query("SELECT t FROM Transporter t JOIN FETCH t.model m JOIN FETCH t.cityArrive c JOIN FETCH t.state s LEFT JOIN FETCH t.cargos car WHERE car.id=?1")
	List<Transporter> findAll(Integer id);
		
//  Вибір транспортера який перевозить чи перевозив товар
	@Query("SELECT t FROM Transporter t LEFT JOIN  t.cargos c WHERE t.id IN (SELECT c.transporterId FROM Cargo c WHERE c.id=?1)")
	List<Transporter> findOneTransporter(Integer id, Pageable pageable);

//  вибір статусу in the way	
	@Query("SELECT s FROM State s WHERE s.id=2")
	State findNotFreeState();
	
//  вибір статусу free
	@Query("SELECT s FROM State s WHERE s.id=1")
	State findFreeState();

//  Пошук користувача за id транспортера
	@Query("SELECT u FROM User u LEFT JOIN u.transporter t WHERE t.id=?1")
	User findUserWithID(Integer id);
	
//  вибір з таблиці місто not selected	
	@Query("SELECT c FROM City c WHERE c.name='Not selected'")
    City findCityNotSelected();

//  Максимальна кількість оцінок
	@Query("SELECT max(t.countVotes) FROM Transporter t")
	int findMaxCountVotes();

}
