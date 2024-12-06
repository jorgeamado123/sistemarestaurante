package com.example.sistemarestaurante.service;

import com.example.sistemarestaurante.model.Pedido;
import com.example.sistemarestaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido) {
        pedido.setStatus(Pedido.StatusPedido.ABERTO);
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidosAbertos() {
        return pedidoRepository.findByStatus(Pedido.StatusPedido.ABERTO);
    }

    public Pedido atualizarStatus(Long id, Pedido.StatusPedido status) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }

    public void excluirPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        if (pedido.getStatus() == Pedido.StatusPedido.CANCELADO) {
            pedidoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Apenas pedidos cancelados podem ser excluídos");
        }
    }
}
