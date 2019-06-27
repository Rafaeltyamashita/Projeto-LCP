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
import java.util.logging.Level;
import java.util.logging.Logger;

public class  Janela_Mudança extends JFrame {
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
   private boolean inserido;
   private JButton bts;
   
   public Janela_Mudança ()  {
      super( "Update de Dados" );
      setLayout( new GridLayout( 2, 1, 10, 10 ) );
      panel1.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Nome completo do Morador" ) );
      panel1.add(tex1);
       panel2.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Predio" ) );
       panel2.add( tex2 );
       panel3.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Bloco" ) );
       panel3.add( tex3 );
       panel4.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Apartamento" ) );
       panel4.add( tex4 );
       panel5.setBorder( new TitledBorder(new LineBorder( Color.BLACK ), "Predio atual" ) );
       panel5.add( tex5 );
      add( panel1 );
      add( panel2 );
      add( panel3 );
      add( panel4 );
      add( panel5 );
      bts = new JButton("Atualizar");
      ButtonHandler handler = new ButtonHandler();
      bts.addActionListener(handler);
      add(bts);
      setSize( 750, 240 );
      setVisible( true ); 
    }
   private class ButtonHandler implements ActionListener
   {        private String s1,s2,s3,s4,s5; //recebe os textos escritos no formulario	
            public void actionPerformed(ActionEvent e)
            { //se botao apertado
                if(e.getSource() == bts)
                {   s1 = tex1.getText();
                    s2 = tex2.getText();
                    s3 = tex3.getText();
                    s4 = tex4.getText();
                    s5 = tex5.getText();
                   if("".equals(s1) || "".equals(s2) || "".equals(s3) || "".equals(s4) || "".equals(s5))
                   {JOptionPane.showMessageDialog(null,"Algum campo nao foi preenchido");
                   }
                   else
                    {String comp,nome,genero;
                     int num_p,num_b,num_apt,predio,bloco,apt,predio_atual,bloco_atual,cama_atual,ID_cama_atual,apt_atual;
                     nome = tex1.getText();
                     predio = Integer.parseInt(tex2.getText());
                     bloco = Integer.parseInt(tex3.getText());
                     apt = Integer.parseInt(tex4.getText());
                     predio_atual = Integer.parseInt(tex5.getText());
                     bloco_atual = BD.get_Int("Bloco", ("Morador" + predio_atual), nome);
                     String nome2 = BD.get_String("Nome", ("Morador"+predio_atual), nome);
                     int ID = BD.get_Int("id", ("Morador"+predio_atual), nome);
                     int temp = ID%1000;
                     bloco_atual = temp/100;
                     temp = temp%100;
                     apt_atual = temp/10;
                     cama_atual = temp%10;
                     //se tabela existe e  morador existe
                     if(nome.equals(nome2))
                     {//mudança mesmo predio
                        if(predio == predio_atual)
                        {//mudança no mesmo bloco
                         if(bloco_atual == bloco)
                         {//atualiza valor nas tabelas apartamento,cama
                          int ID_apt = (100*predio_atual) + (10*bloco_atual) + apt_atual;
                          ID_cama_atual = (1000*predio_atual) + (100 * bloco_atual) + (10*apt_atual) + cama_atual;
                          BD.update_Tabela(1, ("Cama"+predio_atual), "Status", ID_cama_atual);
                          num_apt = BD.get_Int("N_Ocupantes", ("Apartamento"+predio_atual),ID_apt);
                          num_apt--;
                          BD.update_Tabela(num_apt, ("Apartamento" + predio_atual), "N_Ocupantes", ID_apt);
                          //recuperar informações necessária para inserção 
                          genero = BD.get_String("Genero", ("Morador"+predio_atual), nome);
                          int ID_Bloco = (10*predio) + bloco;
                          num_p = BD.get_Int("N_Ocupantes", "Predio", predio);
                          num_p--; //evitar que predio tenha um morador a mais
                          num_b = BD.get_Int("N_Ocupantes", ("Bloco"+predio), ID_Bloco);
                          ID_apt = (100*predio) + (10*bloco) + apt;
                          num_apt = BD.get_Int("N_Ocupantes", ("Apartamento"+predio), ID_apt);
                          int ano = BD.get_Int("Ano_de_Ingresso", ("Morador" + predio_atual), nome); 
                          java.sql.Date data_nascimento,previsao_saida;
                          data_nascimento = BD.get_Date("Data_de_Nascimento", ("Morador" + predio_atual), nome);
                          previsao_saida = BD.get_Date("Previsao_Saida", ("Morador" + predio_atual), nome);
                          comp = BD.get_String("Genero", ("Apartamento"+predio), ID_apt);
                              if(num_apt < 3)
                                {//checa se genero do apartamento corresponde ao informado
                                    //pares Masculino
                                    //impares Feminino
                                   if(comp.equals(genero))   
                                    {   int ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
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
                                          ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                         }
                                         else
                                         {antiga  = 3;
                                          ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                         }
                                        }
                                        else
                                        { if(cama2.compareTo(cama3) <= 0)
                                          {antiga = 2;
                                           ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                          }
                                          else
                                          {antiga = 3;   
                                           ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                          }
                                        }
                                        int cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                        if(cmp == 1)
                                        {//se cama mais antiga disponivel
                                         BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                         insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                        }
                                        else
                                        {switch(antiga)//antiga é a cama1 ou cama2 ou cama3 que tinha a data mais antiga
                                         {case 1:
                                          if(cama2.compareTo(cama3) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama2 e ela esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama2 e ela não esta disponivel usa-se cama3
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                           cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama3 seja mais antigo e esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama3 mais antiga mas não esta disponivel
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          break;
                                          case 2:
                                          if(cama1.compareTo(cama3) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                           cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama1 e ela esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama1 e ela não esta disponivel usa-se cama3
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama3 seja mais antigo e esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama3 mais antiga mas não esta disponivel
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          break;
                                          case 3:
                                          if(cama1.compareTo(cama2) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama1 e ela esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama1 e ela não esta disponivel usa-se cama2
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama2 seja mais antigo e esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama2 mais antiga mas não esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
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
                                {JOptionPane.showMessageDialog(null,"Apartamento Cheio");
                                }
                         }
                         else
                         {//mudança bloco diferente
                          //atualiza valor nas tabelas apartamento,bloco e cama
                          int ID_Bloco = (10*predio_atual) + bloco_atual;
                          int ID_apt = (100*predio_atual) + (10*bloco_atual) + apt_atual;
                          ID_cama_atual = (1000*predio_atual) + (100 * bloco_atual) + (10*apt_atual) + cama_atual;
                          BD.update_Tabela(1, ("Cama"+predio_atual), "Status", ID_cama_atual);
                          num_b = BD.get_Int("N_Ocupantes", ("Bloco"+predio_atual), ID_Bloco);
                          num_b--;
                          BD.update_Tabela(num_b, ("Bloco"+predio_atual), "N_Ocupantes", ID_Bloco);
                          num_apt = BD.get_Int("N_Ocupantes", ("Apartamento"+predio_atual), ID_apt);
                          num_apt--;
                          BD.update_Tabela(num_apt, ("Apartamento" + predio_atual), "N_Ocupantes", ID_apt);
                          //recuperar informações necessária para inserção 
                          ID_Bloco = (10*predio) + bloco;
                          ID_apt = (100*predio) + (10*bloco) + apt;
                          genero = BD.get_String("Genero", ("Morador"+predio_atual), nome);
                          num_p = BD.get_Int("N_Ocupantes", "Predio", predio);
                          num_p--;//evitar que predio tenha mais um morador
                          num_b = BD.get_Int("N_Ocupantes", ("Bloco"+predio), ID_Bloco);
                          num_apt = BD.get_Int("N_Ocupantes", ("Apartamento"+predio), ID_apt);
                          int ano = BD.get_Int("Ano_de_Ingresso", ("Morador" + predio_atual), nome); 
                          java.sql.Date data_nascimento = null,previsao_saida = null;
                          data_nascimento = BD.get_Date("Data_de_Nascimento", ("Morador" + predio_atual), nome);
                          previsao_saida = BD.get_Date("Previsao_Saida", ("Morador" + predio_atual), nome);
                          comp = BD.get_String("Genero", ("Apartamento"+predio), ID_apt);
                            if(num_b<12)
                            {  if(num_apt < 3)
                                {//checa se genero do apartamento corresponde ao informado
                                    //pares Masculino
                                    //impares Feminino
                                    if(comp.equals(genero))   
                                    {   int ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
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
                                          ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                         }
                                         else
                                         {antiga  = 3;
                                          ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                         }
                                        }
                                        else
                                        { if(cama2.compareTo(cama3) <= 0)
                                          {antiga = 2;
                                           ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                          }
                                          else
                                          {antiga = 3;   
                                           ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                          }
                                        }
                                        int cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                        if(cmp == 1)
                                        {//se cama mais antiga disponivel
                                         BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                         insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                        }
                                        else
                                        {switch(antiga)//antiga é a cama1 ou cama2 ou cama3 que tinha a data mais antiga
                                         {case 1:
                                          if(cama2.compareTo(cama3) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama2 e ela esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama2 e ela não esta disponivel usa-se cama3
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                           cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama3 seja mais antigo e esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama3 mais antiga mas não esta disponivel
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          break;
                                          case 2:
                                          if(cama1.compareTo(cama3) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                           cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama1 e ela esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama1 e ela não esta disponivel usa-se cama3
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama3 seja mais antigo e esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama3 mais antiga mas não esta disponivel
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          break;
                                          case 3:
                                          if(cama1.compareTo(cama2) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama1 e ela esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama1 e ela não esta disponivel usa-se cama2
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama2 seja mais antigo e esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama2 mais antiga mas não esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
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
                                {JOptionPane.showMessageDialog(null,"Apartamento cheio"); 
                                }
                            }
                            else
                            {JOptionPane.showMessageDialog(null,"Bloco cheio");
                            }
                         }
                        }
                        else
                        {//se mudou para outro predio
                          //atualiza valor nas tabelas apartamento, bloco e predio
                          ID_cama_atual = (1000*predio_atual) + (100 * bloco_atual) + (10*apt_atual) + cama_atual;
                          BD.update_Tabela(1, ("Cama"+predio_atual), "Status", ID_cama_atual);
                          int ID_Bloco = (10*predio_atual) + bloco_atual;
                          int ID_apt = (100*predio_atual) + (10*bloco_atual) + apt_atual;
                          num_p = BD.get_Int("N_Ocupantes", "Predio", predio_atual);
                          num_p--;
                          BD.update_Tabela(num_p, "Predio", "N_Ocupantes", predio_atual);
                          num_b = BD.get_Int("N_Ocupantes", ("Bloco"+predio_atual), ID_Bloco);
                          num_b--;
                          BD.update_Tabela(num_b, ("Bloco"+predio_atual), "N_Ocupantes", ID_Bloco);
                          num_apt = BD.get_Int("N_Ocupantes", ("Apartamento"+predio_atual), ID_apt);
                          num_apt--;
                          BD.update_Tabela(num_apt, ("Apartamento" + predio_atual), "N_Ocupantes", ID_apt);
                          //recuperar informações necessária para inserção 
                          ID_Bloco = (10*predio) + bloco;
                          ID_apt = (100*predio) + (10*bloco) + apt;
                          genero = BD.get_String("Genero", ("Morador"+predio_atual), nome);
                          num_p = BD.get_Int("N_Ocupantes", "Predio", predio);
                          num_b = BD.get_Int("N_Ocupantes", ("Bloco"+predio), ID_Bloco);
                          num_apt = BD.get_Int("N_Ocupantes", ("Apartamento"+predio), ID_apt);
                          int ano = BD.get_Int("Ano_de_Ingresso", ("Morador" + predio_atual), nome); 
                          java.sql.Date data_nascimento = null,previsao_saida = null;
                          data_nascimento = BD.get_Date("Data_de_Nascimento", ("Morador" + predio_atual), nome);
                          previsao_saida = BD.get_Date("Previsao_Saida", ("Morador" + predio_atual), nome);
                          comp = BD.get_String("Genero", ("Apartamento"+predio), ID_apt);
                          if(num_p<48)
                          {
                            if(num_b<12)
                            {  if(num_apt < 3)
                                {//checa se genero do apartamento corresponde ao informado
                                    //pares Masculino
                                    //impares Feminino
                                    if(comp.equals(genero))   
                                    {   int ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
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
                                          ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                         }
                                         else
                                         {antiga  = 3;
                                          ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                         }
                                        }
                                        else
                                        { if(cama2.compareTo(cama3) <= 0)
                                          {antiga = 2;
                                           ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                          }
                                          else
                                          {antiga = 3;   
                                           ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                          }
                                        }
                                        int cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                        if(cmp == 1)
                                        {//se cama mais antiga disponivel
                                         BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                         insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                        }
                                        else
                                        {switch(antiga)//antiga é a cama1 ou cama2 ou cama3 que tinha a data mais antiga
                                         {case 1:
                                          if(cama2.compareTo(cama3) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama2 e ela esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama2 e ela não esta disponivel usa-se cama3
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                           cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama3 seja mais antigo e esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama3 mais antiga mas não esta disponivel
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          break;
                                          case 2:
                                          if(cama1.compareTo(cama3) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                           cmp = BD.get_Int("Status", "Cama" + predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama1 e ela esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama1 e ela não esta disponivel usa-se cama3
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 3;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama3 seja mais antigo e esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama3 mais antiga mas não esta disponivel
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          break;
                                          case 3:
                                          if(cama1.compareTo(cama2) <= 0)
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 1;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso ID_Cama for de cama1 e ela esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso ID_Cama for de cama1 e ela não esta disponivel usa-se cama2
                                            ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                          }
                                          else
                                          {ID_Cama = (predio * 1000) + (bloco *100) + (apt * 10) + 2;
                                           cmp = BD.get_Int("Status", "Cama"+predio, ID_Cama);
                                           if(cmp == 1)
                                           {//caso cama2 seja mais antigo e esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
                                           }
                                           else
                                           {//caso seja cama2 mais antiga mas não esta disponivel
                                            BD.exclui_Morador(nome, ("Morador"+predio_atual));
                                            insere(nome,ano,genero,data_nascimento,previsao_saida,("Morador"+predio),ID_Cama,predio,bloco,apt,num_p,num_b,num_apt,ID_Bloco,ID_apt);
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
                                {JOptionPane.showMessageDialog(null,"Apartamento cheio"); 
                                }
                            }
                            else
                            {JOptionPane.showMessageDialog(null,"Bloco cheio");
                            }
                          }
                          else
                          {JOptionPane.showMessageDialog(null,"Predio cheio");
                          }
                        }
                     }
                     else
                     {////se tabela não existe ou morador não existe
                      JOptionPane.showMessageDialog(null,"Erro Tabela ou nome do Morador não existe"); 
                     }
                     
                    }
                }
            }
   }
   public void insere(String nome,int ano,String genero,Date data_nascimento,Date previsao_saida,String Tabela,int ID_Cama,int predio,int bloco,int apartamento,int num_p,int num_b,int num_a,int ID_Bloco,int ID_apt)
    {int retorno;
     java.sql.Date compara = null;
     SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
     try {compara = new java.sql.Date(format.parse("22/06/2019").getTime());
        } catch (ParseException ex) {
          Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
          }
          //checa se data de nascimento é valida
     if(data_nascimento.compareTo(compara) <= 0)
     {  Calendar data = Calendar.getInstance();
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
 
}