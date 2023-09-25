public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        HistoricoVendas historico = new HistoricoVendas();

        //criação de produtos
        Produto produto1 = new Produto(1, "Camisa do Gremio", 399.90);
        Produto produto2 = new Produto(2, "Baralho de Truco", 14.50);
        Produto produto3 = new Produto(3, "Fogão", 879.00);
        Produto produto4 = new Produto(4, "Ferro de Passar", 450.00);
        estoque.cadastraProduto(produto1, 50);
        estoque.cadastraProduto(produto2, 20);
        estoque.cadastraProduto(produto3, 20);
        estoque.cadastraProduto(produto4, 30);


        //realiza uma venda, conclui, cadastra ela no historico e imprime o recibo da mesma
        //venda 1
        Venda venda1 = new Venda(1, estoque);
        venda1.insereItem(produto1, 3);
        venda1.insereItem(produto3,1);
        venda1.conclui();
        historico.cadastraVenda(venda1);
        venda1.imprimeRecibo();

        //venda 2
        Venda venda2 = new Venda(2, estoque);
        venda2.insereItem(produto2, 1);
        venda2.insereItem(produto4,2);
        venda2.insereItem(produto3, 1);
        venda2.conclui();
        historico.cadastraVenda(venda2);
        venda2.imprimeRecibo();


        //verifica a quantidade disponivel do item
        int quantidadeDisponivel2 = estoque.getQuantidadeDisponivel(1);
        System.out.println("Quantidade disponível do Produto 1: " + quantidadeDisponivel2);


        //realiza uma reposicao de estoqye e verifica se ela ocorreu com sucesso
        estoque.reposicaoEstoque(1, 30);
        int quantidadeDisponivel3 = estoque.getQuantidadeDisponivel(1);
        System.out.println("Quantidade disponível do Produto 1: " + quantidadeDisponivel3);


        //consulta uma venda especifica no historico e imprime o recibo dela
        Venda vendaRecuperada = historico.getVenda(1);
        if (vendaRecuperada != null) {
            System.out.println("VENDA PESQUISADA:");
            vendaRecuperada.imprimeRecibo();
        } else {
            System.out.println("Venda não encontrada.");
        }


        //consulta as ultimas 5 vendas e mostra o recibo de cada uma delas
        Venda[] ultimasVendas = historico.getUltimasVendas(5);

        for (Venda venda : ultimasVendas) {
            if (venda != null) {
                venda.imprimeRecibo();
                System.out.println("--------------------------");
                System.out.println("--------------------------");
                System.out.println("--------------------------");
            }
        }
    }
}
