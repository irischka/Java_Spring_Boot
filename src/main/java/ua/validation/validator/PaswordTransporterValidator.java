package ua.validation.validator;

import ua.model.request.TransporterRequestNew;
import ua.validation.anotation.UniquePasswordTransporter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PaswordTransporterValidator implements  ConstraintValidator<UniquePasswordTransporter, Object> {

@Override
public void initialize(UniquePasswordTransporter arg0) {
}

@Override
public boolean isValid(Object candidate, ConstraintValidatorContext arg1) {
    TransporterRequestNew transporter = (TransporterRequestNew) candidate;
    return transporter.getPassword().equals(transporter.getRepeatPassword());
}
}