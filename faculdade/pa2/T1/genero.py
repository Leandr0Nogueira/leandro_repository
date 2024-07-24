from filme import Filme

class Genero:
    def __init__(self, nome, identificador, arquivo='filmes.txt'):
        self.nome = nome
        self.identificador = identificador
        self.arquivo = arquivo

    def adicionar_filme(self, Filme):
        with open(self.arquivo, 'a') as f:
            f.write(f'{Filme}')

    def get_nome(self):
        return self.nome
    
    def get_identificador(self):
        return self.identificador