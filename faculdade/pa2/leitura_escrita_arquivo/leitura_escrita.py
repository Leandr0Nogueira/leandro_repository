arquivo = open('leitura_escrita_arquivo/teste.txt', 'r') #prepara arquivo para leitura
texto = arquivo.read() #lê arquivo
arquivo.close() #fecha arquivo
linhas = texto.splitlines() #divide conteúdo do arquivo em linhas

print(texto) #printa conteudo total do arquivo
print(linhas) #printa linhas do arquivo em vetor

string = 'esse texto sera escrito no arquivo, pe na jaca' 
arquivo = open('leitura_escrita_arquivo/saida.txt', 'w') #prepara arquivo para escrita com nome do arquivo para saida
arquivo.write(string) #escreve no arquivo
arquivo.close() #fecha arquivo