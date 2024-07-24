#O(n log n)
#       ²
def quickSort(lista): 
    quick_sort_passo(lista, 0, len(lista)-1)

def quick_sort_passo(lista, primeiro, ultimo):
    if primeiro < ultimo:
        indice_particao = encontra_particao(lista, primeiro, ultimo)

        quick_sort_passo(lista, primeiro, indice_particao-1)
        quick_sort_passo(lista, indice_particao+1, ultimo)

def encontra_particao(lista, primeiro, ultimo):
    valor_pivo = lista[primeiro]
    indice_esquerdo = primeiro + 1
    indice_direito = ultimo

    terminou = False

    while not terminou:
        while indice_esquerdo <= indice_direito and lista[indice_esquerdo] <= valor_pivo:
            indice_esquerdo += 1

        while lista[indice_direito] >= valor_pivo and indice_direito >= indice_esquerdo:
            indice_direito -= 1

        if indice_esquerdo > indice_direito:
            terminou = True
        else:
            valor = lista[indice_esquerdo]
            lista[indice_esquerdo] = lista[indice_direito]
            lista[indice_direito] = valor
    
    valor = lista[primeiro]
    lista[primeiro] = lista[indice_direito]
    lista[indice_direito] = valor

    return indice_direito

L = [2, 10, 8, 7, 1, 5]
print(L)
quickSort(L)
print(L)