package br.mp.mpce.setin.estudospring.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.mp.mpce.setin.estudospring.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	public void preencherPagamentoComBoleto(PagamentoComBoleto pgto, Date instantePedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instantePedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
	}

}
