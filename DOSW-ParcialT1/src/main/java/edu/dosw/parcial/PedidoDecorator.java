package edu.dosw.parcial;

import java.util.List;
import java.util.stream.IntStream;

public abstract class PedidoDecorator implements IPedido {
    protected IPedido pedidoEnvuelto;

    public PedidoDecorator(IPedido pedidoEnvuelto) {
        this.pedidoEnvuelto = pedidoEnvuelto;
    }

    @Override
    public double getTotal() {
        return pedidoEnvuelto.getTotal() + getCostoExtra();
    }

    @Override
    public List<ItemPedido> getItems() {
        return pedidoEnvuelto.getItems();
    }

    @Override
    public String getResumen() {
        String baseResumen = pedidoEnvuelto.getResumen();
        List<ItemPedido> items = getItems();
        StringBuilder sb = new StringBuilder(baseResumen);

        String lineaEntrega = getDescripcionExtra();
        if (lineaEntrega != null && !lineaEntrega.isEmpty() && getCostoExtra() > 0) {
            sb.append(lineaEntrega).append("\n\n");
        }

        if (items.size() == 1) {
            sb.append("Desglose:\n");
            ItemPedido item = items.get(0);
            sb.append("  $").append(item.getProducto().getPrecio())
              .append("  (base)").append("\n");

            item.getExtras().forEach(e -> 
                sb.append("  +$").append(e.getPrecio())
                  .append(" (").append(e.getNombre()).append(")").append("\n")
            );

            if (getCostoExtra() > 0) {
                sb.append("  +$").append(getCostoExtra())
                  .append(" (").append(getNombreEntrega()).append(")").append("\n");
            }
            sb.append("\n");
        } else {

            IntStream.range(0, items.size()).forEach(i -> {
                ItemPedido item = items.get(i);
                sb.append("Desglose #").append(i + 1).append(":\n");
                sb.append("  $").append(item.getProducto().getPrecio())
                  .append("  (base)").append("\n");
                item.getExtras().forEach(e -> 
                    sb.append("  +$").append(e.getPrecio())
                      .append(" (").append(e.getNombre()).append(")").append("\n")
                );
                double subtotal = item.calcularSubtotal();
                sb.append("Subtotal: $").append(subtotal).append("\n\n");
            });
            
        }

        sb.append("TOTAL: $").append(getTotal()).append("\n");
        sb.append("Estado: CONFIRMADO");
        return sb.toString();
    }

    public abstract double getCostoExtra();
    public abstract String getDescripcionExtra();
    public abstract String getNombreEntrega();

}