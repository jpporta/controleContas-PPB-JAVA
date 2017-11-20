package controledecontas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Paulo
 */
public class ContaSimplesGUI extends JFrame {

    private JButton criar;
    private JLabel nome;
    private JTextField entradaNome = new JTextField(10);
    private JLabel numero;
    private JTextField entradaNumero = new JTextField(10);
    private JLabel saldo;
    private JTextField entradaSaldo = new JTextField(10);
    private JPanel principal = new JPanel();
    private JPanel horznome = new JPanel();
    private JPanel box1 = new JPanel();
    private JPanel horznumero = new JPanel();
    private JPanel box2 = new JPanel();
    private JPanel horzsaldo = new JPanel();
    private JPanel box3 = new JPanel();
    private JPanel horzchoice = new JPanel();
    private JButton ok = new JButton("Ok");
    private JButton cancelar = new JButton("Cancelar");

    public ContaSimplesGUI() {

        super("Criar Conta Simples");
        box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS));
        box2.setLayout(new BoxLayout(box2, BoxLayout.Y_AXIS));
        box3.setLayout(new BoxLayout(box3, BoxLayout.Y_AXIS));
        horznome.setLayout(new FlowLayout());
        horznumero.setLayout(new FlowLayout());
        horzsaldo.setLayout(new FlowLayout());
        horzchoice.setLayout(new FlowLayout());

        principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));

        criarContaSimplesHandler handlerData = new criarContaSimplesHandler();

        JLabel titulo = new JLabel("Conta Simples");
        principal.add(Box.createRigidArea(new Dimension(0,20)));
        principal.add(titulo);
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        nome = new JLabel("Nome");
        numero = new JLabel("Número");
        saldo = new JLabel("Saldo");

        principal.add(Box.createRigidArea(new Dimension(0,20)));

        box1.add(nome);
        nome.setAlignmentX(CENTER_ALIGNMENT);
        horznome.add(entradaNome);
        box1.add(horznome);
        entradaNome.addActionListener(handlerData);
        principal.add(box1);

        box2.add(numero);
        numero.setAlignmentX(CENTER_ALIGNMENT);
        horznumero.add(entradaNumero);
        box2.add(horznumero);
        entradaNumero.addActionListener(handlerData);
        principal.add(box2);

        box3.add(saldo);
        saldo.setAlignmentX(CENTER_ALIGNMENT);
        horzsaldo.add(entradaSaldo);
        box3.add(horzsaldo);
        entradaSaldo.addActionListener(handlerData);
        principal.add(box3);

        horzchoice.add(ok);
        ok.addActionListener(handlerData);
        horzchoice.add(cancelar);
        cancelar.addActionListener(handlerData);
        principal.add(horzchoice);

        add(principal);
    }

    private class criarContaSimplesHandler implements ActionListener {

        Banco datab = Banco.getInstance();
        String criada;
        
        @Override
        public void actionPerformed(ActionEvent entrada) {

            int numeroConta;
            float saldoConta;
            if (entrada.getSource() == ok) {
                try{
                    numeroConta = Integer.parseInt(entradaNumero.getText());
                    try{
                        saldoConta = Float.parseFloat(entradaSaldo.getText());
                        criada = datab.criarContaSimples(entradaNome.getText(), numeroConta, saldoConta);
                        if(criada.equals("Conta criada com sucesso")){
                            JOptionPane.showMessageDialog(null, criada, "SUCESSO" ,JOptionPane.INFORMATION_MESSAGE);
                        } else{
                            JOptionPane.showMessageDialog(null, criada, "Erro" ,JOptionPane.ERROR_MESSAGE);
                        }
                        dispose();
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