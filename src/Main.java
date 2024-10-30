public class Main {
    public static void main(String[] args) {
        GerenciadorPedidos gerenciador = new GerenciadorPedidos(10);

        // Adicionar pedidos
        Pedido pedido1 = new Pedido(1, "Cafe", false);
        Pedido pedido2 = new Pedido(2, "Cappuccino", true);
        Pedido pedido3 = new Pedido(3, "Latte", false);

        gerenciador.adicionarPedido(pedido1);
        gerenciador.adicionarPedido(pedido2);
        gerenciador.adicionarPedido(pedido3);

        gerenciador.visualizarFila();

        // Processar Próximo Pedido (deve priorizar VIP)
        Pedido proximo = gerenciador.processarProximoPedido();
        System.out.println("Processando pedido: " + proximo);

        // Visualizar Fila Após Processamento
        System.out.println("Fila de pedidos após processamento:");
        gerenciador.visualizarFila();

        // Remover Pedido Cancelado
        gerenciador.removerPedido(1);
        System.out.println("Fila após remover pedido ID 1:");
        gerenciador.visualizarFila();
        
        // Atualizar Prioridade de um Pedido
        gerenciador.atualizarPrioridade(3, true);
        System.out.println("Fila após atualizar prioridade do pedido ID 3 para VIP:");
        gerenciador.visualizarFila();
    }
}
