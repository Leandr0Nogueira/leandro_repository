package Produtos;

import Pessoas.Usuario;

public class FactoryItemEstoque {

    public static ItemEstoque criarItemEstoqueFisico(Livro livro, Usuario vendedor, Integer quantidade, Float valor){
        return new ItemEstoqueFisico(livro, vendedor, quantidade, valor);
    }

    public static ItemEstoque criarItemEstoqueDigital(Livro livro, Usuario vendedor, Integer quantidade, Float valor){
        return new ItemEstoqueDigital(livro, vendedor, quantidade, valor);
    }
}
