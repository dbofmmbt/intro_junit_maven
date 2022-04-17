import carrinho.Carrinho;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CarrinhoTest {
    private Carrinho carrinho;

    @BeforeEach
    void setUp() {
        carrinho = new Carrinho();
    }

    private Produto produtoTeste = new Produto("teste", 10.0);

    @Test
    void addItemFunciona() {
        assertEquals(0, carrinho.getQtdeItems());
        carrinho.addItem(produtoTeste);
        assertEquals(1, carrinho.getQtdeItems());
    }

    @Test
    void removeItemFunciona() throws ProdutoNaoEncontradoException {
        assertEquals(0, carrinho.getQtdeItems());
        carrinho.addItem(produtoTeste);

        carrinho.removeItem(produtoTeste);

        assertEquals(0, carrinho.getQtdeItems());
    }

    @Test
    void valorTotal() throws ProdutoNaoEncontradoException {
        assertEquals(0.0, carrinho.getValorTotal());

        carrinho.addItem(produtoTeste);
        carrinho.addItem(new Produto("outro", 5.0));

        assertEquals(15.0, carrinho.getValorTotal());

        carrinho.removeItem(produtoTeste);

        assertEquals(5.0, carrinho.getValorTotal());
    }

    @Test
    void esvazia() {
        Produto[] produtos = {new Produto("a", 1.0), new Produto("b", 2.0), new Produto("c", 3.0)};
        for (Produto p : produtos) {
            carrinho.addItem(p);
        }
        assertNotEquals(0, carrinho.getQtdeItems());
        carrinho.esvazia();
        assertEquals(0, carrinho.getQtdeItems());
    }
}
