package edu.dosw.parcial;

public class ConsumoLocal extends PedidoDecorator {
    public ConsumoLocal(IPedido pedido) {
        super(pedido);
    }

    @Override
    public double getCostoExtra() { return 0.0; }

    @Override
    public String getDescripcionExtra() {
        return null;
    }

    @Override
    public String getNombreEntrega() {
        return "consumo local";
    }
}