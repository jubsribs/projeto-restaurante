package org.example.pedido;

import java.util.Collection;
import java.util.HashMap;

public class GerenciadorPedidos {
    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    public GerenciadorPedidos() {
        this.pedidos = new HashMap<>();
        this.contadorPedidos = contadorPedidos;
    }

    public int getContadorPedidos() {
        return contadorPedidos;
    }

    public void setContadorPedidos(int contadorPedidos) {
        this.contadorPedidos = contadorPedidos;
    }

    public Pedido criarPedido(String nomeCliente) {
        Pedido novo = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novo.getNumero(), novo);
        contadorPedidos++;
        return novo;
    }

    public Pedido buscarPedido(int numero) {
            return pedidos.get(numero);
    }

    public Collection<Pedido> getPedidos() {
        return pedidos.values();
    }

    public double calcularTotalDoDia() {
        double soma=0;
        for (Pedido p : pedidos.values()) {
            soma += p.calcularTotal();
        }
        return soma;

    }

    public boolean cancelarPedido(int numero) {
        return pedidos.remove(numero) != null;
    }
}

