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

    /*
    public double valorFinal() {
    if(valorTotal > 250) {
        double desconto = valorTotal * 0.10;
        double valorDesconto = valorTotal - desconto;
        double valorImposto = valorDesconto * 1.25;
        return valorImposto;
    }
        else {

        double valorImposto = valorTotal *1.25;
        return valorImposto;

        }

    }
                    **NÃO SABIA ONDE BOTAR ENTÃO SÓ FIZ O METODO E DEIXEI AQUI
    */



}
