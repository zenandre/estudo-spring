package br.mp.mpce.setin.estudospring.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_item_pedido_gen")
	@SequenceGenerator(name = "seq_id_item_pedido_gen", sequenceName = "seq_id_item_pedido")
	private Integer id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	private Double desconto;
	private Integer quantidade;
	private Double preco;

	public ItemPedido() {
		
	}
	
	
	
	public ItemPedido(Integer id, Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		super();
		this.id = id;
		this.pedido = pedido;
		this.produto = produto;
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}



	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", pedido=" + pedido + ", produto=" + produto + ", desconto=" + desconto
				+ ", quantidade=" + quantidade + ", preco=" + preco + "]";
	}

}
