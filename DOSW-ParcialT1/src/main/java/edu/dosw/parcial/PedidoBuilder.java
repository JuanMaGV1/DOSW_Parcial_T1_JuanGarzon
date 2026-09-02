package edu.dosw.parcial;

import java.util.Arrays;

public class PedidoBuilder {
    private Pedido pedidoBase;
    private String tipoEntrega;
    private String[] paramsEntrega;

    public PedidoBuilder(String usuario) {
        this.pedidoBase = new Pedido(usuario);
    }

    public PedidoBuilder agregarProducto(Producto producto, Extra... extras) {
        ItemPedido item = new ItemPedido(producto);
        Arrays.stream(extras).forEach(item::addExtra);
        pedidoBase.addItem(item);
        return this;
    }

    public PedidoBuilder establecerEntrega(String tipo, String... params) {
        this.tipoEntrega = tipo;
        this.paramsEntrega = params;
        return this;
    }

    public IPedido build() {
        IPedido resultado = pedidoBase;
        if (tipoEntrega != null) {
            switch (tipoEntrega.toUpperCase()) {
                case "CONSUMO_LOCAL":
                    resultado = new ConsumoLocal(resultado);
                    break;
                case "PARA_LLEVAR":
                    resultado = new ParaLlevar(resultado);
                    break;
                case "ENTREGA_SALON":
                    resultado = new EntregaSalon(resultado, paramsEntrega[0], paramsEntrega[1]);
                    break;

            }
        }
        return resultado;
    }
}