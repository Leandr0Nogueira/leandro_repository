package Vendas.Pagamento;

public class CartaoDebito extends Pagamento{
    private String numeroCartao;
    private String vencimento;
    private String cvv;

    public CartaoDebito(Float valor, String numeroCartao, String vencimento, String cvv) {
        this.setValor(valor);
        this.numeroCartao = numeroCartao;
        this.vencimento = vencimento;
        this.cvv = cvv;
    }

    protected String getNumeroCartao() {
        return numeroCartao;
    }

    protected String getVencimento() {
        return vencimento;
    }

    protected String getCvv() {
        return cvv;
    }

    @Override
    public String getInformacaoPagamento() {
        return "Cartao de Debito Final " + numeroCartao.substring(numeroCartao.length() - 4, numeroCartao.length());
    }

    @Override
    public void printDadosRealizarPagamento() {
        System.out.println("Foi realizada a cobranca em seu " + getInformacaoPagamento());
    }
    
}
