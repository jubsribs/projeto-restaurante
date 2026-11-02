package org.example.cardapio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheTest {

    @Test
    void setPreco() {
        Lanche lanche = new Lanche("juliana",5.58);
        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,()->lanche.setPreco(-2));

        assertEquals("O preço não pode ser negativo.", excecao.getMessage());
    }
}