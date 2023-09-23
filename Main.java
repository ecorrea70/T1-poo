public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Produto produto1 = new Produto(1, "Camisa do Gremio", 399.90);
        Produto produto2 = new Produto(2, "Baralho de Truco", 14.50);
        Produto produto3 = new Produto(3, "Fogão", 879.00);
        Produto produto4 = new Produto(4, "Ferro de Passar", 450.00);


        estoque.cadastraProduto(produto1, 50);
        estoque.cadastraProduto(produto2, 20);

        boolean baixa1 = estoque.baixaEstoque(1, 20);
        boolean baixa2 = estoque.baixaEstoque(2, 40);

        int quantidadeDisponivel1 = estoque.getQuantidadeDisponivel(1);
        int quantidadeDisponivel2 = estoque.getQuantidadeDisponivel(2);

        System.out.println("Baixa 1: " + baixa1);
        System.out.println("Baixa 2: " + baixa2);
        System.out.println("Quantidade disponível do Produto 1: " + quantidadeDisponivel1);
        System.out.println("Quantidade disponível do Produto 2: " + quantidadeDisponivel2);

        boolean reposicao1 = estoque.reposicaoEstoque(1, 50);
        int quantidadeDisponivel3 = estoque.getQuantidadeDisponivel(1);

        System.out.println("Reposição 1: " + reposicao1);
        System.out.println("Quantidade disponível do Produto 1: " + quantidadeDisponivel3);
    }
}
