package ua.validation.validator;

import org.springframework.stereotype.Component;
import ua.repository.BrandRepository;
import ua.validation.anotation.UniqueBrand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class BrandValidator implements ConstraintValidator<UniqueBrand, String> {

	private final BrandRepository repository;
	
	public BrandValidator(BrandRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueBrand arg0) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return repository.findByName(name)==null;
	}

	
}
