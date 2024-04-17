tentativas = [0, 0, 0]
acertos = [0, 0, 0]
nomes = []
taxas = []

jogadores = int(input())

for i in range(jogadores):
    nomes.append(input())
    for j in range(3):
        tentativas[j] += int(input())

    for j in range(3):
        acertos[j] += int(input())
    
for i in range(3):
    taxas.append((acertos[i] / tentativas[i])*100)

print("Pontos de Saque: %.2f %%." % taxas[0])
print("Pontos de Bloqueio: %.2f %%." % taxas[1])
print("Pontos de Ataque: %.2f %%." % taxas[2])