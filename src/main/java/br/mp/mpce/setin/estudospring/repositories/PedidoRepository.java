package br.mp.mpce.setin.estudospring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mp.mpce.setin.estudospring.domain.Categoria;
import br.mp.mpce.setin.estudospring.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
