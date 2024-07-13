from pessoa import Pessoa

class PessoaFisica(Pessoa):
    def set_cpf(self, nCpf):
        self.cpf = nCpf

    def nome_completo(self):
        return f"{self.nome} {self.sobrenome} - {self.cpf}"

pf1 = PessoaFisica("Chuck", "Norris")
pf1.set_cpf("12345678912")

p1 = Pessoa("Bruce", "Lee")

pessoas = [pf1, p1]
for pessoa in pessoas:
    print(pessoa.nome_completo())
