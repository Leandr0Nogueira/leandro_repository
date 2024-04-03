def motor(vetor):
    for i in range(len(vetor)):
        if vetor[i] < vetor[i - 1] and i > 0:
            return i + 1

velocidades = []
for i in range(int(input())):
    op = int(input())
    velocidades.append(op)

print(motor(velocidades))
