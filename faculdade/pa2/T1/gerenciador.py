class Gerenciador:
    def __init__(self, filme=''):
        self.filme = filme

    def set_new(self, filme):
        self.filme = filme

    def salva(self):
        string = str(self.filme)
        arquivo = open('T1/filme.txt', 'a')
        arquivo.write(string)
        arquivo.close

    def lista_filmes(self):
        arquivo = open('T1/filme.txt', 'r')
        texto = arquivo.read()
        arquivo.close()
        filmes = texto.splitlines()
        for filme in filmes:
            print(filme)

    def array_filmes(self):
        arquivo = open('T1/filme.txt', 'r')
        texto = arquivo.read()
        arquivo.close()
        filmes = texto.splitlines()
        return filmes
    
    def lista_generos(self):
        arquivo = open('T1/genero.txt', 'r')
        texto = arquivo.read()
        arquivo.close()
        generos =  set(texto.splitlines())
        for genero in generos:
            print(genero)
    
    def lista_plataformas(self):
        arquivo = open('T1/plataforma.txt', 'r')
        texto = arquivo.read()
        arquivo.close()
        plataformas = set(texto.splitlines())
        for plataforma in plataformas:
            print(plataforma)


#for string in teste:
    #if 'Terror' in string:
        #print(string)



