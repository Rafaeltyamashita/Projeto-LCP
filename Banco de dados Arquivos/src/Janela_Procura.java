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

public class  Janela_Procura extends JFrame {
   private final JPanel panel1 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex1 = new JTextField();
   private final JPanel panel2 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex2 = new JTextField();
   private final JPanel panel3 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex3 = new JTextField();
   private final JPanel panel4 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex4 = new JTextField();
   private JButton bts;
   
   public Janela_Procura ()  {
      super( "Procura" );
      setLayout( new GridLayout( 2, 1, 10, 10 ) );
      panel1.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Valor Comparado" ) );
      panel1.add(tex1);
       panel2.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Nome da Tabela" ) );
       panel2.add( tex2 );
       panel3.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Campo" ) );
       panel3.add( tex3 );
       panel4.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Numero do Predio" ) );
       panel4.add( tex4 );
      add( panel1 );
      add( panel2 );
      add( panel3 );
      add( panel4 );
      bts = new JButton("Pesquisar");
      ButtonHandler handler = new ButtonHandler();
      bts.addActionListener(handler);
      add(bts);
      setSize( 750, 240 );
      setVisible( true ); 
    }
   private class ButtonHandler implements ActionListener
   {        private String s1,s2,s3,s4; //recebe os textos escritos no formulario	
            public void actionPerformed(ActionEvent e)
            { //se botao apertado
                if(e.getSource() == bts)
                {   s1 = tex1.getText();
                    s2 = tex2.getText();
                    s3 = tex3.getText();
                    s4 = tex4.getText();
                   if("".equals(s1) || "".equals(s2) || "".equals(s3) || "".equals(s4) )
                   {JOptionPane.showMessageDialog(null,"Algum campo nao foi preenchido");
                   }
                   else
                    {String campo,tabela,valor;
                     int valor1;
                     java.sql.Date valor2 = null;
                     campo = tex3.getText();
                     tabela = tex2.getText();
                     int predio =  Integer.parseInt(tex4.getText());
                     //Compara Tabela
                     if(("Morador" + predio).equals(tabela))
                     {//se tabela Morador retorna nome das pessoas com o valor igual
                      //Compara campo 
                        //tipo String
                        if("Nome".equals(campo) ||"Genero".equals(campo))
                        {valor = tex1.getText();
                         BD.seleciona_Tabela(valor,tabela,campo);
                         dispose();
                        }
                        else
                        {//Tipo int
                            if("Idade".equals(campo) ||"Predio".equals(campo)|| "Ano_de_Ingresso".equals(campo) || "ID".equals(campo) || "Bloco".equals(campo) || "Apartamento".equals(campo) || "Advertencias".equals(campo) )
                            {valor1 = Integer.parseInt(tex1.getText());
                             BD.seleciona_Tabela(valor1,tabela,campo);
                             dispose();
                            }
                            else
                            {//Tipo date
                             if("Data_Saida".equals(campo) ||"Previsao_Saida".equals(campo) || "Data_de_Nascimento".equals(campo))
                             {SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                              try {valor2 = new java.sql.Date(format.parse(tex1.getText()).getTime());
                                  } catch (ParseException ex) {
                                    Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                              BD.seleciona_Tabela(valor2,tabela,campo);
                              dispose();
                             }
                             else
                             {JOptionPane.showMessageDialog(null,"Erro Campo não existe");
                             }
                            }
                        }    
                     }
                     else
                     { //Para tabelas diferente de Morador o retorno é o ID dos apartamentos,blocos,camas ou predio com valor igual
                        if(("Predio").equals(tabela))
                        {//Tipo int
                            if("ID".equals(campo) ||"N_Ocupantes".equals(campo))
                            {valor1 = Integer.parseInt(tex1.getText());
                             BD.seleciona_Tabela2(valor1,tabela,campo);
                             dispose();
                            }
                            else
                            {JOptionPane.showMessageDialog(null,"Erro Campo não existe");
                            }
                        }
                        else
                        {  if(("Bloco"+predio).equals(tabela))
                           {//Tipo int
                            if("ID".equals(campo) ||"N_Ocupantes".equals(campo))
                            {valor1 = Integer.parseInt(tex1.getText());
                             BD.seleciona_Tabela2(valor1,tabela,campo);
                             dispose();
                            }
                            else
                            {JOptionPane.showMessageDialog(null,"Erro Campo não existe");
                            }
                           }
                           else
                            {   if(("Apartamento"+predio).equals(tabela))
                                {   //Tipo int
                                    if("ID".equals(campo) ||"N_Ocupantes".equals(campo))
                                    {valor1 = Integer.parseInt(tex1.getText());
                                     BD.seleciona_Tabela2(valor1,tabela,campo);
                                     dispose();
                                    }
                                    else
                                    {//tipo String
                                     if("Genero".equals(campo) ||"Nome_Arquivo".equals(campo))
                                     {valor = tex1.getText();
                                      BD.seleciona_Tabela2(valor,tabela,campo);
                                      dispose();
                                     }
                                     else
                                     {JOptionPane.showMessageDialog(null,"Erro Campo não existe");
                                     }
                                    }    
                                }
                                else
                                {   if(("Cama"+predio).equals(tabela))
                                    {//Tipo int
                                     if("ID".equals(campo) ||"Status".equals(campo))
                                     {valor1 = Integer.parseInt(tex1.getText());
                                      BD.seleciona_Tabela2(valor1,tabela,campo);
                                      dispose();
                                     }
                                     else
                                     {  //Tipo date
                                        if("Data".equals(campo))
                                        {SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                         try {valor2 = new java.sql.Date(format.parse(tex1.getText()).getTime());
                                         }catch (ParseException ex) {
                                         Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
                                         }
                                         BD.seleciona_Tabela2(valor2,tabela,campo);
                                         dispose();
                                        }
                                        else
                                        {JOptionPane.showMessageDialog(null,"Erro Campo não existe");
                                        }
                                     }
                                         
                                    }
                                    else
                                    {   if(("Ex_Morador").equals(tabela))
                                        {//se tabela Ex_Morador retorna nome das pessoas com o valor igual
                                         //Compara campo 
                                           //tipo String
                                           if("Nome".equals(campo) ||"Genero".equals(campo))
                                           {valor = tex1.getText();
                                            BD.seleciona_Tabela(valor,tabela,campo);
                                            dispose();
                                           }
                                           else
                                           {//Tipo int
                                               if("Idade".equals(campo) ||"Predio".equals(campo)|| "Ano_de_Ingresso".equals(campo) || "ID".equals(campo) || "Bloco".equals(campo) || "Apartamento".equals(campo) || "Advertencias".equals(campo) )
                                               {valor1 = Integer.parseInt(tex1.getText());
                                                BD.seleciona_Tabela(valor1,tabela,campo);
                                                dispose();
                                               }
                                               else
                                               {//Tipo date
                                                if("Data_Saida".equals(campo) ||"Previsao_Saida".equals(campo) || "Data_de_Nascimento".equals(campo))
                                                {SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                                 try {valor2 = new java.sql.Date(format.parse(tex1.getText()).getTime());
                                                     } catch (ParseException ex) {
                                                       Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
                                                       }
                                                 BD.seleciona_Tabela(valor2,tabela,campo);
                                                 dispose();
                                                }
                                                else
                                                {JOptionPane.showMessageDialog(null,"Erro Campo não existe");
                                                }
                                               }
                                           }    
                                        }
                                        else
                                        {JOptionPane.showMessageDialog(null,"Erro Tabela não existe");
                                        }
                                    }
                                            
                                }
                            }
                        }
                     }
                    }
                }
            }
        }
     public static void main( String[] args ) {
     Janela_Procura j = new Janela_Procura();
    }
}
