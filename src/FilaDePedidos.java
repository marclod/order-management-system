import java.util.List;

public interface FilaDePedidos<T> {
    void adicionarPedido(T pedido);
    T processarProximoPedido();
    List<T> visualizarPedidos();
    boolean cancelarPedido(String id);
    void atualizarPrioridade(String id, boolean isVip);
}
