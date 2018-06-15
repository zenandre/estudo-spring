package br.mp.mpce.setin.estudospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.mp.mpce.setin.estudospring.domain.Categoria;
import br.mp.mpce.setin.estudospring.domain.Cliente;
import br.mp.mpce.setin.estudospring.dto.CategoriaDTO;
import br.mp.mpce.setin.estudospring.repositories.CategoriaRepository;
import br.mp.mpce.setin.estudospring.services.exceptions.ConstraintException;
import br.mp.mpce.setin.estudospring.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository reporitory;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = reporitory.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return reporitory.save(obj);
	}

	public Categoria update(Categoria obj) {
		Categoria categoriaToUpdate = findById(obj.getId());
		updateData(categoriaToUpdate,obj);
		return reporitory.save(categoriaToUpdate);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			reporitory.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConstraintException("Não é possivel excluir uma categoria com produto vinculado");
		}

	}
	
	public List<Categoria> findAll() {
		return reporitory.findAll();
	}
	
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String direction, String orderby){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderby);
		return reporitory.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO obj) {
		return new Categoria(obj.getId(),obj.getNome());
	}
	private void updateData(Categoria categoriaToUpdate, Categoria obj) {
		categoriaToUpdate.setNome(obj.getNome());
	}
	
}
