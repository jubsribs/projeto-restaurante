package org.example.cardapio;

public abstract class Adicionais implements ItemCardapio{

    protected ItemCardapio item;

    public Adicionais(ItemCardapio item) {
        this.item = item;
    }

    @Override
    public String getDescricao() {
        return item.getDescricao();
    }

    @Override
    public double getPreco() {
        return item.getPreco();
    }
}
