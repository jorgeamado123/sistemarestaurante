package com.example.sistemarestaurante.controller;

import com.example.sistemarestaurante.model.Pedido;
import com.example.sistemarestaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoService.criarPedido(pedido);
    }

    @GetMapping("/abertos")
    public List<Pedido> listarPedidosAbertos() {
        return pedidoService.listarPedidosAbertos();
    }

    @PutMapping("/{id}/status")
    public Pedido atualizarStatus(@PathVariable Long id, @RequestParam Pedido.StatusPedido status) {
        return pedidoService.atualizarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
    }
}
