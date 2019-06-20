import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class Janela extends JFrame {
private JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    /**
     * Creates new form Janela
     */
     //Linha INinTEGER,Nome VARCHAR(30),Genero Varchar(10),Data_de_Nascimento 
    //DATE,Ano_de_Ingresso INTEGER,Previsao_Saida DATE,Data_Saida DATE,Predio INTEGER,Bloco Integer,Apartamento Integer,Cama Integer)
    public Janela() {
        super("Condominio");
        
    		setLayout(new FlowLayout( ));
                tf1 = new JTextField("Nome",4);
		tf1.setEditable(false);
		add(tf1);
		tf2 = new JTextField(30);
    		add(tf2);
                tf3 = new JTextField("Genero",6);
		tf3.setEditable(false);
                add(tf3);
                tf4 = new JTextField(30);
    		add(tf4);
		tf5 = new JTextField("Data de Nascimento",11);
		tf5.setEditable(false);
                add(tf5);
                tf6 = new JTextField(20);
    		add(tf6);
                

		TextFieldHandler handler = new TextFieldHandler();
                tf2.addActionListener(handler);
                tf4.addActionListener(handler);
                tf6.addActionListener(handler);

    }
    private class TextFieldHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String string="";
			if(e.getSource()==tf2)
				string = String.format("JTextField 02: %s",e.getActionCommand());
                        else if(e.getSource()==tf4)
				string = String.format("JTextField 04: %s",e.getActionCommand());
                             else 
                             if(e.getSource()==tf6)
                             {string = String.format("JTextField 06: %s",e.getActionCommand());
                             }
                JOptionPane.showMessageDialog(null,string);
		}
	}
    public static void main(String args[]) {
    Janela k =  new Janela();
                k.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		k.setSize(480,480);
		k.setVisible(true);
    };
}