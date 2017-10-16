package controledecontas;

public class ContaPoupanca extends Conta{
    private float taxaRendimento;
    
    // Constructers
    public ContaPoupanca( int numeroConta, String nomeUsuario, float saldo, float taxaRendimento) {
        super(numeroConta, nomeUsuario, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca(int numConta) {
        super(numConta);
        this.taxaRendimento = 0;
    }
    
    // Getters and Setters

    public float getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(float taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
    
}
