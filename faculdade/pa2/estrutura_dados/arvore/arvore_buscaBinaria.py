class No:
    def __init__(self, chave, valor, esquerdo=None, direito=None, pai=None):
        self.chave = chave
        self.valor = valor
        self.direito = esquerdo
        self.esquerdo = direito
        self.pai = pai

class ArvoreBinaria:
    def __init__(self):
        self.raiz = None

    def insert(self, chave, valor):
        if self.raiz is None:
            self.raiz = No(chave, valor)
        else:
            self._insert(chave, valor, self.raiz)

    def _insert(self, chave, valor, no_atual):
        if no_atual.chave > chave:
            if no_atual.esquerdo is None:
                no_atual.esquerdo = No(chave, valor, pai=no_atual)
            else:
                self._insert(chave, valor, no_atual.esquerdo)
        else:
            if no_atual.direito is None:
                no_atual.direito = No(chave, valor, pai=no_atual)
            else:
                self._insert(chave, valor, no_atual.direito)

    def imprime(self):
        '''Imprime os valores da árvore'''
        self._imprime(self.raiz, 0, '')

    def _imprime(self, no_atual, nivel, lado):
        if no_atual is not None:
            print('  '*nivel+'{}{}|{}'.format(lado, no_atual.chave, no_atual.valor))
            self._imprime(no_atual.esquerdo, nivel+1, '/')
            self._imprime(no_atual.direito, nivel+1, '\\')

    def search(self, chave):
        '''Busca um valor na árvore'''
        if self.raiz is None:
            return None
        else:
            no = self._search(chave, self.raiz)
            if no is None:
                return None
            else:
                return no.valor

    def search_2(self, chave):
        '''Busca um valor na árvore'''
        if self.raiz is None:
            return None
        else:
            return self._search(chave, self.raiz)
            
    def _search(self, chave, no_atual):
        if no_atual is None:
            return None
        elif no_atual.chave == chave:
            return no_atual
        elif no_atual.chave > chave:
            return self._search(chave, no_atual.esquerdo)
        elif no_atual.chave < chave:
            return self._search(chave, no_atual.direito)

    def remove(self, chave):
        '''Remove um valor da árvore'''
        no_remover = self.search_2(chave)
        if no_remover is None:
            print('Valor não encontrado')
            return None

        pai = no_remover.pai

        if no_remover.esquerdo is None and no_remover.direito is None:
            self.remove_folha(no_remover, pai)
        elif no_remover.esquerdo is None or no_remover.direito is None:
            self.remove_1filho(no_remover, pai)
        else:
            self.remove_2filhos(no_remover, pai)

    def remove_folha(self, no_remover, pai):
        if pai is None:
            self.raiz = None
            return

        if pai.esquerdo == no_remover:
            pai.esquerdo = None
        else:
            pai.direito = None

    def remove_1filho(self, no_remover, pai):
        if no_remover.esquerdo is not None:
            filho = no_remover.esquerdo
        else:
            filho = no_remover.direito

        filho.pai = pai

        if pai is None:
            self.raiz = filho
            return

        if pai.esquerdo == no_remover:
            pai.esquerdo = filho
        else:
            pai.direito = filho

    def acha_sucessor(self, no_atual):
        sucessor = no_atual.direito
        while sucessor.esquerdo is not None:
            sucessor = sucessor.esquerdo

        return sucessor

    def remove_2filhos(self, no_remover, pai):
        sucessor = acha_sucesor(no_remover)
        sucessor_pai = sucessor.pai

        sucessor_chave = sucessor.chave
        sucessor_valor = sucessor.valor

        if sucessor.direito is not None:
            if sucessor_pai.esquerdo == sucessor:
                sucessor_pai.esquerdo = sucessor.direito
            else:
                sucessor_pai.direito = sucessor.direito
            sucessor.direito.pai = sucessor_pai
        else:
            if sucessor_pai.esquerdo == sucessor:
                sucessor_pai.esquerdo = None
            else:
                sucessor_pai.direito = None

        no_remover.chave = sucessor_chave
        no_remover.valor = sucessor_valor