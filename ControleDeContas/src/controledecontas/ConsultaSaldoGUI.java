package controledecontas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Paulo
 */
public class ConsultaSaldoGUI extends JFrame {

    private JLabel consultarSaldo;
    private JTextField numContaSaldo = new JTextField(10);
    private JButton ok = new JButton("Ok");
    private JButton cancelar = new JButton("Cancelar");
    private JPanel main = new JPanel();
    private JPanel estrutura = new JPanel();
    private JPanel designchoice = new JPanel();
    private JPanel entrada = new JPanel();

    public ConsultaSaldoGUI() {
        super("Consulta Saldo");

        estrutura.setLayout(new BoxLayout(estrutura, BoxLayout.Y_AXIS));
        entrada.setLayout(new FlowLayout());
        designchoice.setLayout(new FlowLayout());
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        consultaHandler consultH = new consultaHandler();
        JLabel titulo = new JLabel("Consultar Saldo");
        
        main.add(Box.createRigidArea(new Dimension(0,20)));
        main.add(titulo);
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        consultarSaldo = new JLabel("Número da conta");

        main.add(Box.createRigidArea(new Dimension(0,20)));
        
        estrutura.add(consultarSaldo);
        consultarSaldo.setAlignmentX(CENTER_ALIGNMENT);
        entrada.add(numContaSaldo);
        estrutura.add(entrada);
        numContaSaldo.addActionListener(consultH);
        main.add(estrutura);

        //main.add(Box.createRigidArea(new Dimension(0,10)));
        
        designchoice.add(ok);
        ok.addActionListener(consultH);
        designchoice.add(cancelar);
        cancelar.addActionListener(consultH);
        main.add(designchoice);

        add(main);
    }

    private class consultaHandler implements ActionListener {

        Banco datab = Banco.getInstance();
        String msg;
        int numConta;

        @Override
        public void actionPerformed(ActionEvent entrada) {
            if (entrada.getSource() == ok) {
                try {
                    numConta = Integer.parseInt(numContaSaldo.getText());
                    msg = datab.consultar(numConta);
                    JOptionPane.showMessageDialog(null, "Conta: " + numConta + "\nSaldo: " + msg, "Consulta de Saldo", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (NumberFormatException numeroContaInvalido) {
                    JOptionPane.showMessageDialog(null, "Número de conta inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            } else if (entrada.getSource() == cancelar) {
                dispose();
            }
        }

    }
}
