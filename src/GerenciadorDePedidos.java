import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class GerenciadorDePedidos<T extends Comparable<T>> implements FilaDePedidos<T> {
    private final PriorityQueue<T> filaDePedidos;
    private final HashMap<String, T> mapaDePedidos;

    public GerenciadorDePedidos() {
        this.filaDePedidos = new PriorityQueue<>();
        this.mapaDePedidos = new HashMap<>();
    }

    // Adicionar um novo pedido
    @Override
    public void adicionarPedido(T pedido) {
        filaDePedidos.add(pedido);
        mapaDePedidos.put(((Pedido) pedido).getId(), pedido);  // Faz o casting de 'pedido' para 'Pedido' para poder acessar o metodo 'getId()' e obter o ID do pedido
    }

    // Processar o proximo pedido
    @Override
    public T processarProximoPedido() {
        T proximo = filaDePedidos.poll();
        if (proximo != null) {
            mapaDePedidos.remove(((Pedido) proximo).getId());
        }
        return proximo;
    }

    // Visualizar os pedidos na fila
    @Override
    public List<T> visualizarPedidos() {
        return new ArrayList<>(filaDePedidos);
    }

    // Remover um pedido cancelado
    @Override
    public boolean cancelarPedido(String id) {
        T pedido = mapaDePedidos.remove(id);
        if (pedido != null) {
            filaDePedidos.remove(pedido);
            return true;
        }
        return false;
    }

    // Atualizar a prioridade de um pedido
    @Override
    public void atualizarPrioridade(String id, boolean isVip) {
        T pedido = mapaDePedidos.get(id);
        if (pedido != null) {
            filaDePedidos.remove(pedido);
            Pedido pedidoAtualizado = new Pedido(((Pedido) pedido).getId(), ((Pedido) pedido).getCliente(), isVip);
            adicionarPedido((T) pedidoAtualizado);  // Reinsere o pedido com a nova prioridade
        }
    }
}
