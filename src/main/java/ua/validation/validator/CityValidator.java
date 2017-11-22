package ua.validation.validator;

import ua.repository.CityRepository;
import ua.validation.anotation.UnicCity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CityValidator implements ConstraintValidator<UnicCity, String>  {

	private final CityRepository repository;
	
	public CityValidator(CityRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void initialize(UnicCity arg0) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return repository.findByName(name) == null;
	}

}
