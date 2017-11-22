package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.entity.Cargo;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

//  Всі товари
	@Query("Select g.name FROM Goods g")
	List<String> findAllGoods();

//	Пошук міст
	@Query("Select c.name FROM City c")
	List<String> findAllCity();
	
//  Пошук  товару по id
	@Query("SELECT c FROM Cargo c JOIN FETCH c.cityTo cTo JOIN FETCH c.cityFrom cFrom JOIN FETCH c.goods g LEFT JOIN FETCH c.owner o JOIN FETCH o.user WHERE  c.id=?1")
    Cargo findOneRequest(Integer id);
	
//  знайти всі карго за transporter.id, для видалення
	@Query("SELECT c FROM Cargo c LEFT JOIN FETCH c.transporters t JOIN FETCH c.cityTo cTo JOIN FETCH c.cityFrom cFrom JOIN FETCH c.goods g LEFT JOIN FETCH c.owner o JOIN FETCH o.user   WHERE t.id=?1")
	List<Cargo> findAllRequest(Integer id);


//	Відображення поточного вантажу для транспортера
	@Query("SELECT c FROM Cargo c JOIN FETCH  c.cityTo cTo JOIN FETCH c.cityFrom cFrom JOIN FETCH c.goods g LEFT JOIN FETCH c.owner o LEFT JOIN FETCH c.transporters tr WHERE c.status = 'In the way' AND c.transporterId IN (SELECT t.id FROM Transporter t LEFT JOIN t.user u WHERE u.email=?1) ORDER BY c DESC")
	List<Cargo> FindOneConfirm(String name);

}
