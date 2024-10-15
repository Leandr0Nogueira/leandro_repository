import arvore_buscaBinaria

tree = arvore_buscaBinaria.ArvoreBinaria()

op = ''
menu = '''___| Menu |___
a - Inserir
b - Buscar
s - Sair
'''

while op != 's':
    print(menu)
    op = input('Opção: ')
    if op == 'a':
        chave = input('Digite a chave: ')
        valor = int(input('Digite o valor: '))
        tree.insert(chave, valor)
    elif op == 'b':
        chave = input('Digite a chave: ')
        valor = tree.search(chave)
        print(f'Valor: {valor}')
    elif op == 's':
        print('Saindo...')
        tree.imprime()
    else:
        print('Opção inválida')