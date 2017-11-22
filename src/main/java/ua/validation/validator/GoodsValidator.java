package ua.validation.validator;

import ua.repository.GoodsRepository;
import ua.validation.anotation.UniqueGoods;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GoodsValidator implements ConstraintValidator<UniqueGoods, String> {

	private final GoodsRepository repository;
	
	public GoodsValidator(GoodsRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueGoods arg0) {
	}

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return repository.findByName(name) == null;
	}

}
