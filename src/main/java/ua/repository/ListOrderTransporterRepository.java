package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.model.filter.CargoFilter;
import ua.model.view.CargoView;

public interface ListOrderTransporterRepository {

//  Заявки на перевезення товарів у кабінеті транспортера
	Page<CargoView> findAllOrder(String name, CargoFilter filter, Pageable pageable);
}
