class No:
    def __init__(self, valor):
        self.valor = valor
        self.direita = None
        self.esquerda = None

class ArvoreBinaria:
    def __init__(self, valor):
        self.raiz = No(valor)

    def insere_esquerda(self, tree_node, valor):
        new_node = No(valor)
        if tree_node.esquerda == None:
            tree_node.esquerda = new_node
        else:
            new_node.esquerda = tree_node.esquerda
            tree_node.esquerda = new_node

    def insere_direita(self, tree_node, valor):
        new_node = No(valor)
        if tree_node.direita == None:
            tree_node.direita = new_node
        else:
            new_node.direita = tree_node.direita
            tree_node.direita = new_node
        
    def filho_esquerda(self, tree_node):
        return tree_node.esquerda
    
    def filho_direita(self, tree_node):
        return tree_node.direita
    
    def percurso_preordem(self):
        print('---Percurso Pré-Ordem')
        self.preordem(self.raiz)
        print('---\n')

    def percurso_inordem(self):
        print('---Percurso In-Ordem')
        self.inordem(self.raiz)
        print('---\n')

    def percurso_posordem(self):
        print('---Percurso Pós-Ordem')
        self.posordem(self.raiz)
        print('---\n')

    def preordem(self, no_atual):
        if no_atual is not None:
            print(f'Visitou o nó: {no_atual.valor}')
            self.preordem(no_atual.esquerda)
            self.preordem(no_atual.direita)

    def inordem(self, no_atual):
        if no_atual is not None:
            self.inordem(no_atual.esquerda)
            print(f'Visitou o nó: {no_atual.valor}')
            self.inordem(no_atual.direita)

    def posordem(self, no_atual):
        if no_atual is not None:
            self.posordem(no_atual.esquerda)
            self.posordem(no_atual.direita)
            print(f'Visitou o nó: {no_atual.valor}')


#Main
arvore = ArvoreBinaria(10)
raiz = arvore.raiz

arvore.insere_direita(raiz, 5)
arvore.insere_direita(raiz, 20)
arvore.insere_direita(raiz, 99)
arvore.insere_esquerda(raiz, 12)
arvore.insere_esquerda(raiz, 18)
arvore.percurso_preordem()
arvore.percurso_inordem()
arvore.percurso_posordem()