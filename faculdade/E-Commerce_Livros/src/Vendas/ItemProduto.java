package Vendas;

import Pessoas.Usuario;
import Produtos.Livro;

public class ItemProduto {
    private Livro livro;
    private String variacao;
    private Usuario vendedor;
    private Integer quantidade;
    private Float precoUnitario;
    private Float subtotal;

    public ItemProduto(Livro livro, String variacao, Usuario vendedor, Integer quantidade, Float precoUnitario) {
        this.livro = livro;
        this.vendedor = vendedor;
        this.variacao = variacao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.subtotal = precoUnitario * quantidade;
    }

    public Livro getLivro() {
        return livro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Float getPrecoUnitario() {
        return precoUnitario;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        this.subtotal = precoUnitario * quantidade;
    }

    public String getVariacao() {
        return variacao;
    }

    public String stringPreco(){
        return "R$ " + String.format("%.02f", precoUnitario);
    }

    @Override
    public String toString() {
        String variacao = "";
        if(getVariacao() != null){
            variacao = " (" + getVariacao() + ")";
        }
        return "Livro: " + livro.getNome() + variacao + " | Quantidade: "
                + quantidade + " | Preço: " + stringPreco();
    }
    
}
