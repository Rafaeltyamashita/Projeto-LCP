import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;

public class  Janela_Exclui extends JFrame {
   private final JPanel panel1 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex1 = new JTextField();
   private final JPanel panel2 = new JPanel( new GridLayout( 2, 2, 5, 5 ) );
   private final JTextField tex2 = new JTextField();
   private JButton bts;
   
   public Janela_Exclui ()  {
      super( "Exclui Morador" );
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
                    {int predio,bloco,apt,num_p,num_b,num_a;
                     String nome = tex1.getText();
                     String tabela = tex2.getText();
                     
                     int ID = BD.get_Int("ID", tabela, nome);
                     predio = ID/1000;
                     bloco = ID % 1000;
                     apt = bloco%100;
               	     bloco = bloco/100;
                     apt = apt/10;
                     //atualiza cama para vazia
                     BD.update_Tabela(1, "Cama"+ predio, "Status", ID);
                     
                     //atualiza numero de ocupantes para predio
                     num_p = BD.get_Int("N_Ocupantes", "Predio", predio);
                     num_p--;
                     BD.update_Tabela(num_p, "Predio", "N_Ocupantes", predio);
                     
                     //atualiza numero de ocupantes para bloco
                     int ID_bloco = (predio * 10) + bloco;
                     num_b = BD.get_Int("N_Ocupantes", "Bloco" + predio, ID_bloco);
                     num_b--;
                     BD.update_Tabela(num_b, "Bloco"+predio, "N_Ocupantes", ID_bloco);
                     
                     //atualiza numero de ocupantes para apt
                     int ID_apt = (predio * 100)+(bloco * 10) + apt;
                     num_a = BD.get_Int("N_Ocupantes", "Apartamento"+predio, ID_apt);
                     num_a--;
                     BD.update_Tabela(num_a, "Apartamento"+predio, "N_Ocupantes", ID_apt);
                     
                    //insere morador na tabela ex_morador
                   String genero = BD.get_String("Genero", tabela, nome);
                   Date data_nascimento = BD.get_Date("Data_de_Nascimento", tabela, nome);
                   int ano = BD.get_Int("Ano_de_Ingresso", tabela, nome);
                   Date previsao = BD.get_Date("Previsao_Saida", tabela, nome);
                    Morador m = new Morador(nome,genero,data_nascimento,ano,previsao);
                    BD.insere(m, ID, "Ex_Morador");
                    
                    
                     Morador m1 = new Morador(nome,genero,data_nascimento,ano,previsao);
                     BD.update_Tabela(predio, "Ex_Morador", "PREDIO", nome);                             
                     BD.update_Tabela(bloco, "Ex_Morador", "BLOCO", nome);                              
                     BD.update_Tabela(apt, "Ex_Morador", "APARTAMENTO", nome);                             
                     Date data_atual = new Date(System.currentTimeMillis());
                     BD.update_Tabela(data_atual, "Ex_Morador", "Data_Saida", nome);  
                     //exclui morador da tabela morador
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