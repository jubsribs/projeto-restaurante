package org.example.app;

import org.example.pedido.Pedido;

public class Main {
    static void main(){
        int opcao = -1;
        RestauranteFacade restaurante = new RestauranteFacade();
        MenuConsole menuConsole = new MenuConsole();

        while(opcao!=0){
            menuConsole.exibirMenu();
           opcao = menuConsole.lerOpcao();
            switch (opcao){
                case 1:
                    String nome = menuConsole.lerNomeCliente();
                    Pedido pedido = restaurante.criarPedido(nome);

                    menuConsole.registrarPedido(pedido.getNumero());

                    boolean adicionar = true;

                    while(adicionar){
                        menuConsole.exibirCardapio();
                        int escolha = menuConsole.lerOpcaoLanche();

                        boolean queijo = menuConsole.queijo();
                        boolean alface = menuConsole.alface();
                        boolean tomate = menuConsole.tomate();
                        boolean cebola = menuConsole.cebola();

                        boolean cheddar = menuConsole.comCheddar();
                        boolean baconExtra = menuConsole.comBaconExtra();

                       boolean adicionado = restaurante.adicionarLanche(pedido,escolha,cheddar,baconExtra,queijo,alface,tomate,cebola);

                       if(adicionado){
                           menuConsole.exibirMensagem("Lanche Adicionado!");
                       }
                       else{
                           menuConsole.exibirLancheInvalido();
                           continue;
                       }
                       adicionar = menuConsole.desejaAdicionarMais();
                    }
                    break;

                case 2:
                    menuConsole.exibirPedidos(restaurante.getPedidos());
                    break;
                case 3:
                    menuConsole.exibirFechamentoDoDia(restaurante.calcularTotalDoDia());
                    opcao=0;
                    break;
                case 4:
                    Pedido pedidoEncontrado = menuConsole.procurarPedido(restaurante.getPedidos());

                    if(pedidoEncontrado !=null){
                        menuConsole.modificarPedido(pedidoEncontrado,restaurante);
                    }
                    break;
                case 0:
                    menuConsole.exibirMensagem("Até Logo!");
                    break;
                default:
                    menuConsole.exibirMensagem("Opção Inválida!");
                    break;

            }
        }
    }
}
