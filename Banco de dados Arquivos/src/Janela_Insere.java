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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
      super( "Formulario " );
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
                    {   int ID,predio,bloco,apartamento,ano;
                        String Tabela = tex9.getText();
                        predio = Integer.parseInt(tex6.getText());
                        //checa se Campo Tabela esta correto
                    if(Tabela.equals("Morador" + predio))
                    {   int num_p = BD.get_Int("N_Ocupantes", "Predio",predio);
                        //checa se predio esta cheio
                        if(num_p < 48)
                        {   bloco = Integer.parseInt(tex7.getText());
                            int ID_Bloco = (predio * 10) + bloco;
                            int num_b = BD.get_Int("N_Ocupantes", "Bloco"+ predio,ID_Bloco);
                            //checa se bloco esta cheio
                            if(num_b < 12)
                            {   apartamento = Integer.parseInt(tex8.getText());
                                int ID_apt = (predio * 100) + (bloco *10) + apartamento;
                                int num_a = BD.get_Int("N_Ocupantes", "Apartamento" + predio, ID_apt);
                                //Checa se apartamento esta cheio
                                if(num_a < 3)
                                {   String genero;
                                    genero = tex2.getText();
                                    String comp = BD.get_String("Genero", "Apartamento" + predio, ID_apt);
                                    //checa se genero do apartamento corresponde ao informado
                                    //pares Masculino
                                    //impares Feminino
                                    if(comp.equals(genero))   
                                    {   int ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 1;
                                        java.sql.Date cama1 = BD.get_Date("Data", "Cama" + predio, ID_Cama);//cama 1
                                        ID_Cama = ID_Cama + 1;
                                        java.sql.Date cama2 = BD.get_Date("Data", "Cama" + predio, ID_Cama);// cama 2 
                                        ID_Cama = ID_Cama + 1;
                                        java.sql.Date cama3 = BD.get_Date("Data","Cama" + predio, ID_Cama);// cama 3
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
                                        int cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                        if(cmp == 1)
                                        {//se cama mais antiga disponivel
                                         insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                        }
                                        else
                                        {switch(antiga)//antiga é a cama1 ou cama2 ou cama3 que tinha a data mais antiga
                                         {case 1:
                                          if(cama2.compareTo(cama3) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 2;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama2 e ela esta disponivel
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama2 e ela não esta disponivel usa-se cama3
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 3;
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 3;
                                           cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama3 seja mais antigo e esta disponivel
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama3 mais antiga mas não esta disponivel
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 2;
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                          }
                                          break;
                                          case 2:
                                          if(cama1.compareTo(cama3) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 1;
                                           cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama1 e ela esta disponivel
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama1 e ela não esta disponivel usa-se cama3
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 3;
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 3;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama3 seja mais antigo e esta disponivel
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama3 mais antiga mas não esta disponivel
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 1;
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                          }
                                          break;
                                          case 3:
                                          if(cama1.compareTo(cama2) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 1;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama1 e ela esta disponivel
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama1 e ela não esta disponivel usa-se cama2
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 2;
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apartamento * 10) + 2;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama2 seja mais antigo e esta disponivel
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama2 mais antiga mas não esta disponivel
                                            insere(genero,Tabela,ID_Cama,predio,bloco,apartamento,num_p,num_b,num_a,ID_Bloco,ID_apt);
                                           }
                                          }
                                          break;
                                         }
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
                    }
                    else
                    {JOptionPane.showMessageDialog(null,"Erro Nome da tabela é invalido");
                    }
                }
            }       
    }
}
   
    public void insere(String genero,String Tabela,int ID_Cama,int predio,int bloco,int apartamento,int num_p,int num_b,int num_a,int ID_Bloco,int ID_apt)
    {int retorno;
     String nome;
     java.sql.Date data_nascimento = null,previsao_saida = null,compara = null;
     int ano = Integer.parseInt(tex4.getText());
     nome = tex1.getText();
     SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
     try {data_nascimento = new java.sql.Date(format.parse(tex3.getText()).getTime());
         } catch (ParseException ex) {
           Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
            }
     try {compara = new java.sql.Date(format.parse("22/06/2019").getTime());
        } catch (ParseException ex) {
          Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
          }
          //checa se data de nascimento é valida
     if(data_nascimento.compareTo(compara) <= 0)
     {  try { previsao_saida = new java.sql.Date(format.parse(tex5.getText()).getTime());
             } catch (ParseException ex) {
               Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
               }
        Calendar data = Calendar.getInstance();
        data.setTime(previsao_saida);
        int year = data.get(Calendar.YEAR);
        if((year - ano) >= 0)
        {
            Morador m1 = new Morador(nome,genero,data_nascimento,ano,previsao_saida);
            retorno = BD.insere(m1, ID_Cama,Tabela); //tratamento de erro para caso inserção não ocorra
            if(retorno == 1)
            {JOptionPane.showMessageDialog(null,"Erro ao inserir valor");
             setinserido(false);
            }
            else
            {setinserido(true);
            }
           //insere na tabela Morador indicada no campo Predio
           retorno = BD.update_Tabela(predio, Tabela, "PREDIO", nome);
           if(retorno == 1)
            {JOptionPane.showMessageDialog(null,"Erro ao inserir valor");
             setinserido(false);
            }
            else
            {setinserido(true);
            }
            //insere na tabela Morador indicada no campo Bloco
            retorno = BD.update_Tabela(bloco, Tabela, "BLOCO", nome);
            if(retorno == 1)
            {JOptionPane.showMessageDialog(null,"Erro ao inserir valor");
             setinserido(false);
            }
            else
            {setinserido(true);
            }
            //insere na tabela Morador indicada no campo Apartamento
            retorno = BD.update_Tabela(apartamento, Tabela, "APARTAMENTO", nome);
            if(retorno == 1)
            {JOptionPane.showMessageDialog(null,"Erro ao inserir valor");
             setinserido(false);
            }
            else
            {setinserido(true);
            }
            //insere na tabela Predio indicada no campo predio
            num_p++;
            BD.update_Tabela(num_p, "Predio", "N_Ocupantes", predio);
            //insere na tabela Bloco indicada no campo predio
            num_b++;
            BD.update_Tabela(num_b, "Bloco" + predio, "N_Ocupantes", ID_Bloco);
            //insere na tabela Apartamento indicada no campo predio obs: tabelas unicas para cada predio
            num_a++;
            BD.update_Tabela(num_a, "Apartamento" + predio, "N_Ocupantes", ID_apt);
            //insere na tabela Cama indicada no ID_Cama
            BD.update_Tabela(0, "Cama" + predio, "Status", ID_Cama);
            Date data_atual = new Date(System.currentTimeMillis());
            BD.update_Tabela(data_atual, "Cama" + predio, "Data", ID_Cama);
            //checa se todos os dados foram inseridos
            boolean teste = getinserido();
            if(teste)
            {JOptionPane.showMessageDialog(null,"Morador Inserido \n");
             dispose();
            }
            else
            {JOptionPane.showMessageDialog(null,"Erro nao foi possivel inserir \n");
             dispose();
            }  
        }
        else
        {JOptionPane.showMessageDialog(null,"Erro data de saida maior que ano de entrada");
        }
     } 
     else
     {JOptionPane.showMessageDialog(null,"Erro data de Nascimento invalida \n");
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