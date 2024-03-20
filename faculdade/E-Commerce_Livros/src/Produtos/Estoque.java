package Produtos;

import java.util.ArrayList;
import java.util.List;

import Pessoas.Usuario;

public class Estoque{
    // Lista itens
    private List<ItemEstoque> produtos;

    // Implementação singleton
    private static Estoque instance;

    private Estoque() {
        this.produtos = new ArrayList<>();
    }

    public static Estoque getInstance() {
        if (instance == null) {
            instance = new Estoque();
        }
        return instance;
    }

    // Demais métodos
    public void printarLivros() {
        List<Livro> livros = getLivros();
        if (livros.isEmpty()) {
            System.out.println("\nSem livros no catálogo\n");
        } else {
            Integer indice = 0;
            for (Livro livro : livros) {
                System.out.println(++indice + " | " + livro.toString());
            }
        }
    }

    public void adicionarLivro(ItemEstoque produto) {
        produtos.add(produto);
    }

    public void removerLivro(ItemEstoque produto) {
        produtos.remove(produto);
    }

    public void reduzirQuantidade(ItemEstoque produto, Integer quant_para_reduzir) {
        ItemEstoque item = produtos.get(produtos.indexOf(produto));
        if(item.verificarDisponibilidade(quant_para_reduzir) == true){
            item.darSaida(quant_para_reduzir);
        } else {
            System.out.println("\nNão há Produtos Suficientes\n");
        }
        
    }

    public List<ItemEstoque> getProdutos() {
        return produtos;
    }

    public List<Livro> getLivros(){
        List<Livro> livros = new ArrayList<>();
        for (ItemEstoque itemEstoque : produtos) {
            if(livros.contains(itemEstoque.getLivro()) == false){
                livros.add(itemEstoque.getLivro());
            }
        }
        return livros;
    }

    public ItemEstoque getItem(Integer indice){
        return this.produtos.get(indice);
    }

    public ItemEstoque getItem(Livro livro, Usuario vendedor){
        for (ItemEstoque itemEstoque : produtos) {
            if(itemEstoque.getVendedor() == vendedor){
                return itemEstoque;
            }
        }
        return null;
    }

    public List<ItemEstoque> getOfertasDoLivro(Livro livro){
        List<ItemEstoque> ofertas = new ArrayList<>();
        for (ItemEstoque itemEstoque : produtos) {
            if(itemEstoque.getLivro() == livro){
                ofertas.add(itemEstoque);
            }
        }
        return ofertas;
    }

    public void imprimirOfestasDoLivro(Livro livro){
        List<ItemEstoque> ofertas = getOfertasDoLivro(livro);
        System.out.println("\nOfertas:");
        Integer indice = 0;
        for (ItemEstoque itemEstoque : ofertas) {
            System.out.println(++indice + " | Vendedor: " + itemEstoque.getVendedor().getNome() + " | " + itemEstoque.stringPreco() + " | Quantidade: " + itemEstoque.unidadesDisponiveis());
        }
    }

    // public void printarLivros() {
    //     if (produtos.isEmpty()) {
    //         System.out.println("\nSem livros no catálogo\n");
    //     } else {
    //         Integer indice = 0;
    //         for (ItemEstoque item : produtos) {
    //             Livro livro = item.getLivro();
    //             String disponibilidade;

    //             if (item.unidadesDisponiveis() > 0) {
    //                 disponibilidade = "Quantidade: " + item.unidadesDisponiveis();

    //             } else{
    //                 disponibilidade = "Indisponível";
    //             }

    //             System.out.println(++indice + " | Livro: " + livro.getNome() + " | " + item.stringPreco() + " | " + disponibilidade);
    //         }
    //     }
    // }
}
