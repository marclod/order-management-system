public class GerenciadorPedidos {
    private Pedido[] fila;
    private int tamanho;
    private int capacidade;

    public GerenciadorPedidos(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new Pedido[capacidade];
        this.tamanho = 0;
    }

    public boolean adicionarPedido(Pedido pedido) {
        if (tamanho >= capacidade) {
            System.out.println("Fila cheia não é possível adicionar mais pedidos.");
            return false;
        }
        fila[tamanho++] = pedido;
        return true;
    }

    public Pedido processarProximoPedido() {
        if (tamanho == 0) {
            System.out.println("Nenhum pedido na fila para processar.");
            return null;
        }
        int indexProximo = obterProximoIndex();
        Pedido proximo = fila[indexProximo];

        for (int i = indexProximo; i < tamanho - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[--tamanho] = null;
        return proximo;
    }

    public void visualizarFila() {
        if (tamanho == 0) {
            System.out.println("A fila está vazia.");
            return;
        }

        System.out.println("Pedidos na fila:");

        for (int i = 0; i < tamanho; i++) {
            if (fila[i].isVip()) {
                System.out.println(fila[i]);
            }
        }

        for (int i = 0; i < tamanho; i++) {
            if (!fila[i].isVip()) {
                System.out.println(fila[i]);
            }
        }
    }


    public boolean removerPedido(int id) {
        for (int i = 0; i < tamanho; i++) {
            if (fila[i].getId() == id) {
                for (int j = i; j < tamanho - 1; j++) {
                    fila[j] = fila[j + 1];
                }
                fila[--tamanho] = null;
                System.out.println("Pedido removido.");
                return true;
            }
        }
        System.out.println("Pedido não encontrado.");
        return false;
    }

    public boolean atualizarPrioridade(int id, boolean vip) {
        for (int i = 0; i < tamanho; i++) {
            if (fila[i].getId() == id) {
                fila[i].setVip(vip);
                System.out.println("Prioridade do pedido atualizada.");
                return true;
            }
        }
        System.out.println("Pedido não encontrado.");
        return false;
    }

    private int obterProximoIndex() {
        int indexVip = -1;
        for (int i = 0; i < tamanho; i++) {
            if (fila[i].isVip()) {
                indexVip = i;
                break;
            }
        }
        return (indexVip != -1) ? indexVip : 0;
    }
}
