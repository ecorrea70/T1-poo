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

    public Produto getProduto(int index) {
        if (index >= 0 && index < produtos.size()) {
            return produtos.get(index);
        } else {
            System.out.println("Posição inexistente na lista");
            return null;
        }
    }
}
