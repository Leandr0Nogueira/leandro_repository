def insertionSort(lista):
    n = len(lista)
    ind_min = 0
    for i in range(1, n):
        j = i
        while j > 0 and lista[j-1] > lista[j]:
            val = lista[j]
            lista[j] = lista[j-1]
            lista[j-1] = val
            j -= 1
        
        print(lista)

#main
L = [2, 10, 8, 7, 1, 5]
print(L)
insertionSort(L)
print(L)