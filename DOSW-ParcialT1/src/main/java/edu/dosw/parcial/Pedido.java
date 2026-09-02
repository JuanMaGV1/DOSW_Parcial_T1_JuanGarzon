package edu.dosw.parcial;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Pedido implements IPedido {
    private String usuario;
    private List<ItemPedido> items;

    public Pedido(String usuario) {
        this.usuario = usuario;
        this.items = new ArrayList<>();
    }

    public void addItem(ItemPedido item) {
        items.add(item);
    }

    public String getUsuario() { return usuario; }
    
    @Override
    public List<ItemPedido> getItems() { return items; }

    @Override
    public double getTotal() {
        return items.stream().mapToDouble(ItemPedido::calcularSubtotal).sum();
    }

    @Override
    public String getResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("Descripción del Pedido:\n\n");
        IntStream.range(0, items.size()).forEach(i -> {
            ItemPedido item = items.get(i);
            sb.append("Producto #").append(i + 1).append(":\n");
            sb.append(item.getProducto().getNombre()).append("\n");
            if (!item.getExtras().isEmpty()) {
                item.getExtras().forEach(e -> sb.append("  + ").append(e.getNombre()).append("\n"));
            }
            sb.append("\n");
        });
        return sb.toString();
    }
}