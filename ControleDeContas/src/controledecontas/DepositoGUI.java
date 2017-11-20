package controledecontas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Paulo
 */
public class DepositoGUI extends JFrame {

    private JLabel numConta;
    private JTextField entradaNum = new JTextField(10);
    private JLabel deposito;
    private JTextField entradaDeposito = new JTextField(10);
    private JButton ok = new JButton("Ok");
    private JButton cancelar = new JButton("Cancelar");
    private JPanel design = new JPanel();
    private JPanel designentrada1 = new JPanel();
    private JPanel tituloentrada1 = new JPanel();
    private JPanel designentrada2 = new JPanel();
    private JPanel tituloentrada2 = new JPanel();
    private JPanel designchoice = new JPanel();

    public DepositoGUI() {

        super("Deposito");

        designentrada1.setLayout(new FlowLayout());
        tituloentrada1.setLayout(new BoxLayout(tituloentrada1, BoxLayout.Y_AXIS));
        designentrada2.setLayout(new FlowLayout());
        tituloentrada2.setLayout(new BoxLayout(tituloentrada2, BoxLayout.Y_AXIS));
        designchoice.setLayout(new FlowLayout());

        design.setLayout(new BoxLayout(design, BoxLayout.Y_AXIS));

        depositoHandler handler = new depositoHandler();
        JLabel titulo = new JLabel("Deposito");
        design.add(Box.createRigidArea(new Dimension(0,20)));
        design.add(titulo);
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        numConta = new JLabel("Número da conta");
        deposito = new JLabel("Valor do depósito");

        design.add(Box.createRigidArea(new Dimension(0,20)));
        
        tituloentrada1.add(numConta);
        numConta.setAlignmentX(CENTER_ALIGNMENT);
        designentrada1.add(entradaNum);
        tituloentrada1.add(designentrada1);
        entradaNum.addActionListener(handler);
        design.add(tituloentrada1);

        tituloentrada2.add(deposito);
        deposito.setAlignmentX(CENTER_ALIGNMENT);
        designentrada2.add(entradaDeposito);
        tituloentrada2.add(designentrada2);
        entradaDeposito.addActionListener(handler);
        design.add(tituloentrada2);

        designchoice.add(ok);
        ok.addActionListener(handler);
        designchoice.add(cancelar);
        cancelar.addActionListener(handler);
        design.add(designchoice);

        add(design);

    }

    private class depositoHandler implements ActionListener {

        Banco datab = Banco.getInstance();
        String msg;

        @Override
        public void actionPerformed(ActionEvent entrada) {

            int numConta;
            float valorDeposito;

            if (entrada.getSource() == ok) {
                try {
                    numConta = Integer.parseInt(entradaNum.getText());
                    try {
                        valorDeposito = Float.parseFloat(entradaDeposito.getText());

                        msg = datab.deposito(numConta, valorDeposito);
                        JOptionPane.showMessageDialog(null, "Novo saldo: " + msg, "Depósito", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (NumberFormatException depositoInvalido) {
                        JOptionPane.showMessageDialog(null, "Depósito inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException numeroContaInvalido) {
                    JOptionPane.showMessageDialog(null, "Número da conta inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            } else if (entrada.getSource() == cancelar) {
                dispose();
            }
        }

    }

}
