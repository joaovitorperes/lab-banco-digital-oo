import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Banco meuBanco = new Banco();
        meuBanco.setNome("Banco Digital Java");

        Cliente venilton = new Cliente();
        venilton.setNome("Venilton");
        venilton.setCpf("123.456.789-00"); // Atribuindo o novo campo

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);

        // Adicionando as contas à lista do banco
        meuBanco.setContas(Arrays.asList(cc, poupanca));

        cc.depositar(100);
        cc.transferir(50, poupanca);
        
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        // Testando a nova funcionalidade do Banco
        meuBanco.exibirClientes();
    }
}