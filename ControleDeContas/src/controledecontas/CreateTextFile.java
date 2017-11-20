package controledecontas;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 *
 * @author Paulo
 */
public class CreateTextFile {
    private Formatter output;
    
    public void openFile(){
        try{
            output = new Formatter( "contas.txt" );
        } catch ( SecurityException securityException){
            System.err.println("You shall not write in this file.");
            System.exit( 1 );
        } catch ( FileNotFoundException fileNotFoundException){
            System.err.println("Tou shall not open.");
            System.exit( 1 );
        }
    }
    
    public void mandarArquivo(ContaSimples conta){
        output.format("Conta Simples\nNumero: %d\nNome: %s\nSaldo: %.2f\n-----------------------\n",
                conta.getNumeroConta(), conta.getNomeUsuario(), conta.getSaldo());
    }
    
    public void mandarArquivo(ContaEspecial conta){
        output.format("Conta Especial\nNumero: %d\nNome: %s\nSaldo: %.2f\nLimite: %.2f\n-----------------------\n",
                conta.getNumeroConta(), conta.getNomeUsuario(), conta.getSaldo(), conta.getLimite());
    }
    
    public void mandarArquivo(ContaPoupanca conta){
        output.format("Conta Poupança\nNumero: %d\nNome: %s\nSaldo: %.2f\nTaxa: %.2f\n-----------------------\n",
                conta.getNumeroConta(), conta.getNomeUsuario(), conta.getSaldo(), conta.getTaxaRendimento());
    }
    
    public void closeFile(){
        if(output != null)
            output.close();
    }
}
