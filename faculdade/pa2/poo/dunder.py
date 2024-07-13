class Polinomio:
    def __init__(self, a, b, c):
        self.a = a
        self.b = b
        self.c = c

    def __str__(self):
        rotulo = f"{self.a}x^2 + {self.b}x + {self.c}"
        return rotulo
    
    def somar(self, polinomio2):
        n_a = self.a + polinomio2.a
        n_b = self.b + polinomio2.b
        n_c = self.c + polinomio2.c
        return Polinomio(n_a, n_b, n_c)
    
    def __add__(self, p2):
        return self.somar(p2)
    
p1 = Polinomio(1, 0, 5)
p2 = Polinomio(2, 5, -200)
p3 = p1.somar(p2)
p4 = p3 + p1
p5 = p1 + p2 + p3

l = [p1, p2, p3, p4, p5]
for p in l:
    print(p)