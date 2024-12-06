package com.example.sistemarestaurante.repository;

import com.example.sistemarestaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(Pedido.StatusPedido status);
}
