package controledecontas;

import javax.swing.JFrame;

public class ControleDeContas {

    public static void main(String[] args) {
        MenuUITeste labelFrame = new MenuUITeste();                 //Cria o MENU UI
        Banco database = Banco.getInstance();                       //Linka o database
        database.lerArquivo();                                      //Dá load no database
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Programa deve terminar quando o usuário clicar no botão Close da janela
        labelFrame.setSize(250, 350);                               //Configura o tamanho do frame
        labelFrame.setVisible(true);                                //exibe o frame
    }
}
