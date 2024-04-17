import random

def gerar_lista_ordenada_crescente(N):
    l = []
    for i in range(N):
        l.append(i+1)
    
    return l

def gerar_lista_ordenada_decrescente(N):
    l = []
    for i in range(N):
        l.append(N-i)
    
    return l

def gerar_lista_aleatoria(N):
    l = []
    for i in range(N):
        n_aleatorio = random.randint(0, 100_000)
        l.append(n_aleatorio)

    return l

l1 = gerar_lista_aleatoria(10)
l2 = gerar_lista_ordenada_crescente(10)
l3 = gerar_lista_ordenada_decrescente(10)
print(l1)
print(l2)
print(l3)