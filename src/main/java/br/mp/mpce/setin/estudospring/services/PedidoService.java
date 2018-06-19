package br.mp.mpce.setin.estudospring.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mp.mpce.setin.estudospring.domain.ItemPedido;
import br.mp.mpce.setin.estudospring.domain.PagamentoComBoleto;
import br.mp.mpce.setin.estudospring.domain.Pedido;
import br.mp.mpce.setin.estudospring.domain.enums.EstadoPagamento;
import br.mp.mpce.setin.estudospring.repositories.ItemPedidoRepository;
import br.mp.mpce.setin.estudospring.repositories.PagamentoRepository;
import br.mp.mpce.setin.estudospring.repositories.PedidoRepository;
import br.mp.mpce.setin.estudospring.repositories.ProdutoRepository;
import br.mp.mpce.setin.estudospring.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository reporitory;
	@Autowired
	private BoletoService boletoService;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = reporitory.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pgto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pgto, obj.getInstante());
		}
		obj = reporitory.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido item : obj.getItens()) {
			item.setDesconto(0.0);
			item.setPreco(produtoRepository.findById(item.getProduto().getId()).orElse(null).getPreco());
			item.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
}
