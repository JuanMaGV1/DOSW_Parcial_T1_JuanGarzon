package edu.dosw.parcial;

public class ParaLlevar extends PedidoDecorator {
    public ParaLlevar(IPedido pedido) {
        super(pedido);
    }

    @Override
    public double getCostoExtra() { return 300.0; }

    @Override
    public String getDescripcionExtra() {
        return "Empaque para llevar";
    }

    @Override
    public String getNombreEntrega() {
        return "empaque";
    }
}