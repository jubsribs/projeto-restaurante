package org.example.cardapio;

public class ComBaconExtra extends Adicionais{

    public ComBaconExtra(ItemCardapio item) {
        super(item);
    }

    @Override
    public String getDescricao() {
        return item.getDescricao() + " + bacon extra";
    }

    @Override
    public double getPreco() {
        return item.getPreco() + 6.00;
    }
}
