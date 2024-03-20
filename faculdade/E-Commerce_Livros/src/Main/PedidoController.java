package Main;

import java.util.Scanner;

import Pessoas.Usuario;
import Vendas.Carrinho;
import Vendas.ItemProduto;
import Vendas.Pedido;
import Vendas.Pagamento.FactoryPagamento;
import Vendas.Pagamento.IPagamento;

public class PedidoController {
    public static void realizarCompra(Scanner scan, Usuario usuario, Carrinho carrinho) {
        Float desconto = (float) 0;
        Pedido pedido = new Pedido(carrinho.getProdutos(), usuario, usuario.getEndereco(), desconto,
                carrinho.getTotalPagar());
        for (ItemProduto produto : pedido.getProdutos()) {
            EstoqueController.darSaidaNoEstoque(produto.getLivro(), produto.getVendedor(), produto.getQuantidade());
        }
        pedido.printarPedido();
        pagarCompra(pedido, scan);
        pedido.printarPedido();
    }

    public static void pagarCompra(Pedido pedido, Scanner scan) {
        Integer op = 0;
        while (op < 1 || 4 < op) {
            Menu.showOpcoesPagamento();
            op = scan.nextInt();
            scan.nextLine();
            switch (op) {
                case 1: // PIX
                    IPagamento PIX = FactoryPagamento.criarPagamentoPIX(pedido.getValorTotal());
                    pedido.pagar(PIX);
                    PIX.printDadosRealizarPagamento();
                    break;
                case 2: // Cartão de Crédito
                    System.out.print("Digite o Número do Cartão: ");
                    String numeroCartao = scan.nextLine();
                    System.out.print("Digite o Vencimento do Cartão (MM/AA): ");
                    String vencimento = scan.nextLine();
                    System.out.print("Digite o CVV do Cartão: ");
                    String cvv = scan.nextLine();
                    System.out.print("Digite o Número de Parcelas: ");
                    Integer parcelas = scan.nextInt();
                    scan.nextLine();
                    IPagamento cartaoCredito = FactoryPagamento.criarPagamentoCartaoCredito(pedido.getValorTotal(), numeroCartao, vencimento,
                            cvv, parcelas);
                    pedido.pagar(cartaoCredito);
                    cartaoCredito.printDadosRealizarPagamento();
                    break;
                case 3: // Cartão de Débito
                    System.out.print("Digite o Número do Cartão: ");
                    numeroCartao = scan.nextLine();
                    System.out.print("Digite o Vencimento do Cartão (MM/AA): ");
                    vencimento = scan.nextLine();
                    System.out.print("Digite o CVV do Cartão: ");
                    cvv = scan.nextLine();
                    IPagamento cartaoDebito = FactoryPagamento.criarPagamentoCartaoDebito(pedido.getValorTotal(), numeroCartao, vencimento, cvv);
                    pedido.pagar(cartaoDebito);
                    cartaoDebito.printDadosRealizarPagamento();
                    break;
                case 4: // Voltar
                    break;
                default:
                    op = 0;
                    Menu.showOpcaoInvalida();
                    break;
            }
        }
    }
}
