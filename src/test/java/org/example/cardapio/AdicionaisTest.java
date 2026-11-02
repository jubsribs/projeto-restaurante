package org.example.cardapio;

import org.example.app.RestauranteFacade;
import org.example.pedido.Pedido;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdicionaisTest {

    @Test
    void getPreco() {
        RestauranteFacade restaurante = new RestauranteFacade();
        Pedido pedido = restaurante.criarPedido("juliana");

        restaurante.adicionarLanche(pedido,3,false, true,true,true,true,true);
        double precoEsperado = 28.00;
        double precoAtual = pedido.calcularTotal();

        assertEquals(precoEsperado, precoAtual, 0.001);


    }
}