

def fibonacci(n):
    fibonacci_sequence = [0, 1]
    if n <= 1:
        return n

    for i in range(2, n + 1):
        next_term = fibonacci_sequence[i - 1] + fibonacci_sequence[i - 2]
        fibonacci_sequence.append(next_term)

    return fibonacci_sequence[n]
    
op = int(input())
vet = []

for i in range(op):
    numero_fib = int(input())
    vet.append(numero_fib)

for i in range(op):
    print(f"Fib({vet[i]}) = {fibonacci(vet[i])}")
