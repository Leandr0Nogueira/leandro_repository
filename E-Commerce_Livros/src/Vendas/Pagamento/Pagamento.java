package Vendas.Pagamento;

public abstract class Pagamento implements IPagamento{
    private Float valor;

    public Float getValor() {
        return valor;
    }
    
    public String stringValor(Float valor){
        return "R$ " + String.format("%.02f", valor);
    }

    protected void setValor(Float valor) {
        this.valor = valor;
    }

    public abstract String getInformacaoPagamento();

    public abstract void printDadosRealizarPagamento();
}
