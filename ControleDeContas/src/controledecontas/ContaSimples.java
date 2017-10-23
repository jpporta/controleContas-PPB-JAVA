package controledecontas;

public class ContaSimples extends Conta{

    public ContaSimples(int numeroConta, String nomeUsuario, float saldo) {
        super(numeroConta, nomeUsuario, saldo);
    }

    public ContaSimples(int numConta) {
        super(numConta);
    }

    @Override
    public void sacarDinheiro(float valor) {
        
        if(valor <= this.getSaldo()){
            
        super.sacarDinheiro(valor);
        
        }
        else{
            
            System.out.println("Impossível realizar o saque. Valor insuficiente.");
            
        }
    }
    
}
