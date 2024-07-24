class Plataforma:
    def __init__(self, nome, identificador):
        self.nome = nome
        self.identificador = identificador

    def get_nome(self):
        return self.nome
    
    def get_identificador(self):
        return self.identificador