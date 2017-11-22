package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.model.filter.TransporterFilter;
import ua.model.view.TransporterIndexView;

public interface TransporterViewRepository {
	
//  Всі транспортери у вигялі transporterIndexView, + фільтрація та посторіночна розбивка
	Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable);
}
