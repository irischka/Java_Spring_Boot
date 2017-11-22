package ua.validation.validator;

import ua.model.request.OwnerRequest;
import ua.validation.anotation.UniquePasswordOwner;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PaswordOwnerValidator implements ConstraintValidator<UniquePasswordOwner,Object> {

	@Override
	public void initialize(UniquePasswordOwner arg0) {
	}

	@Override
	public boolean isValid(Object candidate, ConstraintValidatorContext arg1) {
		OwnerRequest owner = (OwnerRequest) candidate;
		return owner.getPassword().equals(owner.getRepeatPassword());
	}

	

}
