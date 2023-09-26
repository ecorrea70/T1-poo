import java.util.ArrayList;
import java.util.List;

public class Venda {
    private static final double IMPOSTO = 0.25; // 25% de imposto
    private int numero;
    private List<ItemVenda> itens = new ArrayList<>();
    private boolean concluida = false;
    private Estoque estoque;

    public Venda(int numero, Estoque estoque) {
        this.numero=numero;
        this.estoque=estoque;
    }

    public boolean insereItem(Produto produto, int quantidade) {
        if (concluida) {
            System.out.println("A venda já foi concluída. Não é possível adicionar mais itens.");
            return false;
        }
        int codigoDoProduto = produto.getCodigo();
        int quantidadeDisponivel = estoque.getQuantidadeDisponivel(codigoDoProduto);

        if (quantidadeDisponivel >= quantidade) {
            ItemVenda item = new ItemVenda(produto, quantidade);
            itens.add(item);
            return true;
        } else {
            System.out.println("Quantidade insuficiente em estoque para adicionar este item.");
            return false;
        }
    }


    public void imprimeRecibo() {
        System.out.println("Recibo da Venda #" + numero);
        for (ItemVenda item : itens) {
            System.out.println("Descrição: " + item.getProduto().getDescricao());
            System.out.println("Quantidade: " + item.getQuantidadeDesejada());
            System.out.println("Valor Unitário: R$" + item.getProduto().getPrecoUnitario());
            System.out.println("Subtotal: R$" + item.getValorItem());
            System.out.println("--------------------------");
        }
        System.out.println("Subtotal: R$" + getSubtotal());
        System.out.println("Desconto: R$" + getDesconto());
        System.out.println("Imposto: R$" + getImposto());
        System.out.println("Total: R$" + getTotal());
    }

    public double getDesconto() {
        double subtotal = getSubtotal();
        return subtotal > 250 ? subtotal * 0.10 : 0;
    }

    public double getImposto() {
        return getSubtotal() * IMPOSTO;
    }

    public double getSubtotal() {
        double subtotal = 0;
        for (ItemVenda item : itens) {
            subtotal += item.getValorItem(); // Acumula o valor de cada item
        }
        return subtotal;
    }


    public double getTotal() {
        return getSubtotal() - getDesconto() + getImposto();
    }

    public boolean removeItem(int numero) {
        if (concluida) {
            System.out.println("A venda já foi concluída. ");
            System.out.println(("Não é possível remover itens."));
            return false;
        }

        for (ItemVenda item : itens) {
            if (item.getQuantidadeDesejada() == numero) {
                itens.remove(item);
                return true;
            }
        }

        System.out.println("Item não encontrado na venda.");
        return false;
    }

    public boolean conclui() {
        if (!concluida) {
            for (ItemVenda item : itens) {
                Produto produto = item.getProduto();
                int quantidade = item.getQuantidadeDesejada();
                int codigoDoProduto = produto.getCodigo();

                // Baixa a quantidade do item no estoque
                estoque.baixaEstoque(codigoDoProduto, quantidade);
            }

            concluida = true;
            return true;
        } else {
            System.out.println("A venda já foi concluída anteriormente.");
            return false;
        }
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}