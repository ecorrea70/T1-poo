import java.util.ArrayList;
import java.util.List;

public class HistoricoVendas {
    private List<Venda> vendas = new ArrayList<>();

    public boolean cadastraVenda(Venda venda) {
        vendas.add(venda);
        return true;
    }

    public Venda getVenda(int numero) {
        for (Venda venda : vendas) {
            if (venda.getNumero() == numero) {
                return venda;
            }
        }
        return null;
    }

    public Venda[] getUltimasVendas(int n) {
        int tamanho = vendas.size();
        int quantidade = Math.min(n, tamanho);

        Venda[] ultimasVendas = new Venda[quantidade];

        for (int i = 0; i < quantidade; i++) {
            ultimasVendas[i] = vendas.get(tamanho - 1 - i);
        }

        return ultimasVendas;
    }
}