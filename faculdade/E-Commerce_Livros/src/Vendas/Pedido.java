package Vendas;

import java.util.Date;
import java.util.List;

import Pessoas.Usuario;
import Vendas.Pagamento.IPagamento;

public class Pedido {
    private List<ItemProduto> produtos;
    private Usuario cliente;
    private Date data;
    private String endereco;
    private Boolean ativo;
    private Boolean pago;
    private Boolean enviado;
    private Boolean finalizado;
    private Float subtotal;
    private Float desconto;
    private Float valorTotal;
    private IPagamento pagamento;

    public Pedido(List<ItemProduto> produtos, Usuario cliente, String endereco, Float desconto, Float valorTotalCarrinho) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.endereco = endereco;
        this.subtotal = valorTotalCarrinho;
        this.desconto = desconto;
        this.data = new Date();
        this.ativo = true;
        this.pago = false;
        this.enviado = false;
        this.finalizado = false;
        this.valorTotal = valorTotalCarrinho - desconto;
        this.pagamento = null;
    }

    public List<ItemProduto> getProdutos() {
        return produtos;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public Date getData() {
        return data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Float getDesconto() {
        return desconto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        if(ativo == false){
            return "Pedido Cancelado";
        } else if(pago == false){
            return "Aguardando Pagamento";
        } else if(enviado == false){
            return "O vendedor está preparando seu pedido";
        } else if(finalizado == false){
            return "O seu pedido foi enviado, aguarde";
        } else {
            return "Pedido Concluído";
        }
    }

    public Boolean cancelarPedido(){
        if(enviado == false){
            ativo = false;
            return true;
        } else {
            return false;
        }
    }

    public void pagar(IPagamento pagamento){
        this.pagamento = pagamento;
        this.pago = true;
    }
    
    public String stringPreco(Float valor){
        return "R$ " + String.format("%.02f", valor);
    }

    public void printarPedido(){
        System.out.println("");
        System.out.println("PEDIDO:" + 
            "\nData: " + data +
            "\nStatus: " + getStatus() + 
            "\nCliente: " + cliente.getNome() + 
            "\nEndereço: " + endereco + 
            "\n\nProdutos:");
        for (ItemProduto item : produtos) {

            System.out.println(item.toString());

        }
        System.out.println("\nSubtotal: " + stringPreco(subtotal) + 
                            "\nDesconto: " + stringPreco(desconto) + 
                            "\nTotal: " + stringPreco(valorTotal));
        if(pagamento != null){
            System.out.println("\nPago com: " + pagamento.getInformacaoPagamento());
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Pedido: Data: " + data + ", Cliente:" + cliente.getNome() + ", Valor=" + valorTotal;
    }
  
}