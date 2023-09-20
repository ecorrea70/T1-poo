public class ItemEstoque {
    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidadeInicial) {
        this.produto = produto;
        this.quantidade = quantidadeInicial;
    }

    public boolean baixaEstoque(int baixa) {
        if (baixa > 0 && baixa <= quantidade) {
            quantidade -= baixa;
            return true;
        } else {
            return false;
        }
    }

    public boolean reposicaoEstoque(int reposicao) {
        if (reposicao > 0) {
            quantidade += reposicao;
            return true;
        } else {
            return false;
        }
    }


    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
