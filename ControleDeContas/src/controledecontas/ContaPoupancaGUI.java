package controledecontas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Paulo
 */
public class ContaPoupancaGUI extends JFrame {

    private JButton criar;
    private JLabel nome;
    private JTextField entradaNome = new JTextField(10);
    private JLabel numero;
    private JTextField entradaNumero = new JTextField(10);
    private JLabel saldo;
    private JTextField entradaSaldo = new JTextField(10);
    private JLabel incremento;
    private JTextField entradaIncremento = new JTextField(10);
    private JPanel principal = new JPanel();
    private JPanel horznome = new JPanel();
    private JPanel box1 = new JPanel();
    private JPanel horznumero = new JPanel();
    private JPanel box2 = new JPanel();
    private JPanel horzsaldo = new JPanel();
    private JPanel box3 = new JPanel();
    private JPanel horzincremento = new JPanel();
    private JPanel box4 = new JPanel();
    private JPanel horzchoice = new JPanel();
    private JButton ok = new JButton("Ok");
    private JButton cancelar = new JButton("Cancelar");

    public ContaPoupancaGUI() {

        super("Criar Conta Poupança");
        box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS));
        box2.setLayout(new BoxLayout(box2, BoxLayout.Y_AXIS));
        box3.setLayout(new BoxLayout(box3, BoxLayout.Y_AXIS));
        box4.setLayout(new BoxLayout(box4, BoxLayout.Y_AXIS));
        horznome.setLayout(new FlowLayout());
        horznumero.setLayout(new FlowLayout());
        horzsaldo.setLayout(new FlowLayout());
        horzincremento.setLayout(new FlowLayout());
        horzchoice.setLayout(new FlowLayout());

        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        criarContaPoupancaHandler handler = new criarContaPoupancaHandler();
        JLabel titulo = new JLabel("Conta Poupança");
        principal.add(Box.createRigidArea(new Dimension(0,10)));
        principal.add(titulo);
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        nome = new JLabel("Nome");
        numero = new JLabel("Numero");
        saldo = new JLabel("Saldo");
        incremento = new JLabel("Rendimento");

        principal.add(Box.createRigidArea(new Dimension(0,10)));

        box1.add(nome);
        nome.setAlignmentX(CENTER_ALIGNMENT);
        horznome.add(entradaNome);
        box1.add(horznome);
        entradaNome.addActionListener(handler);
        principal.add(box1);

        box2.add(numero);
        numero.setAlignmentX(CENTER_ALIGNMENT);
        horznumero.add(entradaNumero);
        box2.add(horznumero);
        entradaNumero.addActionListener(handler);
        principal.add(box2);

        box3.add(saldo);
        saldo.setAlignmentX(CENTER_ALIGNMENT);
        horzsaldo.add(entradaSaldo);
        box3.add(horzsaldo);
        entradaSaldo.addActionListener(handler);
        principal.add(box3);

        box4.add(incremento);
        incremento.setAlignmentX(CENTER_ALIGNMENT);
        horzincremento.add(entradaIncremento);
        box4.add(horzincremento);
        entradaIncremento.addActionListener(handler);
        principal.add(box4);

        horzchoice.add(ok);
        ok.addActionListener(handler);
        horzchoice.add(cancelar);
        cancelar.addActionListener(handler);
        principal.add(horzchoice);

        add(principal);
    }

    private class criarContaPoupancaHandler implements ActionListener {

        Banco datab = Banco.getInstance();
        String criada;
        
        @Override
        public void actionPerformed(ActionEvent entrada) {

            int numeroConta;
            float saldoConta, incrementoConta;
            if (entrada.getSource() == ok) {
                try{
                    numeroConta = Integer.parseInt(entradaNumero.getText());
                    try{
                        saldoConta = Float.parseFloat(entradaSaldo.getText());
                        try{
                            incrementoConta = Float.parseFloat(entradaIncremento.getText());
                            
                            criada = datab.criarContaPoupanca(entradaNome.getText(), numeroConta, saldoConta, incrementoConta);
                            if(criada.equalsIgnoreCase("Conta criada com sucesso")){
                                JOptionPane.showMessageDialog(null, criada, "SUCESSO" ,JOptionPane.INFORMATION_MESSAGE);
                            } else{
                                JOptionPane.showMessageDialog(null, criada, "Erro" ,JOptionPane.ERROR_MESSAGE);
                            }
                            dispose();
                        }catch(NumberFormatException incrementoinvalido){
                            JOptionPane.showMessageDialog(null, "Rendimento inválida", "ERRO" , JOptionPane.ERROR_MESSAGE);
                        }
                    }catch(NumberFormatException saldoinvalido){
                        JOptionPane.showMessageDialog(null, "Saldo inválido", "ERRO" , JOptionPane.ERROR_MESSAGE);
                    }
                }catch(NumberFormatException numinvalido){
                    JOptionPane.showMessageDialog(null, "Número de conta inválido", "ERRO" , JOptionPane.ERROR_MESSAGE);
                }
            } else if (entrada.getSource() == cancelar) {
                dispose();
            }
        }

    }
}


                