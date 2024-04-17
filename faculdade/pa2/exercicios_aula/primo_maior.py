def primo(valor):
    for i in range(2, valor):
        if valor%i == 0:
            return False
    return True

def prox_primo(R):
    ehPrimo = False
    while ehPrimo == False:
        R += 1
        ehPrimo = primo(R)
    return R


print(prox_primo(int(input())))