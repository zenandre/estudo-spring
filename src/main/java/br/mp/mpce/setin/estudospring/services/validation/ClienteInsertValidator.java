package br.mp.mpce.setin.estudospring.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.mp.mpce.setin.estudospring.domain.Cliente;
import br.mp.mpce.setin.estudospring.domain.enums.TipoCliente;
import br.mp.mpce.setin.estudospring.dto.ClienteNewDTO;
import br.mp.mpce.setin.estudospring.repositories.ClienteRepository;
import br.mp.mpce.setin.estudospring.resources.exceptions.FieldMessage;
import br.mp.mpce.setin.estudospring.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public void initialize(ClienteInsert ann) {

	}

	@Override
	public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDTO.getTipo().equals(TipoCliente.PESSOA_FISICA.getCod()) && !BR.isValidCPF(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj","CPF Inválido"));
		}
		
		if (objDTO.getTipo().equals(TipoCliente.PESSOA_JURIDICA.getCod()) && !BR.isValidCNPJ(objDTO.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj","CNPJ Inválido"));
		}
		
		Cliente cliente = clienteRepository.findByEmail(objDTO.getEmail());
		if (cliente != null){
			list.add(new FieldMessage("email","Email já cadastrado"));
		}
		
		for (FieldMessage fieldMessage : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(fieldMessage.getMessage())
					.addPropertyNode(fieldMessage.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();
	}

}
