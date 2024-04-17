def bubbleSort(lista):
    swap = True
    while swap == True:
        swap = False
        for i in range(1, len(lista)):
            if lista[i] < lista[i-1]:
                aux = lista[i]
                lista[i] = lista[i-1]
                lista[i-1] = aux
                swap = True

#main
L = [2, 1, 8, 7, 9, 5]
print(L)
bubbleSort(L)
print(L)