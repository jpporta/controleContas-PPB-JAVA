package controledecontas;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Paulo
 */
public class ReadTextFile {

    private Scanner input;

    public void openFile() {

        try {
            input = new Scanner(new File("contas.txt"));
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Erro ao abrir o arquivo.");
            System.exit(1);
        }
    }

    public void readRecords() {
        Banco database = Banco.getInstance();
        String tipo, nome;
        int numConta;
        float saldo, limite, incremento;

        try {
            while (input.hasNext()) {
                tipo = input.nextLine();                                            //Pega o Tipo da conta
                input.next();                                                       //Ignora o "Numero: "
                numConta = input.nextInt();                                         //Pega o Número da conta
                input.next();                                                       //Ignora o "Nome: "
                nome = input.next();                                                //Pega o Nome da conta
                input.next();                                                       //Ignora o "Saldo: "
                saldo = input.nextFloat();                                          //Pega o Saldo da conta

                if (tipo.equalsIgnoreCase("Conta Simples")) {                       //Se o tipo for Conta Simples
                    database.criarContaSimples(nome, numConta, saldo);              //Manda pro database
                    input.nextLine();                                               //\n
                    input.nextLine();                                               //Divisória das contas (estética no arquivo)
                    
                } else if (tipo.equalsIgnoreCase("Conta Especial")) {               //Se o tipo for Conta Especial
                    input.next();                                                   //Ignora o "Limite: "
                    limite = input.nextFloat();                                     //Pega o Limite da conta
                    database.criarContaEspecial(nome, numConta, saldo, limite);     //Manda pro database
                    input.nextLine();                                               //\n
                    input.nextLine();                                               //Divisória das contas (estética no arquivo)
                    
                } else if (tipo.equalsIgnoreCase("Conta Poupança")) {               //Se o tipo for Conta Poupança
                    input.next();                                                   //Ignora o "Taxa: "
                    incremento = input.nextFloat();                                 //Pega o Rendimento da conta
                    database.criarContaPoupanca(nome, numConta, saldo, incremento); //Manda pro database
                    input.nextLine();                                               //\n
                    input.nextLine();                                               //Divisória de contas (estética no arquivo)
                }
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file.");
            System.exit(1);
        }
    }

    public void closeFile() {
        if (input != null) {
            input.close();
        }
    }
}
