package ua.validation.anotation;

import ua.validation.validator.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = EmailValidator.class )
public @interface UniqueEmail {

	String message() default "Not unique";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
