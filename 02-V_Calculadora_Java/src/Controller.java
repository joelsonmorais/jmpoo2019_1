import java.util.Scanner;

class Calculadora {
    public int bateriaMax;
    public int bateria;
    public int total;

    public Calculadora(int bateriaMax) {
        this.bateriaMax = bateriaMax;
        this.bateria = 0;
    }

    public void charge(int value){
        this.bateria += value;
        if (this.bateria > this.bateriaMax){
            this.bateria = this.bateriaMax;
        }
    }

    public boolean gastarBateria(int a, int b){
        if (this.bateria == 0){
            System.out.println("fail: bateria insuficiente");
            return false;}
        System.out.println("a + b");
        return true;
    }

    public void somar(int a, int b){
        if (this.bateria > 0){
            this.bateria -=1;
            total = a + b;
            System.out.println(total);
        }else{
            System.out.println("fail: bateria insuficiente");
        }
    }

    public void subtrair(int a, int b){
        if (this.bateria > 0){
            this.bateria -= 1;
            total = a - b;
            System.out.println(total);
            if (total == 0){
                System.out.println("ops, erro!");
            }
        }else{
            System.out.println("fail: bateria insuficiente");
        }

    }

    public void multiplicar(int a, int b){
        if (this.bateria > 0){
            this.bateria -= 1;
            total = a * b;
            System.out.println(total);
            if (total == 0){
                System.out.println("ops, erro!");
            }
        }else{
            System.out.println("fail: bateria insuficiente");
        }

    }

    public void dividir(int a, int b){
        if (this.bateria > 0){
            this.bateria -= 1;
            total = a / b;
            System.out.println(total);
            if (total == 0){
                System.out.println("ops, erro!");
            }
        }else{
            System.out.println("fail: bateria insuficiente");
        }

    }

    @Override
    public String toString() {
        return "bateria = " + this.bateria;
    }
}

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora(0);

        while (true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("fim")) {
                break;
            }else if (ui[0].equals("mostrar")){
                System.out.println(calculadora);
            }else if (ui[0].equals("entrar")){
                calculadora = new Calculadora(Integer.parseInt(ui[1]));
            }else if (ui[0].equals("caregar")){
                calculadora.charge(Integer.parseInt(ui[1]));
            }else if (ui[0].equals("somar")) {
                calculadora.somar(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            }else if(ui[0].equals("subtrair")){
                calculadora.subtrair(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            }else if(ui[0].equals("multiplicar")){
                calculadora.multiplicar(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            }else if(ui[0].equals("dividir")){
                calculadora.dividir(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            }else{
                System.out.println("comando invalido");
            }
        }
    }
}