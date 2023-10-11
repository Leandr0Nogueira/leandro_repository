package Pessoas;

public class Usuario {
    public enum TipoUsuario{
        ADMINISTRADOR,
        VENDEDOR,
        CLIENTE,
        SUPORTE;
    }

    private String nome;
    private String CPF;
    private String senha;
    private String endereco;
    private String email;
    private TipoUsuario tipoUsuario;

    public Usuario(String nome, String CPF, String senha, String endereco, String email, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
        this.endereco = endereco;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void consultar() {
        System.out.println(getCPF() + "\n" +
                           getEmail() + "\n" +
                           getEndereco() + "\n" +
                           getNome() + "\n" +
                           getSenha());
    }
    
}
