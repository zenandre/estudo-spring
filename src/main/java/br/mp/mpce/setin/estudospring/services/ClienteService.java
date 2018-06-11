package br.mp.mpce.setin.estudospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mp.mpce.setin.estudospring.domain.Cliente;
import br.mp.mpce.setin.estudospring.repositories.ClienteRepository;
import br.mp.mpce.setin.estudospring.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository reporitory;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = reporitory.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "  + Cliente.class.getName())
				);
	}
}
