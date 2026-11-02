package org.example.app;

import org.example.cardapio.ItemCardapio;
import org.example.pedido.Pedido;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    Scanner sc = new Scanner(System.in);

    public void exibirMenu(){
        System.out.println("\n=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Modificar um pedido");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public int lerOpcao(){
        int opcao=0;
        try {
            opcao = sc.nextInt();
            sc.nextLine();
        } catch (NumberFormatException  | InputMismatchException e) {
            sc.nextLine();
            return -1;
        }
        return opcao;

    }

    public String lerNomeCliente() {
        String nome;
        System.out.print("Digite o nome do cliente: ");
        nome = sc.nextLine();
        return nome;
    }

    public void exibirCardapio() {
        System.out.println("\n=== CARDÁPIO ===");
        System.out.println("1 - X-Burger  - R$ 16,00");
        System.out.println("2 - X-Salada  - R$ 18,00");
        System.out.println("3 - X-Bacon   - R$ 22,00");
    }

    public int lerOpcaoLanche() {
        System.out.print("Escolha um lanche: ");
        return lerOpcao();
    }

    public boolean desejaAdicionarMais() {
        System.out.print("Deseja adicionar mais um lanche? (s/n): ");

        String resposta = sc.nextLine();

        return resposta.equalsIgnoreCase("s");
    }

    public void exibirLancheInvalido() {
        System.out.println("Opção inválida! Escolha um lanche do cardápio.");
    }

    public void registrarPedido(int numero){
        System.out.println("Pedido número " + numero + " criado com sucesso!");
    }

    public void exibirPedidos(Collection<Pedido> pedidos) {

        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }

        System.out.println("\n=== PEDIDOS DO DIA ===");

        for (Pedido pedido : pedidos) {

            System.out.println("\nPedido: " + pedido.getNumero());
            System.out.println("Cliente: " + pedido.getNomeCliente());

            for (ItemCardapio item : pedido.getItens()) {
                System.out.printf(
                        "%s - R$ %.2f%n",
                        item.getDescricao(),
                        item.getPreco()
                );
            }

            System.out.printf(
                    "Total do pedido: R$ %.2f%n",
                    pedido.calcularTotal()
            );
        }
    }

    public void  exibirFechamentoDoDia(double total){
        System.out.println("\n=== FECHAMENTO DO RESTAURANTE ===");
        System.out.printf("Faturamento total: R$ %.2f%n", total);
        System.out.println("Restaurante fechado!");

    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public boolean comCheddar() {
        System.out.println("\nDeseja adicionar cheddar por R$ 4,00?");
        System.out.println("1 - Sim");
        System.out.println("0 - Não");
        System.out.print("Escolha: ");
        return lerOpcao() == 1;
    }

    public boolean comBaconExtra() {
        System.out.println("\nDeseja adicionar bacon extra por R$ 6,00?");
        System.out.println("1 - Sim");
        System.out.println("0 - Não");
        System.out.print("Escolha: ");
        return lerOpcao() == 1;
    }

    public boolean queijo(){
        System.out.println("\n Deseja retirar o queijo?(s/n)");
        return !sc.nextLine().equalsIgnoreCase("s");
    }

    public boolean alface(){
        System.out.println("\n Deseja retirar o alface(s/n)");
        return !sc.nextLine().equalsIgnoreCase("s");
    }

    public boolean tomate(){
        System.out.println("\n Deseja retirar o tomate?(s/n)");
        return !sc.nextLine().equalsIgnoreCase("s");
    }

    public boolean cebola(){
        System.out.println("\n Deseja retirar o cebola?(s/n)");
        return !sc.nextLine().equalsIgnoreCase("s");
    }

    public Pedido procurarPedido( Collection<Pedido> pedidos){
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return null;
        }
        System.out.println("Digite o número do pedido");
        int numero = lerOpcao();

        for(Pedido pedido : pedidos){
            if(pedido.getNumero() == numero){
                return pedido;
            }
        }
        System.out.println("Pedido não encontrado!");
        return null;
    }

    public void modificarPedido(Pedido pedido, RestauranteFacade restaurante){
        System.out.println("\n=== MODIFICAR PEDIDO ===");
        System.out.println("1 - Acrescentar um item");
        System.out.println("2 - Remover item");
        System.out.println("3 - Cancelar o pedido");
        System.out.println("0 - Voltar");

        System.out.print("Escolha uma opção: ");

        int op = lerOpcao();

            switch (op) {
                case 1:
                    System.out.println("\n=== ACRESCENTAR ITEM ===");

                    System.out.println("Escolha o lanche:");
                    System.out.println("1 - X-Burger");
                    System.out.println("2 - X-Salada");
                    System.out.println("3 - X-Bacon");

                    int opcaoLanche = lerOpcao();

                    boolean queijo = queijo();
                    boolean alface = alface();
                    boolean tomate = tomate();
                    boolean cebola = cebola();

                    boolean cheddar = comCheddar();
                    boolean bacon = comBaconExtra();

                    boolean adicionado = restaurante.adicionarLanche(
                            pedido,
                            opcaoLanche,
                            queijo,
                            alface,
                            tomate,
                            cebola,
                            cheddar,
                            bacon
                    );

                    if (adicionado) {
                        exibirMensagem("Item acrescentado com sucesso!");
                    } else {
                        exibirMensagem("Opção de lanche inválida!");
                    }

                    break;
                case 2:
                    listarItensPedido(pedido);
                    if (!pedido.estaVazio()) {
                        System.out.print("Digite o número do item que deseja remover: ");
                        int indice = lerOpcao();

                        if (pedido.removerItem(indice)) {
                            exibirMensagem("Item removido com sucesso!");
                        } else {
                            exibirMensagem("Número de item inválido!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Deseja realmente cancelar este pedido? (s/n)");
                    String resposta = sc.nextLine();

                    if (resposta.equalsIgnoreCase("s")) {

                        boolean cancelado = restaurante.cancelarPedido(
                                pedido.getNumero()
                        );

                        if (cancelado) {
                            exibirMensagem("Pedido cancelado com sucesso!");
                        } else {
                            exibirMensagem("Não foi possível cancelar o pedido.");
                        }

                    } else {
                        exibirMensagem("Cancelamento não realizado.");
                    }
                    break;
                case 0:
                    exibirMensagem("Voltando ao menu principal...");
                    break;
                default:
                    exibirMensagem("Opção inválida!");
                    break;
            }
    }

    public void listarItensPedido(Pedido pedido) {

        System.out.println("\n=== ITENS DO PEDIDO ===");

        if (pedido.estaVazio()) {
            System.out.println("Este pedido não possui itens.");
            return;
        }

        int numero = 1;

        for (ItemCardapio item : pedido.getItens()) {

            System.out.printf(
                    "%d - %s - R$ %.2f%n",
                    numero,
                    item.getDescricao(),
                    item.getPreco()
            );

            numero++;
        }
    }
}


