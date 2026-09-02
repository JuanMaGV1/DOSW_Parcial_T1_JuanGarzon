package edu.dosw.parcial;

import java.util.List;

public interface IPedido {
    double getTotal();
    String getResumen();
    List<ItemPedido> getItems();
}