package controledecontas;

public abstract class Conta {
   private int numeroConta; 
   private String nomeUsuario;
   private float saldo;

    // Constructors
    public Conta(int numeroConta, String nomeUsuario, float saldo) {
        this.numeroConta = numeroConta;
        this.nomeUsuario = nomeUsuario;
        this.saldo = saldo;
    }
    public Conta(int numConta) {
        this.numeroConta = numConta;
        this.nomeUsuario = "noName";
        this.saldo = 0;
    }
    
   // Metodos
    public String printaVariaveis() {
        return "Numero = " + numeroConta + "\nNome = " + nomeUsuario + "\nSaldo = " + saldo  + "\n";
    }

    // Getts and Setters
    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public void sacarDinheiro(float valor) throws ExceptionNumeroNegativo{
        if(this.getSaldo() - valor < 0){
            throw new ExceptionNumeroNegativo("Valor passa do limite.");
        } else{
             this.setSaldo(this.getSaldo() - valor);
        }
    
    }

    void depositarDinheiro(float valor) {
        
        this.setSaldo(this.getSaldo() + valor);
    
    }

}
