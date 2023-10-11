package Vendas.Pagamento;

import java.util.Random;

public class PIX extends Pagamento{
    private String codigo;

    public PIX(Float valor) {
        this.setValor(valor);
        this.codigo = String.valueOf(Long.toHexString(new Random().nextLong()));
    }

    @Override
    public String getInformacaoPagamento() {
        return "PIX";
    }

    @Override
    public void printDadosRealizarPagamento() {
        System.out.println("Utilize o código abaixo para realizar o pagamento PIX:\n" + codigo);
    }
}
