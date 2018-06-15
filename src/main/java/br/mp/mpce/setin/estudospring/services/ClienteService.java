package br.mp.mpce.setin.estudospring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.mp.mpce.setin.estudospring.domain.Cidade;
import br.mp.mpce.setin.estudospring.domain.Cliente;
import br.mp.mpce.setin.estudospring.domain.Endereco;
import br.mp.mpce.setin.estudospring.domain.enums.TipoCliente;
import br.mp.mpce.setin.estudospring.dto.ClienteDTO;
import br.mp.mpce.setin.estudospring.dto.ClienteNewDTO;
import br.mp.mpce.setin.estudospring.repositories.CidadeRepository;
import br.mp.mpce.setin.estudospring.repositories.ClienteRepository;
import br.mp.mpce.setin.estudospring.repositories.EnderecoRepository;
import br.mp.mpce.setin.estudospring.services.exceptions.ConstraintException;
import br.mp.mpce.setin.estudospring.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository reporitory;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = reporitory.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = reporitory.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente clienteToUpdate = findById(obj.getId());
		updateData(clienteToUpdate, obj);
		return reporitory.save(clienteToUpdate);
	}

	public void delete(Integer id) {
		findById(id);
		try {
			reporitory.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConstraintException("Não é possivel excluir um Cliente");
		}

	}

	public List<Cliente> findAll() {
		return reporitory.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String direction, String orderby) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderby);
		return reporitory.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO obj) {
		return new Cliente(obj.getId(), obj.getNome(), obj.getEmail(), null, null);
	}

	public Cliente fromDTO(ClienteNewDTO objDTO) {

		Cliente cliente = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpfOuCnpj(),
				TipoCliente.toEnum(objDTO.getTipo()));
		Optional<Cidade> cidade = cidadeRepository.findById(objDTO.getCidadeId());
		Endereco endereco = new Endereco(null, objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(),
				objDTO.getBairro(), objDTO.getCep(), cliente, cidade.orElse(null));
		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(objDTO.getTelefone1());
		if (objDTO.getTelefone2() != null) {
			cliente.getTelefones().add(objDTO.getTelefone2());
		}
		if (objDTO.getTelefone3() != null) {
			cliente.getTelefones().add(objDTO.getTelefone3());
		}
		
		return cliente;
	}

	private void updateData(Cliente clienteToUpdate, Cliente obj) {
		clienteToUpdate.setNome(obj.getNome());
		clienteToUpdate.setEmail(obj.getEmail());
	}
}
