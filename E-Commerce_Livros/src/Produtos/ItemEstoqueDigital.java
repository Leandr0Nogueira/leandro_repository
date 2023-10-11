package Produtos;

import Pessoas.Usuario;

public class ItemEstoqueDigital extends ItemEstoque{
    private Boolean disponivel;

    public ItemEstoqueDigital(Livro livro, Usuario vendedor, Integer quantidade, Float preco) {
        this.setLivro(livro);
        this.setVendedor(vendedor);
        if(quantidade > 0){
            this.disponivel = true;
        } else{
            this.disponivel = false;
        }
        this.setPreco(preco);
        this.setVariacao("Ebook");
    }

    @Override
    public Boolean verificarDisponibilidade(Integer quantidade) {
        if(disponivel == true){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer unidadesDisponiveis() {
        return 1;
    }

    @Override
    public void darEntrada(Integer quantidade) {
        if(disponivel == false){
            disponivel = true;
        }
    }

    @Override
    public Boolean darSaida(Integer quantidade) {
        return true;
    }

    @Override
    public void setIndisponivel() {
        this.disponivel = false;
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
