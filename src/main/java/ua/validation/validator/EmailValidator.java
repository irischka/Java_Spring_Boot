package ua.validation.validator;

import ua.repository.UserRepository;
import ua.validation.anotation.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<UniqueEmail, String> {

	private final UserRepository repository;
	
	public EmailValidator(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueEmail arg0) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return repository.findByEmail(name.trim()) == null;
	}

}
