package ua.validation.validator;

import ua.repository.TransporterRepository;
import ua.validation.anotation.UniquePhoneTransporter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneTransporterValidator implements ConstraintValidator<UniquePhoneTransporter, String> {

	private final TransporterRepository repository;
	
	public PhoneTransporterValidator(TransporterRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniquePhoneTransporter arg0) {
	}

	@Override
	public boolean isValid(String phone, ConstraintValidatorContext context) {
		return repository.findByPhone(phone) == null;
	}

}
