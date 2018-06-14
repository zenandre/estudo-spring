package br.mp.mpce.setin.estudospring.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.mp.mpce.setin.estudospring.domain.Categoria;

public class CategoriaDTO {

	private Integer id;
	
	@NotEmpty(message="Nome obrigatório")
	@Length(min=5,max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	
	public CategoriaDTO() {
		
	}
	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
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
	
	
	
}
