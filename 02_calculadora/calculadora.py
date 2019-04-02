#encondig "utf-8"
class Calculadora:
    def __init__(self, bateriaMax):
        self.bateria = 0
        self.bateriaMax = bateriaMax
    
    def gastarBateria(self):
        if(self.bateria == 0):
            print("Ops, bateria insuficiente")
            return False
        
        self.bateria -= 1
        return True

    def soma(self, a, b):
        if(self.gastarBateria()):
            print(a + b)
    

    def carregar(self, value):
        self.bateria += value
        if(self.bateria > self.bateriaMax):
            self.bateria = self.bateriaMax

    def __str__(self):
        return "bateria = " + str(self.bateria) + str(self.bateriaMax)

calculadora = Calculadora(0)

print("mostrar, entrar, carregar, somar, fim")
while True:
    ux = input().split(" ")
    if ux[0] == "fim":
        break
    elif ux[0] == "entrar":
        calculadora = Calculadora(int(ux[1]))
    elif ux[0] == "mostrar":
        print(calculadora)
    elif ux[0] == "carregar":
        calculadora.mostrar(int(ux[1]))
    else:
        print("Comando Inválido!")

    def pegarEnergia(self):
        return self.energia
    def todaEnergia(self, value):
        if(value < 0):
            self.energia = 0
        elif(value > self.energiaMax):
            self.energia = self.energiaMax
        else:
            self.enegia = value

    def comer(self):
        self.todaEnergia(self.pegarEnergia() - 1)
