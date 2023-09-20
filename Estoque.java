import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<ItemEstoque> itens;

    public Estoque() {
        itens = new ArrayList<>();
    }

    public int getQuantidadeDisponivel(int codigo){
        for (ItemEstoque item : itens){
            if (item.getProduto().getCodigo() == codigo){
                return item.getQuantidade();
            }
        }
        return 0;
    }

    public boolean baixaEstoque(int codigo, int quantidade) {
        for (ItemEstoque item : itens) {
            if (item.getProduto().getCodigo() == codigo) {
                if(item.baixaEstoque(quantidade)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean reposicaoEstoque(int codigo, int quantidade) {
        for (ItemEstoque item : itens) {
            if (item.getProduto().getCodigo() == codigo) {
                return item.reposicaoEstoque(quantidade);
            }
        }
        return false;
    }


    public boolean cadastraProduto(Produto produto, int quantidade) {
        ItemEstoque novoItem = new ItemEstoque(produto, quantidade);
        itens.add(novoItem);
        return true;
    }


    public Produto getProduto(int codigo) {
        for (ItemEstoque item : itens) {
            if (item.getProduto().getCodigo() == codigo) {
                return item.getProduto();
            }
        }
        return null;
    }

}