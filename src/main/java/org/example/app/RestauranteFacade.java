package org.example.app;

import org.example.cardapio.*;
import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;

import java.util.Collection;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador;

    public RestauranteFacade() {
        this.gerenciador = new GerenciadorPedidos();
    }

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public boolean adicionarLanche(Pedido pedido, int opcao, boolean cheddar, boolean baconExtra,boolean queijo, boolean alface, boolean tomate, boolean cebola) {
        Lanche lanche;

        switch (opcao) {
            case 1:
                lanche = LancheFactory.xBurguer();
                break;

            case 2:
                lanche =LancheFactory.xSalada();
                break;

            case 3:
                lanche = LancheFactory.xBacon();
                break;

            default:
                return false;
        }

        lanche.setQueijo(queijo);
        lanche.setAlface(alface);
        lanche.setTomate(tomate);
        lanche.setCebola(cebola);

        ItemCardapio item = lanche;

        if(cheddar){
            item = new ComCheddar(item);
        }
        if(baconExtra){
            item = new ComBaconExtra(item);
        }
        pedido.adicionarItem(item);
        return true;
    }

    public Collection<Pedido> getPedidos() {
        return gerenciador.getPedidos();
    }
    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }


    public boolean cancelarPedido(int numero) {
        return gerenciador.cancelarPedido(numero);
    }
}
