package controledecontas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Paulo
 */
public class CriarContaGUI extends JFrame {

    private JComboBox tiposConta;
    private String[] tipos
            = {"Conta Simples", "Conta Especial", "Conta Poupança"};
    private JButton tituloContas;
    private JButton ok = new JButton("Ok");
    private JButton cancelar = new JButton("Cancelar");
    private JPanel painelOkCancelar = new JPanel();
    private JPanel painelPrincipal = new JPanel();
    private JPanel dropdown = new JPanel();

    public CriarContaGUI() {
        super("Criar Contas");
        painelOkCancelar.setLayout(new FlowLayout());
        dropdown.setLayout(new FlowLayout());
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));

        CriaHandler hCria = new CriaHandler();
        JLabel titulo = new JLabel("Selecione o tipo de conta");
        
        painelPrincipal.add(Box.createRigidArea(new Dimension(0,20)));
        painelPrincipal.add(titulo);
        titulo.setAlignmentX(CENTER_ALIGNMENT);

        painelPrincipal.add(Box.createRigidArea(new Dimension(0,20)));
        tiposConta = new JComboBox(tipos);
        tiposConta.setMaximumRowCount(3);
        dropdown.add(tiposConta);
        painelPrincipal.add(dropdown);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0,20)));

        tituloContas = new JButton("Criar");
        tituloContas.addActionListener(hCria);

        painelOkCancelar.add(tituloContas);
        painelOkCancelar.add(cancelar);
        cancelar.addActionListener(hCria);
        painelPrincipal.add(painelOkCancelar);

        add(painelPrincipal);
    }

    private class CriaHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == tituloContas) {
                if ("Conta Simples".equals(tipos[tiposConta.getSelectedIndex()])) {
                    ContaSimplesGUI criaContaSimples = new ContaSimplesGUI();
                    criaContaSimples.setSize(250, 300);
                    criaContaSimples.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    criaContaSimples.setVisible(true);
                    dispose();

                } else if ("Conta Especial".equals(tipos[tiposConta.getSelectedIndex()])) {
                    ContaEspecialGUI criaContaEspecial = new ContaEspecialGUI();
                    criaContaEspecial.setSize(250, 300);
                    criaContaEspecial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    criaContaEspecial.setVisible(true);
                    dispose();
                } else if ("Conta Poupança".equals(tipos[tiposConta.getSelectedIndex()])) {
                    ContaPoupancaGUI criaContaPoupanca = new ContaPoupancaGUI();
                    criaContaPoupanca.setSize(250, 300);
                    criaContaPoupanca.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    criaContaPoupanca.setVisible(true);
                    dispose();
                }
            } else if (evento.getSource() == cancelar) {
                dispose();
            }

        }

    }
}
