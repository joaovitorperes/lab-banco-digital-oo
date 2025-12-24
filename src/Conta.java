public abstract class Conta implements IConta {
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        // Evolução: Validação de segurança para não sacar mais do que possui
        if (valor > saldo) {
            System.out.println("Erro: Saldo insuficiente para o saque de R$ " + valor);
            return; 
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        // Evolução: Só transfere se o saque for permitido
        if (valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Erro: Saldo insuficiente para transferência.");
        }
    }

    // Getters manuais (substituindo o @Getter do Lombok)
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}