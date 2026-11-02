##Projeto - Sistema de Restaurante

#O que é:
Construir um  sistema de um restaurante: cardápio, pedidos, personalização dos lanches e fechamento do dia.

#Organização dos Pacotes:
-app
Contém o Main, o MenuConsole e a RestauranteFacade.

A main é utilizada apenas para o fluxo principal, delegando as interações com o MenuConsole.
O MenuConsole possui todo o funcionamento que acontece quando o usuário solicita algo e responsável por enviar os logs de interação.
No restauranteFacade é a interface que interage com a complexidade das outras classes.

-cardapio
Contém Lanche, ItemCardapio, a factory e os adicionais.

A classe Lanche possui os atributos privados: é responsável por gerenciar um lanche individualmente relacionado a um pedido.
A interface ItemCardapio possui os metodos descrição e preço que são utilizados na criação do pedido.
o Lanche factory é usado para a criação dos lanches.
As classes Adicionais, ComBaconExtra e ComCheddar são um decorator utilizados para colocar ingredientes extras ao lanche alterando seu formato e seu preço.

-pedido
Contém Pedido e as classes relacionadas aos pedidos. 

O pedido é a classe que gerencia todo que envolve o pedido do cliente, a interação diretamente com o cliente.
GerenciadorPedidos é a classe que cria os pedidos, calcula o total de faturamento do dia e o cancelamento.

-Teste
LancheTest, AdicionaisTest

O LancheTest ele testa se o preço calculado pelo sistema é um preço positivo, preços negativos não são aceitos.
AdicionaisTest testa se ao adicionar baconExtra por exemplo, o sistema recalcula o preço final com o adicional do ingrediente corretamente.

Video do Sistema: 