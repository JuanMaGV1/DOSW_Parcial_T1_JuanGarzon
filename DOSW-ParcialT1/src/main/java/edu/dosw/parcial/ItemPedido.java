package edu.dosw.parcial;

import java.util.ArrayList;
import java.util.List;

public class ItemPedido {
    private Producto producto;
    private List<Extra> extras;

    public ItemPedido(Producto producto) {
        this.producto = producto;
        this.extras = new ArrayList<>();
    }

    public void addExtra(Extra extra) {
        extras.add(extra);
    }

    public Producto getProducto() { return producto; }
    public List<Extra> getExtras() { return extras; }

    public double calcularSubtotal() {
        return producto.getPrecio() + extras.stream().mapToDouble(Extra::getPrecio).sum();
    }
}
