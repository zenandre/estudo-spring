package br.mp.mpce.setin.estudospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mp.mpce.setin.estudospring.domain.Pedido;
import br.mp.mpce.setin.estudospring.repositories.PedidoRepository;
import br.mp.mpce.setin.estudospring.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository reporitory;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = reporitory.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "  + Pedido.class.getName())
				);
	}
}
