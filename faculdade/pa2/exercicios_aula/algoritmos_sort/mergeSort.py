#Função mecanismo básico
def merge(l1, l2):
    i = 0
    j = 0
    lista = []
    while i < len(l1) and j < len(l2):
        if l1[i] < l2[j]:
            lista.append(l1[i])
            i += 1
        else:
            lista.append(l2[j])
            j += 1

    while i < len(l1):
        lista.append(l1[i])
        i += 1

    while i < len(l2):
        lista.append(l2[j])
        j += 1
    
    return lista

#O(n log n)           n * log base2  n
#       ²
def mergeSort(lista):
    if len(lista) > 1:
        meio = int(len(lista) / 2)
        E = lista[:meio]
        D = lista[meio:]

        mergeSort(E)
        mergeSort(D)
        print(lista)

        i, j, k = 0, 0, 0

        while i < len(E) and j < len(D):
            if E[i] < D[j]:
                lista[k] = E[i]
                i += 1
            else:
                lista[k] = D[j]
                j += 1
            k += 1

        while i < len(E):
            lista[k] = E[i]
            i += 1
            k += 1
        
        while j < len(D):
            lista[k] = D[j]
            j += 1
            k += 1

        print(f"{lista}\n")

#MAIN
L = [3, 43, 83, 34, 89, 95, 49, 7, 78, 30, 60]
print(L)
mergeSort(L)
print(L)