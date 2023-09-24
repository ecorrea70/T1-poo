public class ItemVenda {

    private Produto produto;
    private int quantidadeDesejada;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidadeDesejada = quantidade;
    }

    public double calculaPreçoItem() {
        return produto.getPrecoUnitario() * quantidadeDesejada;

    }

    public int getQuantidadeDesejada() {
        return quantidadeDesejada;
    }

    public double getValorItem() {
        return calculaPreçoItem();
    }

    public Produto getProduto() {
        return produto;
    }





}
