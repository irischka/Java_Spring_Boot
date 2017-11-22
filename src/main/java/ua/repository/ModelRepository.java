 package ua.repository;


 import org.springframework.data.domain.Page;
 import org.springframework.data.domain.Pageable;
 import org.springframework.data.jpa.repository.Query;
 import ua.entity.Model;
 import ua.model.view.ModelView;

 import java.util.List;

 public interface ModelRepository extends JpaNameRepository<Model, Integer> {

 //  пошук всіх брендів
     @Query("SELECT b.name FROM Brand b ")
     List<String> findAllBrand();

 //  Пошку всіх моделей + посторіночна розбивка
     @Query(value ="SELECT new ua.model.view.ModelView(m.id, b.name, m.name ) FROM Model m JOIN m.brand b",
             countQuery="SELECT count(m.id) FROM Model m JOIN m.brand b")
     Page<ModelView> FindAllView(Pageable pageable);

 //  пошук моделей за id
     @Query("SELECT m FROM Model m JOIN FETCH m.brand b WHERE m.id=?1")
     Model findOneRequest(Integer id);
 }
