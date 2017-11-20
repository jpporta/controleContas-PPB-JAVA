package controledecontas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Paulo
 */
public class ContaEspecialGUI extends JFrame {

    private JButton criar;
    private JLabel nome;
    private JTextField entradaNome = new JTextField(10);
    private JLabel numero;
    private JTextField entradaNumero = new JTextField(10);
    private JLabel saldo;
    private JTextField entradaSaldo = new JTextField(10);
    private JLabel limite;
    private JTextField entradaLimite = new JTextField(10);
    private JPanel principal = new JPanel();
    private JPanel horznome = new JPanel();
    private JPanel box1 = new JPanel();
    private JPanel horznumero = new JPanel();
    private JPanel box2 = new JPanel();
    private JPanel horzsaldo = new JPanel();
    private JPanel box3 = new JPanel();
    private JPanel horzlimite = new JPanel();
    private JPanel box4 = new JPanel();
    private JPanel horzchoice = new JPanel();
    private JButton ok = new JButton("Ok");
    private JButton cancelar = new JButton("Cancelar");

    public ContaEspecialGUI() {

        super("Criar Conta Especial");
        box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS));
        box2.setLayout(new BoxLayout(box2, BoxLayout.Y_AXIS));
        box3.setLayout(new BoxLayout(box3, BoxLayout.Y_AXIS));
        box4.setLayout(new BoxLayout(box4, BoxLayout.Y_AXIS));
        horznome.setLayout(new FlowLayout());
        horznumero.setLayout(new FlowLayout());
        horzsaldo.setLayout(new FlowLayout());
        horzlimite.setLayout(new FlowLayout());
        horzchoice.setLayout(new FlowLayout());

        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        criarContaEspecialHandler handlerCriar = new criarContaEspecialHandler();

        JLabel titulo = new JLabel("Conta Especial");
        principal.add(Box.createRigidArea(new Dimension(0,10)));
        principal.add(titulo);
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        nome = new JLabel("Nome");
        numero = new JLabel("Número");
        saldo = new JLabel("Saldo");
        limite = new JLabel("Limite");

        principal.add(Box.createRigidArea(new Dimension(0,10)));

        box1.add(nome);
        nome.setAlignmentX(CENTER_ALIGNMENT);
        horznome.add(entradaNome);
        box1.add(horznome);
        entradaNome.addActionListener(handlerCriar);
        principal.add(box1);

        box2.add(numero);
        numero.setAlignmentX(CENTER_ALIGNMENT);
        horznumero.add(entradaNumero);
        box2.add(horznumero);
        entradaNumero.addActionListener(handlerCriar);
        principal.add(box2);

        box3.add(saldo);
        saldo.setAlignmentX(CENTER_ALIGNMENT);
        horzsaldo.add(entradaSaldo);
        box3.add(horzsaldo);
        entradaSaldo.addActionListener(handlerCriar);
        principal.add(box3);

        box4.add(limite);
        limite.setAlignmentX(CENTER_ALIGNMENT);
        horzlimite.add(entradaLimite);
        box4.add(horzlimite);
        entradaLimite.addActionListener(handlerCriar);
        principal.add(box4);

        horzchoice.add(ok);
        ok.addActionListener(handlerCriar);
        horzchoice.add(cancelar);
        cancelar.addActionListener(handlerCriar);
        principal.add(horzchoice);

        add(principal);
    }

    private class criarContaEspecialHandler implements ActionListener {

        Banco datab = Banco.getInstance();

        @Override
        public void actionPerformed(ActionEvent entrada) {
            int numeroConta;
            float saldoConta, limiteConta;
            
            if (entrada.getSource() == ok) {
                try{
                    numeroConta = Integer.parseInt(entradaNumero.getText());
                    try{
                        saldoConta = Float.parseFloat(entradaSaldo.getText());
                        try{
                            limiteConta = Float.parseFloat(entradaLimite.getText());
                            
                            datab.criarContaEspecial(entradaNome.getText(), numeroConta, saldoConta, limiteConta);
                            dispose();
                        }catch(NumberFormatException limiteinvalido){
                            JOptionPane.showMessageDialog(null, "Limite inválido", "ERRO" , JOptionPane.ERROR_MESSAGE);
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

