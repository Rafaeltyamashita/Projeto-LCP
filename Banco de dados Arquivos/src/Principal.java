import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;

import java.util.Date;

import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Principal{

    static ArrayList<Predio> predios = new ArrayList<Predio>();

    static ArrayList<Bloco> blocos = new ArrayList<Bloco>();

    static ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
    static ArrayList<Morador> moradores = new ArrayList<Morador>();


    /*public PRINCIPAL(){}*/

    static void  inicia(){
     int retorno =  BD.checa_Tabela();
      if(retorno != 0)//Não foi encontrado a Tabela Predio1. Banco de dados não foi criado
      { System.out.println("informe numero de predios: ");
        Scanner entrada = new Scanner(System.in);
        int num_predio = entrada.nextInt();
        int no_blocos= 4 * num_predio;
        int no_apartamentos= 4 * no_blocos;
        int no_camas = 3 * no_apartamentos;
        ArrayList<Integer> limites;
        limites = new ArrayList< Integer >();
        boolean bool_genero=true;
        limites.add(num_predio);
        limites.add(no_blocos);
        limites.add(no_apartamentos);
        limites.add(no_camas);
        
        String temp;
        int i,j,k,l,ID_Bloco,ID_Apartamento,ID_Cama ;
        //nome da Tabela de Predio e a string predio com o numero do predio
        java.sql.Date data = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {data = new java.sql.Date(format.parse("01/01/2000").getTime());
            } catch(ParseException ex) {
              Logger.getLogger(Janela_Insere.class.getName()).log(Level.SEVERE, null, ex);
               }
        BD.criar_Tabela_Predio("Predio");
        for(i=1;i<=num_predio;i++)
        {//cria tabela Bloco, Apartamento,Cama para cada i
         //insere para cada i o valor de habitantes no predio e o numero do predio na tabela Predio
         BD.insere_Predio(i,0,"Predio");
         temp = ("Bloco" + i);
         BD.criar_Tabela_Bloco(temp);
         temp = ("Apartamento" + i);
         BD.criar_Tabela_Apartamento(temp);
         temp = ("Cama" + i); 
         BD.criar_Tabela_Cama(temp);
         temp = ("Morador" + i); 
         BD.criar_Tabela_Morador(temp);
            for(j=1;j<=4;j++)
            {ID_Bloco = (i * 10) + j;// ID_Bloco = (num_predio * 10) + no_blocos;
             temp = ("Bloco" + i);
             BD.insere_Bloco(ID_Bloco,0,temp);
                for(k=1;k<=4;k++)
                {ID_Apartamento = (i * 100) + (j * 10) + k;//ID_Apartamento = (num_predio * 100) + (no_blocos * 10) + no_apartamentos;
                 temp = ("Apartamento" + i);
                 if(k%2 == 0)
                 {BD.insere_Apartamento(ID_Apartamento,"Masculino",0,"Arquivo"+ID_Apartamento, temp);
                 }
                 else
                 {BD.insere_Apartamento(ID_Apartamento,"Feminino",0,"Arquivo"+ID_Apartamento, temp);
                 }
                    for(l=1;l<=3;l++)
                    {ID_Cama = (i * 1000) + (j * 100) + (k * 10) + l;//ID_Apartamento = (num_predio * 1000) + (no_blocos * 100) + (no_apartamentos * 10) + no_cama;
                     temp = ("Cama" + i); 
                     BD.insere_Cama(ID_Cama, 1,data,temp);
                    }
                }
            }
        }
      }
      else//Tabela Predio1 encontrada Banco de dados ja foi criado
      {System.out.println("Ja se tem a tabela");
          
      }
        
    }

    public static void main(String[] args){
    inicia();
    }
}
