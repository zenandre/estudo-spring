package br.mp.mpce.setin.estudospring.services;

import java.util.Optional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mp.mpce.setin.estudospring.domain.Categoria;
import br.mp.mpce.setin.estudospring.repositories.CategoriaRepository;
import br.mp.mpce.setin.estudospring.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository reporitory;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = reporitory.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: "  + Categoria.class.getName())
				);
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return reporitory.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		findById(obj.getId());
		return reporitory.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
		reporitory.deleteById(id);
		} catch (ConstraintViolationException e) {
			throw new ConstraintViolationExc;
		}
	}
}
