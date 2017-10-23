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
                    depositarDineiro(contasCadastradas);
                    break;
                case 4:
                    atualizarContasPoupanca(contasCadastradas);
                    break;
                case 9:
                    mostrar(contasCadastradas, numeroDeContas);
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
        System.out.printf("\t3- Depositar dinheiro\n");
        System.out.printf("\t4- Virar o mes\n");
        System.out.printf("\t9- Mostrar Contas\n");
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
                    System.out.printf("Gostaria de predefinir os valores da conta?\n\t1- SIM\n\t2- NAO\n");
                    if(input.nextInt() == 1){
                        System.out.println("Nome:");
                        input.nextLine();
                        String name = input.nextLine();
                        System.out.println("Numero da Conta:");
                        int numConta = input.nextInt();
                        if(numeroDeContas != 0){
                            while(!nextNumeroConta(numConta, contasCadastradas)){
                                System.out.println("Numero de conta ja existe, tente de novo!");
                                numConta = input.nextInt();
                            }
                            System.out.println("Saldo Inicial: ");
                            float saldoInit = input.nextFloat();
                            contasCadastradas[numeroDeContas] = new ContaSimples(numConta, name, saldoInit);
                        }
                        else{
                            System.out.println("Saldo Inicial: ");
                            float saldoInit = input.nextFloat();
                            contasCadastradas[numeroDeContas] = new ContaSimples(numConta, name, saldoInit);
                        }
                    }
                    else contasCadastradas[numeroDeContas] = new ContaSimples(nextNumeroConta(contasCadastradas));
                    break;
                case 2:
                    System.out.printf("Gostaria de predefinir os valores da conta?\n\t1- SIM\n\t2- NAO\n");
                    if(input.nextInt() == 1){
                        System.out.println("Nome:");
                        input.nextLine();
                        String name = input.nextLine();
                        System.out.println("Numero da Conta:");
                        int numConta = input.nextInt();
                        if(numeroDeContas != 0){
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
                        else{
                            System.out.println("Saldo Inicial: ");
                            float saldoInit = input.nextFloat();
                            System.out.println("Limite Inicial: ");
                            float limiteInit = input.nextFloat();
                            contasCadastradas[numeroDeContas] = new ContaEspecial(numConta, name, saldoInit, limiteInit);
                        }
                    }
                    else contasCadastradas[numeroDeContas] = new ContaEspecial(nextNumeroConta(contasCadastradas));
                    break;
                case 3:
                    System.out.printf("Gostaria de predefinir os valores da conta?\n\t1- SIM\n\t2- NAO\n");
                    if(input.nextInt() == 1){
                        System.out.println("Nome:");
                        input.nextLine();
                        String name = input.nextLine();
                        System.out.println("Numero da Conta:");
                        int numConta = input.nextInt();
                        if(numeroDeContas != 0){
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
                        else{
                          System.out.println("Saldo Inicial: ");
                            float saldoInit = input.nextFloat();
                            System.out.println("Taxa de Rendimento: ");
                            float limiteInit = input.nextFloat();
                            contasCadastradas[numeroDeContas] = new ContaPoupanca(numConta, name, saldoInit, limiteInit);
                        }
                    }
                    else contasCadastradas[numeroDeContas] = new ContaPoupanca(nextNumeroConta(contasCadastradas));
                    break;
            }
        }
    }

    private static boolean nextNumeroConta(int numConta, Conta[] contas) {
        for(Conta i : contas){
            if(i != null){
                if(i.getNumeroConta() == numConta) return false;
            }
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
                if(i != null){
                    if(i.getNumeroConta() == numConta){
                        numUnico = false;
                        break;
                    }
                }
            }  
        }
        return numConta;
    }

    private static void sacarDineiro(Conta[] contasCadastradas) {
        Scanner input = new Scanner( System.in ); 
        System.out.println("Por favor, insira o numero da contar que quer sacar:");
        int numConta = input.nextInt();
        if(nextNumeroConta(numConta, contasCadastradas)){
            System.out.println("Conta Invalida!");
        }
        else{
            System.out.println("Valor do saque:");
            float valor = input.nextFloat();
            contasCadastradas[indexConta(contasCadastradas, numConta)].sacarDinheiro(valor);
            
            System.out.println("Saldo: " + contasCadastradas[indexConta(contasCadastradas, numConta)].getSaldo());
        }
    }

    private static void atualizarContasPoupanca(Conta[] contasCadastradas) {
        for(Conta poupança : contasCadastradas){
            if(poupança instanceof ContaPoupanca){
                ContaPoupanca attConta = (ContaPoupanca)poupança;
                attConta.atualizar();
            }
        }
    }

    private static int indexConta(Conta[] contasCadastradas, int numConta) {
        int num = 0;
        for(Conta i : contasCadastradas){
            if(i != null){
                if(i.getNumeroConta() == numConta) return num;
            }
            num++;
        }
        return 0;
    }

    private static void depositarDineiro(Conta[] contasCadastradas) {
        Scanner input = new Scanner( System.in ); 
        System.out.println("Por favor, insira o numero da contar que quer depositar:");
        int numConta = input.nextInt();
        if(nextNumeroConta(numConta, contasCadastradas)){
            System.out.println("Conta Invalida!");
        }
        else{
            System.out.println("Valor do deposito:");
            float valor = input.nextFloat();
            contasCadastradas[indexConta(contasCadastradas, numConta)].depositarDinheiro(valor);
            
            System.out.println("Saldo: " + contasCadastradas[indexConta(contasCadastradas, numConta)].getSaldo());
        }
    }
    
    public static void mostrar(Conta[] contas, int num){
        int contador;
        ContaSimples temporario1;
        ContaEspecial temporario2;
        ContaPoupanca temporario3;
        
        System.out.println("======================================================");
        for(contador = 0; contador < num; contador++){
            if(contas[contador] instanceof ContaSimples){
                temporario1 = (ContaSimples)contas[contador];
                System.out.println("Conta Simples");
                System.out.printf(temporario1.printaVariaveis());
            }
            else if(contas[contador] instanceof ContaEspecial){
                temporario2 = (ContaEspecial)contas[contador];
                System.out.println("Conta Especial");
                System.out.printf(temporario2.printaVariaveis());
                System.out.println("Limite = " + temporario2.getLimite());
            }
            else if(contas[contador] instanceof ContaPoupanca){
                temporario3 = (ContaPoupanca)contas[contador];
                System.out.println("Conta Poupança");
                System.out.printf(temporario3.printaVariaveis());
                System.out.println("Taxa = " + temporario3.getTaxaRendimento());
            }
            if(contador != num - 1) System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
        }
        System.out.println("======================================================");
        
    }
}