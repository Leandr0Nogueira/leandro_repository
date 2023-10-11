package Produtos;

public class Livro {
    private String nome;
    private String autor;
    private String genero;
    private String editora;
    private String idioma;

    public Livro(String nome, String autor, String genero, String editora, String idioma) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.idioma = idioma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String imprimirInformacoes() {
        return "Livro: " + nome + 
             "\nAutor: " + autor + 
             "\nGênero: " + genero + 
             "\nEditora: " + editora + 
             "\nIdioma: " + idioma + "\n";
    }

    @Override
    public String toString() {
        return "Livro: " + nome + " | Autor: " + autor + " | Genero: " + genero + " | Editora: "
                + editora + " | Idioma: " + idioma;
    }
    
}
