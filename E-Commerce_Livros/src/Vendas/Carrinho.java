package Vendas;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private float totalPagar;
    private List<ItemProduto> produtos;

    public Carrinho() {
        this.totalPagar = 0;
        this.produtos = new ArrayList<>();
    }

    public void adicionar(ItemProduto produto) {
        produtos.add(produto);
        totalPagar += produto.getSubtotal();
    }

    public void remover(ItemProduto produto) {
        produtos.remove(produto);
        totalPagar -= produto.getSubtotal();
        atualizarValorTotal();
    }

    public void alterarQuantidade(ItemProduto produto, Integer quantidade){
        Integer index = produtos.indexOf(produto);
        ItemProduto item = produtos.get(index);
        item.setQuantidade(quantidade);
        produtos.set(index, item);
        atualizarValorTotal();

    }

    private void atualizarValorTotal(){
        totalPagar = 0;
        for (ItemProduto itemProduto : produtos) {
            totalPagar += itemProduto.getSubtotal();
        }
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public String stringPreco(){
        return "R$ " + String.format("%.02f", totalPagar);
    }

    public void printarCarrinho() {
        Integer indice = 0;
        System.out.println("\nCARRINHO:");
        for (ItemProduto item : produtos) {

            if(produtos.isEmpty()){
                System.out.println("\nSem livros no carrinho\n");
            }
            else {
                System.out.println(++indice + " | " + item.toString());
            }
            
        }
        System.out.println("\nValor Total: " + stringPreco() + "\n");
    }

    public List<ItemProduto> getProdutos() {
        return produtos;
    }
}
