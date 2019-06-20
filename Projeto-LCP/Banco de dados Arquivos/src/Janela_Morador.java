import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class  Janela_Morador extends JFrame {
   private final JPanel panel1 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex1 = new JTextField();
   private final JPanel panel2 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex2 = new JTextField();
   private final JPanel panel3 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex3 = new JTextField();
   private final JPanel panel4 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex4 = new JTextField();
   private final JPanel panel5 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex5 = new JTextField();
   private JButton bts;
   private boolean inserido = true;
   
   public Janela_Morador ()  {
      super( "Formulario" );
      setLayout( new GridLayout( 2, 1, 10, 10 ) );
      panel1.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Nome" ) );
      panel1.add(tex1);
       panel2.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Genero" ) );
       panel2.add( tex2 );
       panel3.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Data de Nascimento" ) );
       panel3.add( tex3 );
       panel4.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Ano de Ingresso" ) );
       panel4.add( tex4 );
       panel5.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Previsão de Saída" ) );
       panel5.add( tex5 );
      add( panel1 );
      add( panel2 );
      add( panel3 );
      add( panel4 );
      add( panel5 );
      bts = new JButton("Inserir");
      ButtonHandler handler = new ButtonHandler();
      bts.addActionListener(handler);
      add(bts);
      setSize( 450, 210 );
      setVisible( true ); 
    }
   private class ButtonHandler implements ActionListener{
	private String s1,s2,s3,s4,s5;	
                    public void actionPerformed(ActionEvent e){
                    //se botao apertado
                    if(e.getSource() == bts){
                   try{ s1 = tex1.getText();
                    s2 = tex2.getText();
                    s3 = tex3.getText();
                    s4 = tex4.getText();
                    s5 = tex5.getText();
                   }catch(NullPointerException a)
                   {System.out.println("Conferir se todos os campos foram preenchidos");
                   }
                   if("".equals(s1) || "".equals(s2) || "".equals(s3)  || "".equals(s4) || "".equals(s5))
                   {JOptionPane.showMessageDialog(null,"Algum campo nao foi preenchido");
                   }
                   else
                   {BD morador = new BD(); 
                       
                   }
		}
    }
}
   public void setinserido(boolean b){
       inserido = b;
   }
   public boolean getinserido(){
       return inserido;
   }
   public static void main( String[] args ) {
      Janela_Morador j = new Janela_Morador();
      j.getinserido();
   }
}