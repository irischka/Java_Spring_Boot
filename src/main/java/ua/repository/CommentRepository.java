package ua.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.entity.Comment;

public interface CommentRepository  extends JpaRepository<Comment, Integer>{

//  для валідації	
	Comment findByComment(String name);
	
// перевірка чи транспортер перевозив товар даного овнера
	@Query("SELECT t.name FROM Transporter t LEFT JOIN t.user u  WHERE u.email = ?2 AND t.id IN (SELECT c.transporterId FROM Cargo c LEFT JOIN c.owner o WHERE o.id=?1)  ")
	String cheackTransporterUsecargo(Integer id, String principal);

// перевірка чи користувався авторизований овнер  послугами даного транспортера 
	@Query("SELECT o.name FROM Owner o LEFT JOIN o.user u LEFT JOIN o.cargos c WHERE u.email = ?2 AND c.transporterId IN (SELECT t.id FROM Transporter t  WHERE t.id=?1)  ")
	String cheackCargoUseTransporter(Integer id, String name);

}
