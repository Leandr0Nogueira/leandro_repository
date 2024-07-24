class Filme:
    def __init__(self, nome, ano_lancamento):
        self.nome = nome
        self.ano_lancamento = ano_lancamento

    def get_nome(self):
        return self.nome
    
    def get_ano_lancamento(self):
        return self.ano_lancamento