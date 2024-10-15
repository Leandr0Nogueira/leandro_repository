class Stack:
    def __init__(self):
        self.items = []

    #verifica se está vazia
    def is_empty(self):
        return len(self.items) == 0
    
    #empilha
    def push(self, element):
        self.items.append(element)

    #desempilha
    def pop(self):
        return self.items.pop()
    
    def peek(self):
        n = len(self.items)
        return self.items[n-1]
    
    def size(self):
        return len(self.items)