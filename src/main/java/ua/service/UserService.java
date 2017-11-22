package ua.service;

import ua.model.request.CommentRequest;
import ua.model.request.OwnerRequest;
import ua.model.request.TransporterRequestNew;

import java.util.List;

public interface UserService {

//  збереження зареєстрованого транспортера	
	void save(TransporterRequestNew request);

//  збереження зареєстрованого овнера	
	void save(OwnerRequest request);

// Оновлення інформації в профайлі	
	void saveOwner(OwnerRequest request);

//  Додавання нового товару в профайлі owner
	void saveCargo(OwnerRequest request);
	
//  оновлення інфо про транспортера в кабінеті	
	void saveTransporter(TransporterRequestNew request);

//  пошук моделей	
	List<String> findAllModels();
	
//  Для пошуку авторизованого овнера
	OwnerRequest findProfileOwner(String string);
	
//  пошук фвторизованого транспортера	
	TransporterRequestNew findProfileTransporter(String string);

//  Взяти в роботу, для транспортера	
	void addCargo(String name, Integer id);

//  відміна заявки на перевезення, видалення	
	void delete(String name, Integer id);

//  Видалення заявки транспортера на перевезення певного товару 
	void deleteOrder(Integer id, Integer transporterId);

//  Підтвердження однієї заяви і видалення всіх інших	
	void deleteAllOrder(Integer id, Integer transporterId);

//  підтвердження заявки на перевезення cargo	
	void orderCargo(Integer id, String name);

//  завершення перевезення 	
	void completeTrip(Integer id, String name);

//  Додавання коментарря до транспортера	
	void saveComment(CommentRequest request, Integer id, String email);

//  додавання коментаря овнеру	
	void saveCommentOwner(CommentRequest request, Integer id, String string);

//  рейтинг	
	void addRate(TransporterRequestNew request, Integer id);
}
