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
    public void sacarDinheiro(float valor) throws ExceptionNumeroNegativo {
        if(this.getSaldo() + this.getLimite() - valor < 0){
            throw new ExceptionNumeroNegativo("Valor ultrapassa o limite.");
        } else {
            this.setSaldo(this.getSaldo() - valor);
        }
    }


    
    
    
}
