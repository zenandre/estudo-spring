package br.mp.mpce.setin.estudospring.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.mp.mpce.setin.estudospring.domain.Cliente;
import br.mp.mpce.setin.estudospring.services.validation.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@NotEmpty(message="Nome obrigatório")
	@Length(min=5,max=120,message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	@NotEmpty(message="Email Obrigatório")
	@Email(message="Email inválido")
	private String email;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
