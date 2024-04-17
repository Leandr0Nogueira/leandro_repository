def encontrar_valor(lista, num):  
    for i in range(len(lista)):  #Função de complexidade O(1) ou O(n), dependendo de onde o número
        if lista[i] == num:      #em que estamos buscando está localizado na lista, caso esteja no
            return True          #primeiro elemento, será O(1), caso esteja no último, O(n).
        
    return False
