
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 28/08/2017, 10:32:35
 */
public class Venda {

    //Demais atribuitos
    private List<String> produtosComDesconto;
    private List<String> produtosVendidos;

    public ItensDeVenda produtosComDesconto() {
        return new ItensDeVenda(produtosComDesconto);
    }

    public ItensDeVenda produtosVendidos() {
        return new ItensDeVenda(produtosComDesconto);
    }

    public void aplicarDesconto(Calculator calculator) {
        this.produtosComDesconto = this.produtosComDesconto
                .stream()
                .map(calculator)
                .collect(Collectors.toList());
    }

}

class ItensDeVenda {

    private final List<String> produtos;

    public ItensDeVenda(List<String> produtos) {
        this.produtos = produtos;
    }

    public void add(String produto) {
        this.produtos.add(produto);
    }

    public void remove(String produto) {
        this.produtos.remove(produto);
    }
}

interface Calculator extends Function<String, String> {

    int calcule();
}

class Simples implements Calculator {

    @Override
    public int calcule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String apply(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class A {

    public static void main(String[] args) {
        Venda venda = new Venda();
        venda.produtosComDesconto().add("");
        venda.produtosComDesconto().remove("");
    }
}
