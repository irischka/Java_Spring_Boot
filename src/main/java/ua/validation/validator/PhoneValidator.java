package ua.validation.validator;

import ua.repository.OwnerRepository;
import ua.validation.anotation.UniquePhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<UniquePhone, String>{

	private final OwnerRepository repository;
	
	public PhoneValidator(OwnerRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniquePhone arg0) {
	}

	@Override
	public boolean isValid(String phone, ConstraintValidatorContext context) {
		return repository.findByPhone(phone) == null;
	}
	

}
