class Filme:
    def __init__(self, titulo, ano_lancamento, genero, plataforma):
        self.titulo = titulo
        self.genero = genero
        self.plataforma = plataforma
        self.ano_lancamento = ano_lancamento

    def __str__(self):
        generos_str = ', '.join(str(genero) for genero in self.genero)
        return f"Filme: {self.titulo} | Ano: {self.ano_lancamento} | Genero: {generos_str} | Plataforma: {self.plataforma}\n"