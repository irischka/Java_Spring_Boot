package ua.service;

import ua.entity.State;

public interface StateService extends CrudService<State, Integer> {

	State findByName(String name);
}
