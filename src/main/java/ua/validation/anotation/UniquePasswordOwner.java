package ua.validation.anotation;

import ua.validation.validator.PaswordOwnerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PaswordOwnerValidator.class)
public @interface UniquePasswordOwner {

	String message() default "Not unique";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
