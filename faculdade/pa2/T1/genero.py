class Genero:
    def __init__(self, id, nome):
        self.id = id
        self.nome = nome
    
        string = str(f"{self.nome}\n")
        arquivo = open('T1/genero.txt', 'a')
        arquivo.write(string)
        arquivo.close

    def get_nome(self):
        return self.nome
    
    def get_identificador(self):
        return self.identificador

    def __str__(self):
        return self.nome