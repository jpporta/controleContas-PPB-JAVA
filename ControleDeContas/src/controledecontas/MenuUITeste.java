package controledecontas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Paulo
 */
public class MenuUITeste extends JFrame {

    private JButton criarConta;     //Botão para Criar Contas
    private JButton consultarSaldo; //Botão para consultar saldo
    private JButton sacar;          //Botão para Saque
    private JButton depositar;      //Botão para Depósito
    private JButton virarMes;
    private JButton Sair;           //Botão para sair do programa
    private JPanel menu = new JPanel();
    private JPanel box1 = new JPanel();
    private JPanel box2 = new JPanel();
    private JPanel box3 = new JPanel();
    private JPanel struct1 = new JPanel();
    private JPanel struct2 = new JPanel();
    private JPanel struct3 = new JPanel();

    //Construtor LabelFrame adiciona Jlabels a JFrame
    public MenuUITeste() {
        super("PJ Banks");                  //Configura o texto da barra de título do JFrame na String Especificada
        
        box1.setLayout(new BoxLayout(box1, BoxLayout.Y_AXIS)); 
        box2.setLayout(new BoxLayout(box2, BoxLayout.Y_AXIS)); 
        box3.setLayout(new BoxLayout(box3, BoxLayout.Y_AXIS)); 
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        struct1.setLayout(new FlowLayout());
        struct2.setLayout(new FlowLayout());
        struct3.setLayout(new FlowLayout());
        //setLayout(new FlowLayout());

        HandlerMenu hmenu = new HandlerMenu();
        
        JLabel titulo = new JLabel("MENU");
        menu.add(Box.createRigidArea(new Dimension(0,10)));
        menu.add(titulo);
        titulo.setAlignmentX(CENTER_ALIGNMENT);
        
        criarConta = new JButton("Criar conta");
        consultarSaldo = new JButton("Consulta Saldo");
        sacar = new JButton("Saque");
        depositar = new JButton("Depósito");
        virarMes = new JButton("Virar Mês");
        Sair = new JButton("Sair");

        menu.add(Box.createRigidArea(new Dimension(0,20)));

        //--------------------------------------------

        criarConta.addActionListener(hmenu);
        struct1.add(criarConta);

        consultarSaldo.addActionListener(hmenu);
        struct1.add(consultarSaldo);
        box1.add(struct1);

        //--------------------------------------------
        
        sacar.addActionListener(hmenu);
        struct2.add(sacar);

        depositar.addActionListener(hmenu);
        struct2.add(depositar);
        box2.add(struct2);
        
        //--------------------------------------------
        
        virarMes.addActionListener(hmenu);
        struct3.add(virarMes);

        Sair.addActionListener(hmenu);
        struct3.add(Sair);
        box3.add(struct3);
        
        //--------------------------------------------
        
        criarConta.setPreferredSize(consultarSaldo.getPreferredSize());
        sacar.setPreferredSize(consultarSaldo.getPreferredSize());
        depositar.setPreferredSize(consultarSaldo.getPreferredSize());
        virarMes.setPreferredSize(consultarSaldo.getPreferredSize());
        Sair.setPreferredSize(consultarSaldo.getPreferredSize());
        
        //--------------------------------------------
        
        menu.add(box1);
        menu.add(box2);
        menu.add(box3);
        
        add(menu);

    }   //Fim do construtor MenuUITeste

    private class HandlerMenu implements ActionListener {

        Banco datab = Banco.getInstance();

        @Override
        public void actionPerformed(ActionEvent evento) {
            if (evento.getSource() == criarConta) {
                
                CriarContaGUI criaContas = new CriarContaGUI();
                criaContas.setSize(250, 300);
                criaContas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                criaContas.setVisible(true);
                
            } else if (evento.getSource() == consultarSaldo) {
                
                ConsultaSaldoGUI consultaSaldo = new ConsultaSaldoGUI();
                consultaSaldo.setSize(250, 300);
                consultaSaldo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                consultaSaldo.setVisible(true);
                
            } else if (evento.getSource() == sacar) {
                
                SaqueGUI saque = new SaqueGUI();
                saque.setSize(250, 300);
                saque.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                saque.setVisible(true);
                
            } else if (evento.getSource() == depositar) {
                
                DepositoGUI deposito = new DepositoGUI();
                deposito.setSize(250, 300);
                deposito.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                deposito.setVisible(true);
                
            } else if (evento.getSource() == virarMes) {
                
                datab.incrementar();
                
            } else if (evento.getSource() == Sair) {
                
                datab.escrevaArquivo();
                dispose();
                
            }

        }

    }

}   //Fim da classe MenuUITeste
