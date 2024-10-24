import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaDePedidos<Pedido> gerenciador = new GerenciadorDePedidos<>();

        while (true) {
            System.out.println("\n---- Menu ----");
            System.out.println("1. Adicionar novo pedido");
            System.out.println("2. Processar proximo pedido");
            System.out.println("3. Visualizar pedidos na fila");
            System.out.println("4. Cancelar pedido");
            System.out.println("5. Atualizar prioridade de pedido");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    // Adicionar novo pedido
                    System.out.print("Digite o ID do pedido: ");
                    String id = scanner.nextLine();
                    System.out.print("Digite o nome do cliente: ");
                    String cliente = scanner.nextLine();
                    System.out.print("O cliente é VIP? (s/n): ");
                    String vipResposta = scanner.nextLine();
                    boolean isVip = vipResposta.equalsIgnoreCase("s");
                    Pedido novoPedido = new Pedido(id, cliente, isVip);
                    gerenciador.adicionarPedido(novoPedido);
                    System.out.println("Pedido adicionado com sucesso!");
                    break;

                case 2:
                    // Processar o próximo pedido
                    Pedido processado = gerenciador.processarProximoPedido();
                    if (processado != null) {
                        System.out.println("Pedido processado: " + processado);
                    } else {
                        System.out.println("Nenhum pedido para processar.");
                    }
                    break;

                case 3:
                    // Visualizar pedidos na fila
                    System.out.println("Pedidos na fila:");
                    List<Pedido> pedidos = gerenciador.visualizarPedidos();
                    if (pedidos.isEmpty()) {
                        System.out.println("Nenhum pedido na fila.");
                    } else {
                        for (Pedido pedido : pedidos) {
                            System.out.println(pedido);
                        }
                    }
                    break;

                case 4:
                    // Cancelar pedido
                    List<Pedido> pedidosC = gerenciador.visualizarPedidos();
                    if (pedidosC.isEmpty()) {
                        System.out.println("Nenhum pedido na fila.");
                    } else {
                        System.out.print("Digite o ID do pedido a ser cancelado: ");
                        String idParaCancelar = scanner.nextLine();
                        boolean cancelado = gerenciador.cancelarPedido(idParaCancelar);
                        if (cancelado) {
                            System.out.println("Pedido " + idParaCancelar + " cancelado com sucesso.");
                        } else {
                            System.out.println("Pedido não encontrado.");
                        }
                    }
                    break;

                case 5:
                    // Atualizar prioridade de um pedido
                    System.out.print("Digite o ID do pedido para atualizar prioridade: ");
                    String idParaAtualizar = scanner.nextLine();
                    System.out.print("Atualizar para VIP? (s/n): ");
                    String respostaVip = scanner.nextLine();
                    boolean novoVipStatus = respostaVip.equalsIgnoreCase("s");
                    gerenciador.atualizarPrioridade(idParaAtualizar, novoVipStatus);
                    System.out.println("Prioridade atualizada com sucesso.");
                    break;

                case 6:
                    // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção invalida! Tente novamente.");
                    break;
            }
        }
    }
}
