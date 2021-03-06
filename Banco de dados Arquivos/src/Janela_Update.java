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

public class  Janela_Update extends JFrame {
   private final JPanel panel1 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex1 = new JTextField();
   private final JPanel panel2 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex2 = new JTextField();
   private final JPanel panel3 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex3 = new JTextField();
   private final JPanel panel4 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex4 = new JTextField();
   private JButton bts;
   
   public Janela_Update ()  {
      super( "Update de Dados" );
      setLayout( new GridLayout( 2, 1, 10, 10 ) );
      panel1.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Nome completo do Morador" ) );
      panel1.add(tex1);
       panel2.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Campo alterado" ) );
       panel2.add( tex2 );
       panel3.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Novo Valor" ) );
       panel3.add( tex3 );
       panel4.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Tabela" ) );
       panel4.add( tex4 );
      add( panel1 );
      add( panel2 );
      add( panel3 );
      add( panel4 );
      bts = new JButton("Atualizar");
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
                   if("".equals(s1) || "".equals(s2) || "".equals(s3) || "".equals(s4))
                   {JOptionPane.showMessageDialog(null,"Algum campo nao foi preenchido");
                   }
                   else
                    {String campo,tabela,nome,valor;
                     int valor1,check;
                     java.sql.Date valor2 = null;
                     nome = tex1.getText();
                     campo = tex2.getText();
                     tabela = tex4.getText();
                     int predio = BD.get_Int("Predio", tabela, nome);
                     //Compara Tabela
                     if(("Morador" + predio).equals(tabela))
                     {//Compara campo
                        //tipo String
                        if("Nome".equals(campo) ||"Genero".equals(campo))
                        {valor = tex3.getText();
                         int checa = BD.update_Tabela(valor,tabela,campo,nome);
                         if(checa == 0)
                         {JOptionPane.showMessageDialog(null,"Dado Atualizado");
                          dispose();
                         }
                         else
                         {JOptionPane.showMessageDialog(null,"Erro ao Atualizar Valor");
                          dispose();
                         }
                        }
                        else
                        {//Tipo int Idade alterada apenas quando data de nascimento é alterada
                            if("Ano_de_Ingresso".equals(campo) || "Advertencias".equals(campo) )
                            {valor1 = Integer.parseInt(tex3.getText());
                             int checa = BD.update_Tabela(valor1,tabela,campo,nome);
                             if(checa == 0)
                             {JOptionPane.showMessageDialog(null,"Dado Atualizado");
                              dispose();
                              }
                              else
                              {JOptionPane.showMessageDialog(null,"Erro ao Atualizar Valor");
                               dispose();
                              }
                            }
                            else
                            {//Tipo date
                             if("Data_Saida".equals(campo) ||"Previsao_Saida".equals(campo) || "Data_de_Nascimento".equals(campo))
                             {//atualiza data de nascimento e idade
                              if("Data_de_Nascimento".equals(campo))
                              {SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                               nome = tex1.getText();
                               try {valor2 = new java.sql.Date(format.parse(tex3.getText()).getTime());
                                }catch (ParseException ex) {
                                 Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
                                 }
                                Morador m = new Morador("","",valor2,0,valor2);
                                int idade = m.getidade();
                                int checa = BD.update_Tabela(valor2,tabela,campo,nome);
                                if(checa == 0)
                                {JOptionPane.showMessageDialog(null,"Data Atualizado");
                                }
                                else
                                {JOptionPane.showMessageDialog(null,"Erro ao Atualizar Valor");
                                }
                                checa = BD.update_Tabela(idade,tabela,"Idade",nome);
                                if(checa == 0)
                                {JOptionPane.showMessageDialog(null,"Idade Atualizada");
                                 dispose();
                                }
                              }
                              else
                              {SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                               nome = tex1.getText();
                               try {valor2 = new java.sql.Date(format.parse(tex3.getText()).getTime());
                                   } catch (ParseException ex) {
                                     Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
                                     }
                               int checa = BD.update_Tabela(valor2,tabela,campo,nome);
                               if(checa == 0)
                               {JOptionPane.showMessageDialog(null,"Dado Atualizado");
                                dispose();
                               }
                               else
                               {JOptionPane.showMessageDialog(null,"Erro ao Atualizar Valor");
                                dispose();
                               }
                              }
                            }
                            else
                            {JOptionPane.showMessageDialog(null,"Erro Campo não existe");
                            }
                          }
                        }    
                     }
                     else
                     {JOptionPane.showMessageDialog(null,"Erro Tabela não existe ou não pode ser atualizada");
                     }
                    }
                }
            }
    }
   public static void main( String[] args ) {
      Janela_Update j = new Janela_Update();
   }
}