import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class  Janela_Insere extends JFrame {
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
   private final JPanel panel6 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex6 = new JTextField();
   private final JPanel panel7 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex7 = new JTextField();
   private final JPanel panel8 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex8 = new JTextField();
   private final JPanel panel9 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex9 = new JTextField();
   private JButton bts;
   private boolean inserido = true;
   
   public Janela_Insere ()  {
      super( "Formulario" );
      setLayout( new GridLayout( 2, 1, 10, 10 ) );
      panel1.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Nome Completo" ) );
      panel1.add(tex1);
       panel2.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Genero" ) );
       panel2.add( tex2 );
       panel3.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Data de Nascimento" ) );
       panel3.add( tex3 );
       panel4.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Ano de Ingresso" ) );
       panel4.add( tex4 );
       panel5.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Previsão de Saída" ) );
       panel5.add( tex5 );
       panel6.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Predio" ) );
       panel6.add( tex6 );
       panel7.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Bloco" ) );
       panel7.add( tex7 );
       panel8.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Apartamento" ) );
       panel8.add( tex8 );
       panel9.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Tabela" ) );
       panel9.add( tex9 ); 
      add( panel1 );
      add( panel2 );
      add( panel3 );
      add( panel4 );
      add( panel5 );
      add( panel6 );
      add( panel7 );
      add( panel8 );
      add( panel9 );
      bts = new JButton("Inserir");
      ButtonHandler handler = new ButtonHandler();
      bts.addActionListener(handler);
      add(bts);
      setSize( 750, 240 );
      setVisible( true ); 
    }
   private class ButtonHandler implements ActionListener{
	private String s1,s2,s3,s4,s5,s6,s7,s8,s9; //recebe os textos escritos no formulario	
                    public void actionPerformed(ActionEvent e){
                    //se botao apertado
                    if(e.getSource() == bts){
                    s1 = tex1.getText();
                    s2 = tex2.getText();
                    s3 = tex3.getText();
                    s4 = tex4.getText();
                    s5 = tex5.getText();
                    s6 = tex6.getText();
                    s7 = tex7.getText();
                    s8 = tex8.getText();
                    s9 = tex9.getText();
                   if("".equals(s1) || "".equals(s2) || "".equals(s3)  || "".equals(s4) || "".equals(s5) || "".equals(s6)  || "".equals(s7) || "".equals(s8) || "".equals(s9))
                   {JOptionPane.showMessageDialog(null,"Algum campo nao foi preenchido");
                   }
                   else
                    {  // dispose();
                        int ID,predio,bloco,apartamento,ano;
                        String Tabela = tex9.getText();
                        predio = Integer.parseInt(tex6.getText());
                        int num_p = BD.get_Int("N_Ocupantes", Tabela, predio);
                        //checa se predio esta cheio
                        if(num_p < 48)
                        {   bloco = Integer.parseInt(tex7.getText());
                            int ID_Bloco = (predio * 10) + bloco;
                            int num_b = BD.get_Int("N_Ocupantes", Tabela,ID_Bloco);
                            //checa se bloco esta cheio
                            if(num_b < 12)
                            {   apartamento = Integer.parseInt(tex8.getText());
                                ID = (predio * 100) + (bloco *10) + apartamento;
                                int num_a = BD.get_Int("N_Ocupantes", Tabela, ID);
                                //Checa se apartamento esta cheio
                                if(num_a < 3)
                                {   String genero;
                                    genero = tex2.getText();
                                    String comp = BD.get_String("Genero", Tabela, ID);
                                    //checa se genero do apartamento corresponde ao informado
                                    if(comp.equals(genero))   
                                    {   int ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 1;
                                        java.sql.Date cama1 = BD.get_Date("Data", Tabela, ID_Cama);//cama 1
                                        ID_Cama = ID_Cama + 1;
                                        java.sql.Date cama2 = BD.get_Date("Data", Tabela, ID_Cama);// cama 2
                                        ID_Cama = ID_Cama + 1;
                                        java.sql.Date cama3 = BD.get_Date("Data", Tabela, ID_Cama);// cama 3
                                        //decide qual é a cama a mais tempo desocupada
                                        int antiga; 
                                        if(cama1.compareTo(cama2) <= 0)
                                        {if(cama1.compareTo(cama3) <= 0)
                                         {antiga = 1;  
                                           ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 1;
                                         }
                                         else
                                         {antiga  = 3;
                                          ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 3;
                                         }
                                        }
                                        else
                                        { if(cama2.compareTo(cama3) <= 0)
                                          {antiga = 2;
                                           ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 2;
                                          }
                                          else
                                          {antiga = 3;   
                                           ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 3;
                                          }
                                        }
                                        int cmp = BD.get_Int("Status", Tabela, ID_Cama);
                                        if(cmp == 1)
                                        {
                                        }
                                        else
                                        {switch(antiga)
                                         {case 1:
                                          if(cama2.compareTo(cama3) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 2;
                                           cmp = BD.get_Int("Status", Tabela, ID_Cama);
                                           if(cmp == 1)
                                           {
                                           }
                                           else
                                           {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 2;
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 3;
                                           cmp = BD.get_Int("Status", Tabela, ID_Cama);
                                           if(cmp == 1)
                                           {
                                           }
                                           else
                                           {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 2;
                                           }
                                          }
                                          break;
                                          case 2:
                                          break;
                                          case 3:
                                          break;
                                         }
                                        }
                                        int retorno;
                                        String nome,temp;
                                         java.sql.Date data_nascimento = null,previsao_saida = null;
                                         ano = Integer.parseInt(tex4.getText());
                                         nome = tex1.getText();
                                         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                         try {data_nascimento = new java.sql.Date(format.parse(tex3.getText()).getTime());
                                             } catch (ParseException ex) {
                                                Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                         try {
                                            previsao_saida = new java.sql.Date(format.parse(tex5.getText()).getTime());
                                            } catch (ParseException ex) {
                                                Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                         Morador m1 = new Morador(nome,genero,data_nascimento,ano,previsao_saida);
                                         retorno = BD.insere(m1, ID,Tabela); //tratamento de erro para caso inserção não ocorra
                                         if(retorno == 1)
                                         {JOptionPane.showMessageDialog(null,"Erro ao inserir valor");
                                           setinserido(false);
                                         }
                                         else
                                         {setinserido(true);
                                         }
                                         retorno = BD.update_Tabela(predio, Tabela, "PREDIO", nome);
                                         if(retorno == 1)
                                         {JOptionPane.showMessageDialog(null,"Erro ao inserir valor");
                                          setinserido(false);
                                         }
                                         else
                                         {setinserido(true);
                                         }
                                         retorno = BD.update_Tabela(bloco, Tabela, "BLOCO", nome);
                                         if(retorno == 1)
                                         {JOptionPane.showMessageDialog(null,"Erro ao inserir valor");
                                          setinserido(false);
                                         }
                                         else
                                         {setinserido(true);
                                         }
                                         retorno = BD.update_Tabela(apartamento, Tabela, "APARTAMENTO", nome);
                                         if(retorno == 1)
                                         {JOptionPane.showMessageDialog(null,"Erro ao inserir valor");
                                          setinserido(false);
                                         }
                                         else
                                         {setinserido(true);
                                         }
                                         boolean teste = getinserido();
                                         if(teste)
                                         {JOptionPane.showMessageDialog(null,"Morador Inserido \n");              
                                         }
                                         else
                                         {JOptionPane.showMessageDialog(null,"Erro nao foi possivel inserir \n");
                                         }
                                    }
                                    else
                                    {JOptionPane.showMessageDialog(null,"Erro Genero informado não corresponde ao do apartamento");
                                    }
                                }
                                else
                                {JOptionPane.showMessageDialog(null,"Erro Apartamento Lotado");
                                }
                            }
                            else
                            {JOptionPane.showMessageDialog(null,"Erro Bloco Lotado");
                            }
                       }
                       else
                       {JOptionPane.showMessageDialog(null,"Erro Predio Lotado");
                       }  
                       dispose();
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
      Janela_Insere j = new Janela_Insere();
      j.getinserido();
   }
}