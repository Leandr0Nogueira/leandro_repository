package br.com.leandro.screenmatch.domain.filme;

import jakarta.persistence.*;

@Entity
@Table(name="filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer duracao;
    private Integer ano;
    private String genero;

    public Filme(){

    }

    public Filme(DadosFilme dados){
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.genero = dados.genero();
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracao=" + duracao +
                ", ano=" + ano +
                ", genero='" + genero + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Integer getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public Long getId() {
        return id;
    }

    public void atualizaDados(DadosAlteraFilme dados) {
        this.nome = dados.nome();
        this.duracao = dados.duracao();
        this.ano = dados.ano();
        this.genero = dados.genero();
    }
}
