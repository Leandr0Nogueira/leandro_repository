package Main;

import Pessoas.Usuario;
import Pessoas.Usuario.TipoUsuario;
import Produtos.Livro;
import Vendas.Carrinho;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("Narnia", "Leandro", "Ação", "Record", "Inglês");
        Livro livro1 = new Livro("1984", "George Orwell", "Ficção", "Record", "Português");

        Login login = Login.getInstance();

        Scanner scan = new Scanner(System.in);

        int op = 0;
        int opCli = 0;
        while (op < 1 || 3 < op) {
            Menu.showIniciar();
            Usuario usuario = login.realizarLogin(scan);

            if (usuario != null) {
                if (usuario.getTipoUsuario() == TipoUsuario.CLIENTE) { // Cliente
                    op = 0;
                    opCli = 0;
                    Carrinho carrinho = new Carrinho();
                    while (opCli < 1 || 4 < opCli) {
                        Menu.showCliente();
                        opCli = scan.nextInt();
                        scan.nextLine();
                        switch (opCli) {
                            case 1: // Ver catálogo
                                EstoqueController.exibirFuncoesParaCliente(scan, carrinho);
                                opCli = 0;
                                break;
                            case 2: // Ver o Carrinho
                                CarrinhoController.realizarAcoesCarrinho(scan, carrinho, usuario);
                                opCli = 0;
                                break;
                            case 3:
                                // Ver pedidos - Ainda não Implementado
                            case 4:
                                break;
                            default:
                                Menu.showOpcaoInvalida();
                                opCli = 0;
                                break;
                        }
                    }
                } else if (usuario.getTipoUsuario() == TipoUsuario.VENDEDOR) { // Vendedor
                    op = 0;
                    EstoqueController.addBook(usuario, livro, 5, 49);
                    EstoqueController.addBook(usuario, livro1, 3, 80);
                    while (op < 1 || 3 < op) {
                        Menu.showVendedor();
                        op = scan.nextInt();
                        scan.nextLine();
                        switch (op) {
                            case 1: // Adicionar Livro no Estoque
                                EstoqueController.adicionarLivroNoEstoque(scan, usuario);
                                op = 0;
                                break;
                            case 2: // Remover Livro do Estoque
                                EstoqueController.removerLivro(scan);
                                op = 0;
                                break;
                            case 3: // Logout
                                break;
                            default:
                                Menu.showOpcaoInvalida();
                                op = 0;
                                break;
                        }
                    }
                    op = 0;
                } else {
                    op = 0;
                }
            }
        }
        scan.close();
    }
}