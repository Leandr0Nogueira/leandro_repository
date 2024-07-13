class Pessoa:
    def __init__(self, pNome, pSobrenome):
        self.nome = pNome
        self.sobrenome = pSobrenome

    def nome_completo(self):
        return f"{self.nome} {self.sobrenome}"
    
#main
#p1 = Pessoa("Leandro", "Nogueira")
#p2 = Pessoa("Gustavo", "Baldini")

#pessoas = [p1, p2]
#for pessoa in pessoas:
    #print(pessoa.nome_completo())