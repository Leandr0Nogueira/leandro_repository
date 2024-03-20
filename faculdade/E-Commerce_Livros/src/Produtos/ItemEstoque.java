package Produtos;

import Pessoas.Usuario;

public abstract class ItemEstoque {
    private Livro livro;
    private Float preco;
    private Usuario vendedor;
    private String variacao;

    public Livro getLivro() {
        return livro;
    }

    protected void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String stringPreco(){
        return "Preço: R$ " + String.format("%.02f", preco);
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    protected void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public abstract Boolean verificarDisponibilidade(Integer quantidade);

    public abstract Integer unidadesDisponiveis();

    public abstract void darEntrada(Integer quantidade);

    public abstract Boolean darSaida(Integer quantidade);

    public abstract void setIndisponivel();

    public abstract String getStringNomeLivro();

    public String getVariacao() {
        return variacao;
    }

    public void setVariacao(String variacao) {
        this.variacao = variacao;
    }
    
}
