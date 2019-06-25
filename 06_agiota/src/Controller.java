import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Transacao{
    int id;
    float value;
    String clientId;

    public Transacao(int id, float value, String clientId) {
        this.id = id;
        this.value = value;
        this.clientId = clientId;
    }

    public String toString(){
        return "" + id + ":" + value + ":" + clientId;
    }
}
class Cliente{
    String id;
    String fullname;
    float  saldo;
    public Cliente(String id, String fullname){
        this.id = id;
        this.fullname = fullname;
        this.saldo = 0;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.fullname + ":" + this.saldo;
    }
}
//Sistema - saldo(cliente); clientes(ArrayList) e as transações(ArrayList)
class Sistema {
    float saldo;
    ArrayList<Cliente> clientes;
    ArrayList<Transacao> transacoes;
    int nextTrId;

    public Sistema(float saldo) {
        this.saldo = saldo;
        this.clientes = new ArrayList<Cliente>();
        this.transacoes = new ArrayList<Transacao>();
        this.nextTrId = 0;
    }
    //cadastro_dos_clientes
    void cadastrar(Cliente cliente) {
        try {
            this.findCliente(cliente.id);
            throw new RuntimeException("Cliente ja exite");
        }catch(RuntimeException re){
            clientes.add(cliente);
        }
    }
    //buscar_clientes - um for que encontrara se existe um cliente com o mesmo id
    Cliente findCliente(String id) {
        for (Cliente cli : clientes) {
            if (cli.id.equals(id))
                return cli;
        }
        throw new RuntimeException("fail: cliente nao existe");
    }
    //adicionar_transações
    void addTransacao(float value, String clienteId) {
        this.transacoes.add(new Transacao(nextTrId, value, clienteId));
        nextTrId += 1;
    }
    //empresta_saldo
    void emprestar(String id, float saldo) {
        Cliente cli = findCliente(id);
        addTransacao(-saldo, id);
        this.saldo -= saldo;
        cli.saldo += saldo;
    }
    //recebe saldo do id(cliente)
    void receber(String id, float saldo) {
        Cliente cli = findCliente(id);
        if(cli.saldo < saldo){
            System.out.println("fail: pagamento maior que divida");
            return;
        }
        addTransacao(saldo, id);
        cli.saldo -= saldo;
        this.saldo += saldo;
    }
    //retornara e mostrara um lista de trasações feitas
    ArrayList<Transacao> getHistorico() {
        return transacoes;
    }


    @Override
    public String toString() {
        String saida = "";
        for(Cliente cliente : clientes)
            saida += cliente + "\n";
        saida += "saldo:" + this.saldo;
        return saida;
    }
}

//principal
public class Controller {
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            try {
                if (ui[0].equals("end")) {
                    break;
                } else if (ui[0].equals("init")) {
                    sistema = new Sistema(Float.parseFloat(ui[1]));
                } else if (ui[0].equals("show")) {
                    System.out.println(sistema);
                } else if (ui[0].equals("emprestar")) {
                    sistema.emprestar(ui[1], Float.parseFloat(ui[2]));
                } else if (ui[0].equals("historico")) {
                    for (Transacao tr : sistema.getHistorico())
                        System.out.println(tr);
                } else if (ui[0].equals("cadastrar")) {
                    String id = ui[1];
                    String[] subarray = Arrays.copyOfRange(ui, 2, ui.length);
                    String fullname = String.join(" ", subarray);
                    sistema.cadastrar(new Cliente(id, fullname));

                } else {
                    System.out.println("fail: comando invalido");
                }
            }catch(RuntimeException re){
                System.out.println(re.getMessage());
            }
        }
    }

}