from filme import Filme
from genero import Genero
from plataforma import Plataforma
from gerenciador import Gerenciador

def menu():
    string = """                     __________________
    _________________| Menu de Filmes |_________________
                        
                    1- Listar filmes
                    2- Listar gêneros
                    3- Listar plataformas
                    4- Cadastrar gênero preferido
                    5- Recomendar filme
                    6- Cadastrar novo filme

                    0- Encerrar programa
    ____________________________________________________    
"""
    print (string)

i = 1
gerenciador = Gerenciador()
genero_preferido = []
generos = []

while i != '0':
    menu()
    i = input("Selecione uma opção: ")
    if i == '1':
        gerenciador.lista_filmes()
        
    elif i == '2':
        gerenciador.lista_generos()

    elif i == '3':
        gerenciador.lista_plataformas()

    elif i == '4':
        i_generos = int(input("Digite o número de gêneros preferidos: "))
        for i in range(i_generos):
            genero_preferido.append(input("Digite seu gênero preferido: "))


    elif i == '5':
        array_movie = gerenciador.array_filmes()
        if not genero_preferido:
            print("Gênero preferido não especificado")
        for movie in array_movie:
            for gender in genero_preferido:
                if gender in movie:
                    print(movie)
        

    elif i == '6':
        qntd_generos = int(input("Quantidade de gêneros que o filme está associado: "))
        for j in range(qntd_generos):
            genero_nome = input("Digite o gênero do filme: ")
            genero_id = input("Digite o id do gênero: ")
            genero = Genero(genero_id, genero_nome)
            generos.append(genero)

        plataforma_nome = input("Digite a plataforma do filme: ")
        plataforma_id = input("Digite o id da plataforma: ")
        plataforma = Plataforma(plataforma_id, plataforma_nome)

        titulo = input("Digite o nome do filme: ")
        filme_ano = input("Digite o ano de lançamento do filme: ")
        filme = Filme(titulo, filme_ano, generos, plataforma)

        gerenciador.set_new(filme)
        gerenciador.salva()

    elif i == '0':
        _ = ""

    else:
        print("Opção inválida")