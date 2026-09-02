package edu.dosw.parcial;

public class Main {
    public static void main(String[] args) {
        Producto bandeja = new Producto("PROD-001", "Bandeja universitaria", 8500);
        Producto sandwich = new Producto("PROD-002", "Sándwich", 5000);
        Producto ensalada = new Producto("PROD-003", "Ensalada", 4500);
        Producto sopa = new Producto("PROD-004", "Sopa del día", 3500);
        Producto jugo = new Producto("PROD-005", "Jugo natural", 2500);

        Extra proteina = new Extra("EXT-001", "Proteína extra", 2000);
        Extra aguacate = new Extra("EXT-002", "Aguacate", 1500);
        Extra panIntegral = new Extra("EXT-003", "Pan Integral", 500);
        Extra queso = new Extra("EXT-004", "Queso", 800);

        // Escenario 1: Pedido Simple (Para Llevar)
        System.out.println("=== ESCENARIO 1: Pedido Simple ===");
        IPedido pedido1 = new PedidoBuilder("juan.perez@eci.edu.co")
                .agregarProducto(bandeja, proteina, aguacate)
                .establecerEntrega("PARA_LLEVAR")
                .build();
        System.out.println(pedido1.getResumen());

        // Escenario 2: Múltiples productos (Consumo Local)
        System.out.println("\n=== ESCENARIO 2: Múltiples productos ===");
        IPedido pedido2 = new PedidoBuilder("juan.perez@mail.escuelaing.edu.co")
                .agregarProducto(sandwich, panIntegral, queso)
                .agregarProducto(jugo)
                .establecerEntrega("CONSUMO_LOCAL")
                .build();
        System.out.println(pedido2.getResumen());

        // Escenario 3: Entrega en Salón
        System.out.println("\n=== ESCENARIO 3: Entrega en Salón ===");
        IPedido pedido3 = new PedidoBuilder("maria.gomez@mail.escuelaing.edu.co")
                .agregarProducto(ensalada, proteina, aguacate)
                .establecerEntrega("ENTREGA_SALON", "A", "2O1")
                .build();
        System.out.println(pedido3.getResumen());
    }
}