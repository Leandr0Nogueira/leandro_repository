def selectionSort(lista):
    n = len(lista)
    for i in range(0, n-1):
        ind_min = i
        for j in range(i+1, n):
            if lista[j] < lista[ind_min]:
                ind_min = j
    
        aux = lista[ind_min]
        lista[ind_min] = lista[i]
        lista[i] = aux

#main
L = [2, 1, 8, 7, 9, 5]
print(L)
selectionSort(L)
print(L)