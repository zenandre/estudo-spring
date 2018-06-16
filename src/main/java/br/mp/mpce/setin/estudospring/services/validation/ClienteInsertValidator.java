package br.mp.mpce.setin.estudospring.services.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.mp.mpce.setin.estudospring.dto.ClienteNewDTO;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO>{
	
	public void initializa(ClienteInsert ann) {
		
		
	}

	@Override
	public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
		
		return false;
	}

}
