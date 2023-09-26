import java.util.ArrayList;
import java.util.List;

public class CatalogoProdutos {
    private List<Produto> produtos;

    public CatalogoProdutos() {
        produtos = new ArrayList<>();
    }

    public boolean cadastraProduto(Produto produto) {
        produtos.add(produto);
        return true;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto(int index) {
        if (index >= 0 && index < produtos.size()) {
            return produtos.get(index);
        } else {
            System.out.println("Posição inexistente na lista");
            return null;
        }
    }
}
