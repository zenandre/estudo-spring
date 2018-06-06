package br.mp.mpce.setin.estudospring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mp.mpce.setin.estudospring.domain.Categoria;
import br.mp.mpce.setin.estudospring.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository reporitory;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = reporitory.findById(id);
		return obj.orElse(null);
	}
}
