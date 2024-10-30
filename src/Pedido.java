public class Pedido {
    private int id;
    private String nome;
    private boolean vip;

    public Pedido(int id, String descricao, boolean vip) {
        this.id = id;
        this.nome = descricao;
        this.vip = vip;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + " nome: " + nome + " VIP: " + vip;
    }
}
