package controledecontas;

public class ContaEspecial extends Conta{
    private float limite;

    // Constructors
    public ContaEspecial(int numeroConta, String nomeUsuario, float saldo, float limite) {
        super(numeroConta, nomeUsuario, saldo);
        this.limite = limite;
    }

    public ContaEspecial(int numConta) {
        super(numConta);
        this.limite = 0;
    }
    
    // Getters and Setters

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    @Override
    public void sacarDinheiro(float valor) {
        if((this.getSaldo() - valor) > (-1)*this.getLimite()){
            super.sacarDinheiro(valor);
        }
        else{
            System.out.println("ERRO.\nLimite atingido.\n");
        }
    }
    
    
    
}
