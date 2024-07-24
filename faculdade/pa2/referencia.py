def ordena_listas(l1, l2):
    l_ordenada = []
    i = 0
    j = 0
    while i < len(l1) and j < len(l2):
        if l1[i] < l2[j]:
            l_ordenada.append(l1[i])
            i += 1
        else:
            l_ordenada.append(l2[j])
            j += 1

    while i < len(l1):
        l_ordenada.append(l1[i])
        i += 1

    while j < len(l2):
        l_ordenada.append(l2[j])
        j += 1
    
    return l_ordenada
    


l1 = [1, 4, 7, 9, 12, 23, 42]
l2 = [5, 6, 8, 27, 52, 60, 78, 99]

print(ordena_listas(l1, l2))

