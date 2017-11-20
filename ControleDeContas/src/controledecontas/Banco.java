package controledecontas;

import java.util.*;

/**
 *
 * @author Paulo
 */
public class Banco {

    private static Banco INSTANCE = new Banco();
    private Collection<Conta> contas = new ArrayList();
    private String msgContaEx = "Já existe";
    private String msgContaN = "Conta não encontrada";

    private Banco() {
    }

    public static Banco getInstance() {
        return INSTANCE;
    }

    public void criarContaSimples(String nome, int numero, float saldo) {
        if (isNumAv(numero)) {
            contas.add(new ContaSimples(numero, nome, saldo));
        }
    }

    public void criarContaEspecial(String nome, int numero, float saldo, float limite) {
        if (isNumAv(numero)) {
            contas.add(new ContaEspecial(numero, nome, saldo, limite));
        }
    }

    public void criarContaPoupanca(String nome, int numero, float saldo, float tRend) {
        if (isNumAv(numero)) {
            contas.add(new ContaPoupanca(numero, nome, saldo, tRend));
        }
    }

    public String deposito(int numero, float qtd) {
        if (isNumAv(numero)) {
            for (Conta contaCol : contas) {
                contaCol.depositarDinheiro(qtd);
                return Float.toString(contaCol.getSaldo());
            }
        }
        return msgContaEx;
    }

    public String saque(int numero, float qtd) {
        if (isNumAv(numero)) {
            for (Conta contaCol : contas) {
                try {
                    if (contaCol.getNumeroConta() == numero) {
                        contaCol.sacarDinheiro(qtd);
                        return Float.toString(contaCol.getSaldo());
                    }
                } catch (ExceptionNumeroNegativo erro) {
                    return erro.getMessage();
                }
            }
        }
        return msgContaEx;
    }

    private boolean isNumAv(int num) {
        for (Conta i : contas) {
            if (i != null) {
                if (i.getNumeroConta() == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void escrevaArquivo() {
        CreateTextFile database = new CreateTextFile();

        database.openFile();

        for (Conta auxiliar : contas) {
            if (auxiliar instanceof ContaPoupanca) {
                ContaPoupanca printar = (ContaPoupanca) auxiliar;
                database.mandarArquivo(printar);
            } else if (auxiliar instanceof ContaSimples) {
                ContaSimples mandar = (ContaSimples) auxiliar;
                database.mandarArquivo(mandar);
            } else if (auxiliar instanceof ContaEspecial) {
                ContaEspecial imprimir = (ContaEspecial) auxiliar;
                database.mandarArquivo(imprimir);
            }
        }

        database.closeFile();
    }

    public void incrementar() {
        for (Conta virar : contas) {
            if (virar instanceof ContaPoupanca) {
                ContaPoupanca incremento = (ContaPoupanca) virar;
                incremento.atualizar();
            }
        }
    }

    public void lerArquivo() {
        ReadTextFile db = new ReadTextFile();

        db.openFile();

        db.readRecords();

        db.closeFile();

    }

    public String consultar(int numeroConta) {
        for (Conta consulta : contas) {
            if (!isNumAv(numeroConta)) {
                return Float.toString(consulta.getSaldo());
            }
        }
        return msgContaN;
    }
}
