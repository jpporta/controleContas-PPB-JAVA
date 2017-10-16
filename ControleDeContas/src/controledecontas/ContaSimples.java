package controledecontas;

public class ContaSimples extends Conta{

    public ContaSimples(int numeroConta, String nomeUsuario, float saldo) {
        super(numeroConta, nomeUsuario, saldo);
    }

    public ContaSimples(int numConta) {
        super(numConta);
    }
}
