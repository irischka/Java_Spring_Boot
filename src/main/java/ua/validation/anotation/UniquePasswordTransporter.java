package ua.validation.anotation;

import ua.validation.validator.PaswordTransporterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PaswordTransporterValidator.class)
public @interface UniquePasswordTransporter {
	
	String message() default "Not unique";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}