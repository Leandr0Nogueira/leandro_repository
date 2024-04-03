def valor_unico(vet):
    repetido = False
    numero = 0
    for i in range(len(vet)):
        repetido = False
        for j in range(len(vet)):
            if vet[i] == vet[j] and i != j:
                repetido = True
        if repetido == False:
            numero = vet[i]
    return numero

def outro_jeito(vetor):
    contagem = {}
    for numero in vetor:
        if numero in contagem:
            contagem[numero] += 1
        else:
            contagem[numero] = 1

    for n in contagem:
        if contagem[n] == 1:
            return n

vetor = [1, 2, 3, 4, 1, 1, 2, 4]
print(f"saída: {valor_unico(vetor)}")

print(f"saída: {outro_jeito(vetor)}")
