#encondig "utf-8"
class Carro:
    def __init__(self):
        self.passageiro = 0
        self.km = 0
        self.gasolina = 0
        self.limite_passageiro = 2
        self.limite_gasolina = 10
    
    def entrar(self):
        if self.passageiro < self.limite_passageiro:
            self.passageiro += 1
        else:
            print("Desculpe, limite de pessoas atingido!")

    def tirar(self):
        if self.passageiro > 0:
            self.passageiro -= 1
        else:
            print("Não há ninguem no carro")
    
    def abastecer(self, qtd):
        self.gasolina += qtd
        if(self.gasolina > self.limite_gasolina):
            self.gasolina = self.limite_gasolina
        
    def andar(self, distancia):
        if self.passageiro == 0:
            print("Ops, não há ninguem no carro!")
            return

        gs_necessario = distancia / 10
        if(self.gasolina >= gs_necessario):
            self.km += distancia
            self.gasolina -= gs_necessario
        else:
            print("Vishi! Gasolina insuficiente.")


    def __str__(self):
        return "Passegeiro(s): " + str(self.passageiro) + ", Gasolina: " + str(self.gasolina) + ", KM: " + str(self.km)

carro = Carro()
line = ""
print("Comandos: mostrar, entrar, sair, gasolina, andar, fim")
while(line != "fim"):
    line = input()
    ux = line.split(" ")

    if ux[0] == "fim":
        break
    elif ux[0] == "mostrar":
        print(carro)
    elif ux[0] == "entrar":
        carro.entrar()
    elif ux[0] == "sair":
        carro.tirar()
    elif ux[0] == "gasolina":
        carro.abastecer(int(ux[1]))
    elif ux[0] == "andar":
        carro.andar(int(ux[1])) 
    else:
        print("Comando Inválido!")