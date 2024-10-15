import matplotlib.pyplot as plt

def func_matematica(xmin, xmax, dx):
	vetor = []
	i = xmin
	
	while i <= xmax:
		vetor.append(i)
		i += dx
		
	return vetor

def polinomio(x):
	return x**3

def cria_valores(xmin, xmax, dx):
	vetor1 = func_matematica(xmin, xmax, dx)
	vetor2 = []
	
	for i in range(len(vetor1)):
		result = polinomio(vetor1[i])
		vetor2.append(result)
		
	return vetor1, vetor2

x, y = cria_valores(-10, 10, 1)
plt.plot(x, y)
plt.show()
	