package Vendas.Pagamento;

public class CartaoCredito extends Pagamento{
    private String numeroCartao;
    private String vencimento;
    private String cvv;
    private Integer parcelas;

    public CartaoCredito(Float valor, String numeroCartao, String vencimento, String cvv, Integer parcelas) {
        this.setValor(valor);
        this.numeroCartao = numeroCartao;
        this.vencimento = vencimento;
        this.cvv = cvv;
        this.parcelas = parcelas;
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

    public Integer getParcelas() {
        return parcelas;
    }

    @Override
    public String getInformacaoPagamento() {
        return "Cartao de Credito Final " + numeroCartao.substring(numeroCartao.length() - 4, numeroCartao.length()) + " em " + parcelas + "x";
    }

    @Override
    public void printDadosRealizarPagamento() {
        System.out.println("Foi realizada a cobranca em seu " + getInformacaoPagamento());
    }

    
}
