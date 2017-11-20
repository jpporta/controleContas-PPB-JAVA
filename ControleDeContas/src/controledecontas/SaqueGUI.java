package controledecontas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Paulo
 */
public class SaqueGUI extends JFrame {

    private JLabel numConta;
    private JTextField entradaNum = new JTextField(10);
    private JLabel saque;
    private JTextField entradaSaque = new JTextField(10);
    private JButton ok = new JButton("Ok");
    private JButton cancelar = new JButton("Cancelar");
    private JPanel design = new JPanel();
    private JPanel designentrada1 = new JPanel();
    private JPanel tituloentrada1 = new JPanel();
    private JPanel designentrada2 = new JPanel();
    private JPanel tituloentrada2 = new JPanel();
    private JPanel designchoice = new JPanel();

    public SaqueGUI() {

        super("Saque");

        designentrada1.setLayout(new FlowLayout());
        tituloentrada1.setLayout(new BoxLayout(tituloentrada1, BoxLayout.Y_AXIS));
        designentrada2.setLayout(new FlowLayout());
        tituloentrada2.setLayout(new BoxLayout(tituloentrada2, BoxLayout.Y_AXIS));
        designchoice.setLayout(new FlowLayout());

        design.setLayout(new BoxLayout(design, BoxLayout.Y_AXIS));

        saqueHandler handler = new saqueHandler();
        JLabel titulo = new JLabel("Saque");
        design.add(Box.createRigidArea(new Dimension(0,20)));
        design.add(titulo);
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        numConta = new JLabel("Número da conta");
        saque = new JLabel("Valor do saque");

        design.add(Box.createRigidArea(new Dimension(0,20)));

        tituloentrada1.add(numConta);
        numConta.setAlignmentX(CENTER_ALIGNMENT);
        designentrada1.add(entradaNum);
        tituloentrada1.add(designentrada1);
        entradaNum.addActionListener(handler);
        design.add(tituloentrada1);

        tituloentrada2.add(saque);
        saque.setAlignmentX(CENTER_ALIGNMENT);
        designentrada2.add(entradaSaque);
        tituloentrada2.add(designentrada2);
        entradaSaque.addActionListener(handler);
        design.add(tituloentrada2);

        designchoice.add(ok);
        ok.addActionListener(handler);
        designchoice.add(cancelar);
        cancelar.addActionListener(handler);
        design.add(designchoice);

        add(design);

    }

    private class saqueHandler implements ActionListener {

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
                        valorDeposito = Float.parseFloat(entradaSaque.getText());

                        msg = datab.saque(numConta, valorDeposito);
                        JOptionPane.showMessageDialog(null, "Novo saldo: " + msg, "Saque", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    } catch (NumberFormatException saqueInvalido) {
                        JOptionPane.showMessageDialog(null, "Saque inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
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
