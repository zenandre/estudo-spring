package br.mp.mpce.setin.estudospring.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.mp.mpce.setin.estudospring.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	private Date dataVecimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido,Date dataVecimento,Date dataPagamento) {
		super(id, estadoPagamento, pedido);
		this.setDataVecimento(dataVecimento);
		this.setDataPagamento(dataPagamento);
	}

	public Date getDataVecimento() {
		return dataVecimento;
	}

	public void setDataVecimento(Date dataVecimento) {
		this.dataVecimento = dataVecimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	

}
