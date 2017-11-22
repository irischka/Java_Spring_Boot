package ua.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.entity.State;
import ua.repository.StateRepository;

@Component
public class StateConverter implements Converter<String, State> {

	private final StateRepository repository;

	public StateConverter(StateRepository repository) {
		this.repository = repository;
	}

	@Override
	public State convert(String name) {
		return repository.findByName(name);
	}

}
