package Main;

public class Menu {
    public static void showIniciar(){
        String msg = "--LIVRARIA-------------------------------------------------\n"
                    +"Bem Vindo(a)!                                             |\n"
                    +"                                                          |\n"
                    +"Realize o Login ou Cadastro:                              |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showTiposUsuarioCadastro() {
        String msg = "--CADASTRAR-USUÁRIO----------------------------------------\n"
                    +"Deseja se cadastrar como:                                 |\n"
                    +"1- Cliente                                                |\n"
                    +"2- Vendedor                                               |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showAdmCadastrarUsuario() {
        String msg = "--MENU-----------------------------------------------------\n"
                    +"Deseja cadastrar qual usuário: ?                          |\n"
                    +"1- Administrador                                          |\n"
                    +"2- Cliente                                                |\n"
                    +"3- Vendedor                                               |\n"
                    +"4- Suporte                                                |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showVendedor() {
        String msg = "--VENDEDOR-------------------------------------------------\n"
                    +"Selecione o que deseja fazer:                             |\n"
                    +"1- Colocar livro à venda                                  |\n"
                    +"2- Retirar produto à venda                                |\n"
                    +"3- Logout                                                 |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showOpcoesAdicionarLivro() {
        String msg = "--ADICIONAR-LIVRO------------------------------------------\n"
                    +"Deseja adicionar um livro:                                |\n"
                    +"1- Existente                                              |\n"
                    +"2- Livro Novo                                             |\n"
                    +"3- Cancelar                                               |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showOpcoesTipoLivro() {
        String msg = "--ADICIONAR-LIVRO------------------------------------------\n"
                    +"Deseja adicionar um livro do tipo:                        |\n"
                    +"1- Livro Físico                                           |\n"
                    +"2- E-book                                                 |\n"
                    +"3- Cancelar                                               |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showCliente() {
        String msg = "--CLIENTE--------------------------------------------------\n"
                    +"Selecione o que deseja fazer:                             |\n"
                    +"1- Ver o Catálogo de Livros                               |\n"
                    +"2- Ver o Carrinho                                         |\n"
                    +"3- Ver Pedidos                                            |\n"
                    +"4- Logout                                                 |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showOpcoesCatalogo() {
        String msg = "--CATÁLOGO-------------------------------------------------\n"
                    +"Selecione o que deseja fazer:                             |\n"
                    +"1- Ver Detalhes de um Livro                               |\n"
                    +"2- Voltar                                                 |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showOpcoesDetalhesLivro() {
        String msg = "--LIVRO----------------------------------------------------\n"
                    +"Selecione o que deseja fazer:                             |\n"
                    +"1- Adicionar ao Carrinho                                  |\n"
                    +"2- Voltar                                                 |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showOpcoesCarrinho() {
        String msg = "--CARRINHO-------------------------------------------------\n"
                    +"Selecione o que deseja fazer:                             |\n"
                    +"1- Comprar                                                |\n"
                    +"2- Editar a Quantidade                                    |\n"
                    +"3- Remover Item                                           |\n"
                    +"4- Voltar                                                 |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showOpcoesPagamento() {
        String msg = "--PAGAMENTO------------------------------------------------\n"
                    +"Selecione a forma de pagamento:                           |\n"
                    +"1- PIX                                                    |\n"
                    +"2- Cartão de Crédito                                      |\n"
                    +"3- Cartão de Débito                                       |\n"
                    +"4- Voltar                                                 |\n"
                    +"-----------------------------------------------------------";

        System.out.println(msg);
    }

    public static void showOpcaoInvalida(){
        System.out.println("\nOPÇÃO INVÁLIDA\n");
    }

}
