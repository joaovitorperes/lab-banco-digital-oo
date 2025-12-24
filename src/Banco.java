import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas = new ArrayList<>(); // Inicializada para evitar NullPointerException

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    // Método de evolução: Exibe todos os clientes do banco
    public void exibirClientes() {
        System.out.println("=== Lista de Clientes do Banco ===");
        for (Conta conta : contas) {
            System.out.println(String.format("Titular: %s | CPF: %s", 
                conta.getCliente().getNome(), 
                conta.getCliente().getCpf()));
        }
    }
}