vet = []
for i in range(10):
    vet.append(int(input()))
    if vet[i] <= 0:
        vet[i] = 1

for i in range(10):
    print(f"X[{i}] = {vet[i]}")