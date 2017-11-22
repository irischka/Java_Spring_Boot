package ua.service.impl;


import org.springframework.stereotype.Service;
import ua.entity.State;
import ua.repository.StateRepository;
import ua.service.StateService;

@Service
public class StateServiceImpl extends CrudServiceImpl<State, Integer> implements StateService {

	private final StateRepository repository;
	
	public StateServiceImpl(StateRepository repository) {
		super(repository);
		this.repository = repository;
		
	}

	@Override
	public State findByName(String name) {
		return repository.findByName(name);
	}

}
