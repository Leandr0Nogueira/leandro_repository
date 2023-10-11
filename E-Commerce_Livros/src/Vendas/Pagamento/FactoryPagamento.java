package Vendas.Pagamento;

public class FactoryPagamento {

    public static Pagamento criarPagamentoPIX(Float valor){
        return new PIX(valor);
    }

    public static Pagamento criarPagamentoCartaoCredito(Float valor, String numeroCartao, String vencimento, String cvv, Integer parcelas){
        return new CartaoCredito(valor, numeroCartao, vencimento, cvv, parcelas);
    }

    public static Pagamento criarPagamentoCartaoDebito(Float valor, String numeroCartao, String vencimento, String cvv){
        return new CartaoDebito(valor, numeroCartao, vencimento, cvv);
    }
}
