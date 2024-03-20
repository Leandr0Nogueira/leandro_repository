package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Pessoas.Usuario;
import Pessoas.Usuario.TipoUsuario;

public class Login {
    // Lista itens
    private List<Usuario> usuarios;

    // Implementação singleton
    private static Login instance;

    private Login() {
        this.usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Admin", "00000000000", "admin", null, null, TipoUsuario.ADMINISTRADOR));
    }

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
        }
        return instance;
    }

    public Usuario procurarUsuario(String CPF) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCPF().equals(CPF)) {
                return usuario;
            }
        }
        return null;
    }

    public Boolean verificarLogin(String CPF, String senha) {
        Usuario usuario = procurarUsuario(CPF);
        if (usuario != null) {
            if (usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public Usuario cadastrarUsuario(Scanner scan) {
        Integer op = -1;
        TipoUsuario tipoUsuario = null;
        while (op < 0) {
            Menu.showTiposUsuarioCadastro();
            op = scan.nextInt();
            scan.nextLine();
            switch (op) {
                case 1:
                    tipoUsuario = TipoUsuario.CLIENTE;
                    break;
                case 2:
                    tipoUsuario = TipoUsuario.VENDEDOR;
                    break;
                default:
                    System.out.println("\nUSUÁRIO INVÁLIDO\nDigite Novamente:\n");
                    op = -1;
                    break;
            }
        }
        System.out.print("Digite o nome: ");
        String nome = scan.nextLine();
        System.out.print("Digite o CPF: ");
        String CPF = scan.nextLine();
        while(procurarUsuario(CPF) != null){
            System.out.println("\nERRO: USUÁRIO JÁ EXISTENTE!\n");
            return null;
        }
        System.out.print("Digite a senha: ");
        String senha = scan.nextLine();
        System.out.print("Digite o endereco: ");
        String endereco = scan.nextLine();
        System.out.print("Digite o email: ");
        String email = scan.nextLine();
        return new Usuario(nome, CPF, senha, endereco, email, tipoUsuario);
    }

    public Usuario realizarLogin(Scanner scan) {
        System.out.print("\nDigite o CPF: ");
        String CPF = scan.nextLine();
        Usuario usuario = procurarUsuario(CPF);
        Usuario logado = null;
        if (usuario == null) {
            System.out.println("\nUSUÁRIO NÃO ENCONTRADO\n");
            usuario = cadastrarUsuario(scan);
            if(usuario != null){
                usuarios.add(usuario);
                System.out.println("\nUsuário Cadastrado!\n");
                logado = usuario;
            }
        } else {
            System.out.print("Digite a Senha: ");
            String senha = scan.nextLine();
            System.out.println("");
            if (verificarLogin(CPF, senha) == true) {
                logado = usuario;
            } else {
                System.out.println("\nSENHA INVÁLIDA!\nDigite os dados novamente:\n");
            }
        }
        return logado;
    }
}
