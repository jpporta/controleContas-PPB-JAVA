package controledecontas;
import java.util.*;

public class ControleDeContas {
    public static void main(String[] args) {
        Conta[] contasCadastradas = new Conta[10];
        int numeroDeContas = 0;
        int opcao;
        
        opcao = menu();
        while (opcao != 0){
            switch (opcao){
                case 1:
                    criarConta(contasCadastradas, numeroDeContas);
                    numeroDeContas++;
                    break;
                case 2:
                    sacarDineiro(contasCadastradas);
                    break;
                case 3:
                    atualizarContasPoupanca(contasCadastradas);
                    break;
                case 0:
                    System.out.println("Tchau");
            }
            opcao = menu();
        }
    }
    private static int menu(){
        Scanner input = new Scanner( System.in ); 
        System.out.println("Bem Vindo ao PJ Banks!");
        System.out.printf("\t1- Criar Conta\n");
        System.out.printf("\t2- Sacar dinheiro\n");
        System.out.printf("\t3- Virar o mes\n");
        System.out.printf("\t0- Sair\n");
        return input.nextInt();
    }
    private static void criarConta(Conta[] contasCadastradas, int numeroDeContas) {
        Scanner input = new Scanner( System.in ); 
        if(numeroDeContas == 10){
            System.out.println("LIMITE DE CONTAS ALCANCADO");
        }
        else{
            System.out.println("Qual tipo de conta a ser criada?");
            System.out.printf("\t1-Conta Simples\n");
            System.out.printf("\t2-Conta Especial\n");
            System.out.printf("\t3-Conta Poupanca\n");
            switch (input.nextInt()){
                case 1:
                    System.out.printf("Gostaria de predefinir os valores da conta?\n\t1- SIM\n\t2-NAO");
                    if(input.nextInt() == 1){
                        System.out.println("Nome:");
                        input.next();
                        String name = input.nextLine();
                        System.out.println("Numero da Conta:");
                        int numConta = input.nextInt();
                        while(!nextNumeroConta(numConta, contasCadastradas)){
                            System.out.println("Numero de conta ja existe, tente de novo!");
                            numConta = input.nextInt();
                        }
                        System.out.println("Saldo Inicial: ");
                        float saldoInit = input.nextFloat();
                        contasCadastradas[numeroDeContas] = new ContaSimples(numConta, name, saldoInit);
                    }
                    else contasCadastradas[numeroDeContas] = new ContaSimples(nextNumeroConta(contasCadastradas));
                    break;
                case 2:
                    System.out.printf("Gostaria de predefinir os valores da conta?\n\t1- SIM\n\t2-NAO");
                    if(input.nextInt() == 1){
                        System.out.println("Nome:");
                        input.next();
                        String name = input.nextLine();
                        System.out.println("Numero da Conta:");
                        int numConta = input.nextInt();
                        while(!nextNumeroConta(numConta, contasCadastradas)){
                            System.out.println("Numero de conta ja existe, tente de novo!");
                            numConta = input.nextInt();
                        }
                        System.out.println("Saldo Inicial: ");
                        float saldoInit = input.nextFloat();
                        System.out.println("Limite Inicial: ");
                        float limiteInit = input.nextFloat();
                        contasCadastradas[numeroDeContas] = new ContaEspecial(numConta, name, saldoInit, limiteInit);
                    }
                    else contasCadastradas[numeroDeContas] = new ContaEspecial(nextNumeroConta(contasCadastradas));
                    break;
                case 3:
                    System.out.printf("Gostaria de predefinir os valores da conta?\n\t1- SIM\n\t2-NAO");
                    if(input.nextInt() == 1){
                        System.out.println("Nome:");
                        input.next();
                        String name = input.nextLine();
                        System.out.println("Numero da Conta:");
                        int numConta = input.nextInt();
                        while(!nextNumeroConta(numConta, contasCadastradas)){
                            System.out.println("Numero de conta ja existe, tente de novo!");
                            numConta = input.nextInt();
                        }
                        System.out.println("Saldo Inicial: ");
                        float saldoInit = input.nextFloat();
                        System.out.println("Taxa de Rendimento: ");
                        float limiteInit = input.nextFloat();
                        contasCadastradas[numeroDeContas] = new ContaPoupanca(numConta, name, saldoInit, limiteInit);
                    }
                    else contasCadastradas[numeroDeContas] = new ContaPoupanca(nextNumeroConta(contasCadastradas));
                    break;
            }
        }
    }

    private static boolean nextNumeroConta(int numConta, Conta[] contas) {
        for(Conta i : contas){
            if(i.getNumeroConta() == numConta) return false;
        }
        return true;
    }
     private static int nextNumeroConta(Conta[] contas) {
        boolean numUnico = false;
        int numConta = 0;
        while(!numUnico){
            numUnico = true;
            numConta++;
            for(Conta i : contas){
                if(i.getNumeroConta() == numConta){
                    numUnico = false;
                    break;
                }
            }  
        }
        return numConta;
    }

    private static void sacarDineiro(Conta[] contasCadastradas) {
        Scanner input = new Scanner( System.in ); 
        System.out.println("Por favor, insira o numero da contar que quer sacar:");
        int numConta = input.nextInt();
        if(!nextNumeroConta(numConta, contasCadastradas)){
            System.out.println("Conta Invalida!");
        }
        else{
            contasCadastradas[indexConta(contasCadastradas, numConta)].sacarDineiro();
        }
    }

    private static void atualizarContasPoupanca(Conta[] contasCadastradas) {
        for(Conta i : contasCadastradas){
            if(i instaceof ContaPoupanca);
        }
    }

    private static int indexConta(Conta[] contasCadastradas, int numConta) {
        int num = 0;
        for(Conta i : contasCadastradas){
            if(i.getNumeroConta() == numConta) return num;
            num++;
        }
        return 0;
    }
}
