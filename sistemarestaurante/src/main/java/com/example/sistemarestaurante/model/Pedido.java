package com.example.sistemarestaurante.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;

    private String enderecoEntrega;

    @ElementCollection
    private List<String> itens;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @Enumerated(EnumType.STRING)
    private Plataforma plataforma;

    public enum StatusPedido {
        ABERTO, EM_PREPARACAO, FINALIZADO, CANCELADO
    }

    public enum Plataforma {
        MOBILE, PRESENCIAL, WEB
    }
}
