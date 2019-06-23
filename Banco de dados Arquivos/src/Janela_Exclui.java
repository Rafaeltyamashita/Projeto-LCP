import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class  Janela_Exclui extends JFrame {
   private final JPanel panel1 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex1 = new JTextField();
   private final JPanel panel2 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex2 = new JTextField();
   private JButton bts;
   
   public Janela_Exclui ()  {
      super( "Exclui Tabela" );
      setLayout( new GridLayout( 2, 1, 10, 10 ) );
      panel1.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Nome" ) );
      panel1.add(tex1);
      panel2.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Tabela" ) );
      panel2.add(tex2);
      add( panel1 );
      add( panel2 );
      bts = new JButton("Excluir");
      ButtonHandler handler = new ButtonHandler();
      bts.addActionListener(handler);
      add(bts);
      setSize( 300, 240 );
      setVisible( true ); 
    }
   private class ButtonHandler implements ActionListener
   {        private String s1,s2; //recebe os textos escritos no formulario	
            public void actionPerformed(ActionEvent e)
            { //se botao apertado
                if(e.getSource() == bts)
                {  s1 = tex1.getText();
                   s2 = tex2.getText();
                   if("".equals(s1) || "".equals(s2))
                   {JOptionPane.showMessageDialog(null,"Algum campo nao foi preenchido");
                   }
                   else
                    {String nome = tex1.getText();
                     String tabela = tex2.getText();
                     int retorno = BD.exclui_Morador(nome,tabela);
                     if(retorno == 2)
                     {JOptionPane.showMessageDialog(null,"Excluido com sucesso ");
                     }
                     else
                     {JOptionPane.showMessageDialog(null,"Erro Morador não existe na tabela ");
                     }
                     dispose();
                    }
                }
            }
    }
   public static void main( String[] args ) {
      Janela_Exclui j = new Janela_Exclui();
   }
}