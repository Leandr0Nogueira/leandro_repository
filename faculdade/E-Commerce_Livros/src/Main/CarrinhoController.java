package Main;

import java.util.Scanner;

import Pessoas.Usuario;
import Produtos.ItemEstoque;
import Produtos.Livro;
import Vendas.Carrinho;
import Vendas.ItemProduto;

public class CarrinhoController {

    public static void adicionarItemNoCarrinho(Scanner scan, Carrinho carrinho, Livro livro) {
        System.out.print("Digite o Indice da Oferta: ");
        Integer indice = scan.nextInt() - 1;
        scan.nextLine();
        System.out.print("Digite a Quantidade do Livro: ");
        Integer quantidade = scan.nextInt();
        scan.nextLine();
        ItemEstoque itemEstoque = EstoqueController.getItemEstoqueDeOferta(livro, indice);
        if (EstoqueController.verificarDisponibilidade(livro, itemEstoque.getVendedor(), quantidade) == true) {
            ItemProduto itemProduto = new ItemProduto(livro, itemEstoque.getVariacao(), itemEstoque.getVendedor(),
                    quantidade, itemEstoque.getPreco());
            carrinho.adicionar(itemProduto);
            System.out.println("\nItem Adicionado com Sucesso\n");
            carrinho.printarCarrinho();
        } else {
            System.out.println("\nErro\nNão há itens suficientes para Adição\n");
        }
    }

    public static void realizarAcoesCarrinho(Scanner scan, Carrinho carrinho, Usuario usuario) {
        System.out.println("");
        carrinho.printarCarrinho();
        Integer opCli = 0;
        while (opCli < 1 || 4 < opCli) {
            Menu.showOpcoesCarrinho();
            opCli = scan.nextInt();
            scan.nextLine();
            switch (opCli) {
                case 1: // Comprar


                    PedidoController.realizarCompra(scan, usuario, carrinho);
                    // tem que colocar o restante das funções
                    break;
                case 2: // Editar a Quantidade
                    System.out.print("Digite o Indice do Livro: ");
                    Integer indice = scan.nextInt() - 1;
                    scan.nextLine();
                    System.out.print("Digite a Nova Quantidade: ");
                    Integer quantidade = scan.nextInt();
                    scan.nextLine();
                    ItemProduto itemProduto = carrinho.getProdutos().get(indice);
                    if (EstoqueController.verificarDisponibilidade(itemProduto.getLivro(), itemProduto.getVendedor(), quantidade) == true) {
                        carrinho.alterarQuantidade(itemProduto, quantidade);
                        carrinho.printarCarrinho();
                    } else {
                        System.out.println("\nErro\nNão há itens suficientes\n");
                    }
                    opCli = 0;
                    break;
                case 3: // Remover Item
                    System.out.print("Digite o Indice do item que deseja remover: ");
                    indice = scan.nextInt() - 1;
                    scan.nextLine();
                    carrinho.remover(carrinho.getProdutos().get(indice));
                    System.out.println("\nItem removido com Sucesso!\n");
                    carrinho.printarCarrinho();
                    opCli = 0;
                    break;
                case 4: // Voltar
                    break;
                default:
                    opCli = 0;
                    Menu.showOpcaoInvalida();
                    break;
            }
        }
    }

}
