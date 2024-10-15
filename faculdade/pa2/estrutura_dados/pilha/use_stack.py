from stack import Stack

pilha = Stack()

pilha.push("elem 1")
pilha.push("elem 2")
pilha.push("elem 3")
pilha.push("elem 4")
pilha.push("elem 5")

while not pilha.is_empty():
    print(pilha.pop())