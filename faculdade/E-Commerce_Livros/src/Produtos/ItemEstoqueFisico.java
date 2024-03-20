package Produtos;

import Pessoas.Usuario;

public class ItemEstoqueFisico extends ItemEstoque{
    private Integer quantidade;

    public ItemEstoqueFisico(Livro livro, Usuario vendedor, Integer quantidade, Float preco) {
        this.setLivro(livro);
        this.setVendedor(vendedor);
        this.quantidade = quantidade;
        this.setPreco(preco);
        this.setVariacao(null);
    }

    @Override
    public Boolean verificarDisponibilidade(Integer quantidade) {
        if(quantidade <= this.quantidade){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Integer unidadesDisponiveis() {
        return quantidade;
    }

    @Override
    public Boolean darSaida(Integer quantidade) {
        if(verificarDisponibilidade(quantidade) == true){
            this.quantidade -= quantidade;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void darEntrada(Integer quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public void setIndisponivel() {
        this.quantidade = 0;
    }

    @Override
    public String getStringNomeLivro() {
        String variacao = "";
        if(getVariacao() != null){
            variacao = " (" + getVariacao() + ")";
        }
        return "Livro: " + getLivro().getNome() + variacao;
    }

}
