package ua.validation.validator;

import ua.repository.ModelRepository;
import ua.validation.anotation.UniqueModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ModelValidator implements ConstraintValidator<UniqueModel, String> {

	private final ModelRepository repository;
	
	public ModelValidator(ModelRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueModel arg0) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return repository.findByName(name) == null;
	}

}
