#Complexidade O(n) - ele no pior caso examina todos os n elementos da lista
def busca_linear(lista, n):
    for i in range(len(lista)):
        if lista[i] == n:
            return i
        
    return -1

#Complexidade O(log2(n))
#Supondo que a lista já esteja ordenada
def busca_binaria(lista, i_inicial, i_final, valor):
    if i_final >= i_inicial:
        meio = int((i_inicial + i_final)/2)
        if lista[meio] == valor:
            return meio
        elif lista[meio] > valor:
            return busca_binaria(lista, i_inicial, meio-1, valor)
        else:
            return busca_binaria(lista, meio+1, i_final, valor)
    else:
        return -1