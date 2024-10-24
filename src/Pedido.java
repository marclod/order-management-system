public class Pedido implements Comparable<Pedido> {
    private final String id;
    private final String cliente;
    private final boolean isVip;
    private final long timestamp;

    public Pedido(String id, String cliente, boolean isVip) {
        this.id = id;
        this.cliente = cliente;
        this.isVip = isVip;
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public boolean isVip() {
        return isVip;
    }

    @Override
    public int compareTo(Pedido outro) {
        if (this.isVip != outro.isVip) {
            return this.isVip ? -1 : 1;
        }
        return Long.compare(this.timestamp, outro.timestamp);
    }

    @Override
    public String toString() {
        return String.format("Pedido - ID: %s, Cliente: %s, VIP: %s", id, cliente, isVip ? "Sim" : "Não");
    }
}
