package Main;

import java.util.List;
import java.util.Scanner;

import Pessoas.Usuario;
import Produtos.Estoque;
import Produtos.FactoryItemEstoque;
import Produtos.ItemEstoque;
import Produtos.Livro;
import Vendas.Carrinho;

public class EstoqueController {
    private static Estoque estoque = Estoque.getInstance();

    public static void exibirFuncoesParaCliente(Scanner scan, Carrinho carrinho) {
        System.out.println("\nCATÁLOGO:");
        estoque.printarLivros();
        System.out.println("");
        Integer opCli = 0;
        while (opCli < 1 || 2 < opCli) {
            Menu.showOpcoesCatalogo();
            opCli = scan.nextInt();
            scan.nextLine();
            switch (opCli) {
                case 1: // Detalhes do Livro
                    System.out.print("Digite o Indice do Livro: ");
                    Integer indice = scan.nextInt() - 1;
                    scan.nextLine();
                    Livro livro = estoque.getLivros().get(indice);
                    System.out.println(livro.imprimirInformacoes());
                    estoque.imprimirOfestasDoLivro(livro);
                    System.out.println("");
                    opCli = 0;
                    while (opCli < 1 || 2 < opCli) {
                        Menu.showOpcoesDetalhesLivro();
                        opCli = scan.nextInt();
                        scan.nextLine();
                        switch (opCli) {
                            case 1: // Adicionar no Carrinho
                                CarrinhoController.adicionarItemNoCarrinho(scan, carrinho, livro);
                                opCli = 2;
                                break;
                            case 2: // Voltar
                                break;
                            default:
                                opCli = 0;
                                Menu.showOpcaoInvalida();
                                break;
                        }
                    }
                case 2: // Voltar
                    break;
                default:
                    opCli = 0;
                    Menu.showOpcaoInvalida();
                    break;
            }
        }
    }

    public static void mostrarLivrosParaVendedor(List<Livro> listaDeLivros) {
        System.out.println("\nLista de Livros Atuais: ");
        estoque.printarLivros();
        System.out.println("");
    }

    public static void adicionarLivroNoEstoque(Scanner scan, Usuario usuario) {
        List<Livro> listaDeLivros = estoque.getLivros();
        Livro livro = null;
        Integer op = 0;
        while (op < 1 || 3 < op) {
            if (listaDeLivros.size() > 0) {
                mostrarLivrosParaVendedor(listaDeLivros);
                Menu.showOpcoesAdicionarLivro();
                op = scan.nextInt();
                scan.nextLine();
            } else {
                op = 2;
            }
            switch (op) {
                case 1: // Livro Já existente
                    System.out.print("Digite o Indice do Livro: ");
                    int indiceLivro = scan.nextInt() - 1;
                    scan.nextLine();
                    System.out.println("");
                    livro = listaDeLivros.get(indiceLivro);
                    op = 1;
                    break;
                case 2: // Livro Novo
                    System.out.println("\nADICIONAR NOVO LIVRO:");
                    System.out.print("Digite o Nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Digite o Autor: ");
                    String autor = scan.nextLine();
                    System.out.print("Digite o Gênero: ");
                    String genero = scan.nextLine();
                    System.out.print("Digite a Editora: ");
                    String editora = scan.nextLine();
                    System.out.print("Digite o Idioma: ");
                    String idioma = scan.nextLine();
                    System.out.println("");
                    livro = new Livro(nome, autor, genero, editora, idioma);
                    op = 1;
                    break;
                case 3: // Voltar
                    break;
                default:
                    Menu.showOpcaoInvalida();
                    op = 0;
                    break;
            }
        }
        if (livro != null) {
            while (op < 1 || 3 > op) {
                Menu.showOpcoesTipoLivro();
                op = scan.nextInt();
                scan.nextLine();
                ItemEstoque item;
                switch (op) {
                    case 1: // Adiciona Livro Físico
                        System.out.print("Digite o Quantidade do Livro: ");
                        Integer quantidade = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Digite o Preço do Livro: ");
                        Float preco = scan.nextFloat();
                        scan.nextLine();
                        System.out.println("");
                        item = FactoryItemEstoque.criarItemEstoqueFisico(livro, usuario, quantidade, preco);
                        estoque.adicionarLivro(item);
                        op = 3;
                        break;
                    case 2: // Adiciona Ebook
                        quantidade = 1;
                        System.out.print("Digite o Preço do Livro: ");
                        preco = scan.nextFloat();
                        scan.nextLine();
                        System.out.println("");
                        item = FactoryItemEstoque.criarItemEstoqueDigital(livro, usuario, quantidade, preco);
                        estoque.adicionarLivro(item);
                        op = 3;
                        break;
                    case 3: // Cancelar
                        break;
                    default:
                        op = 0;
                        Menu.showOpcaoInvalida();
                        break;
                }
            }
        }
    }

    public static void removerLivro(Scanner scan) {
        List<Livro> listaDeLivros = estoque.getLivros();
        Livro livro = null;
        System.out.print("Digite o Indice do Livro: ");
        int indiceLivro = scan.nextInt() - 1;
        scan.nextLine();
        System.out.println("");
        if(listaDeLivros.get(indiceLivro) == null) {
            System.out.println("Sem livros com esse índice");
        }
        else {
            livro = listaDeLivros.get(indiceLivro);
            listaDeLivros.remove(livro);
            System.out.println("Livro removido!");
        }
    }

    public static void darSaidaNoEstoque(Livro livro, Usuario vendedor, Integer quantidade){
        ItemEstoque itemEstoque = estoque.getItem(livro, vendedor);
        estoque.reduzirQuantidade(itemEstoque, quantidade);
    }

    public static Boolean verificarDisponibilidade(Livro livro, Usuario vendedor, Integer quantidade){
        ItemEstoque itemEstoque = estoque.getItem(livro, vendedor);
        return itemEstoque.verificarDisponibilidade(quantidade);
    }

    public static ItemEstoque getItemEstoqueDeOferta(Livro livro, Integer indice){
        return estoque.getOfertasDoLivro(livro).get(indice);
    }

    public static void addBook(Usuario usuario, Livro livro, Integer quantidade, float preco) {
       ItemEstoque item = FactoryItemEstoque.criarItemEstoqueFisico(livro, usuario, quantidade, preco);
       estoque.adicionarLivro(item);
    }
}
