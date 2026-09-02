package edu.dosw.parcial;

public class EntregaSalon extends PedidoDecorator {
    private String bloque;
    private String salon;

    public EntregaSalon(IPedido pedido, String bloque, String salon) {
        super(pedido);
        this.bloque = bloque;
        this.salon = salon;
    }

    @Override
    public double getCostoExtra() { return 1000.0; }

    @Override
    public String getDescripcionExtra() {
        return "Entrega Salon: " + bloque + "-" + salon;
    }

    @Override
    public String getNombreEntrega() {
        return "entrega";
    }
}