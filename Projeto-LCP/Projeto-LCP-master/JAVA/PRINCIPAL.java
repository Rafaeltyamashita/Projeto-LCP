import java.util.ArrayList;

import java.util.Calendar;

import java.text.DateFormat;

import java.util.Date;



public class PRINCIPAL{

    static ArrayList<Predio> predios = new ArrayList<Predio>();

    static ArrayList<Bloco> blocos = new ArrayList<Bloco>();

    static ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
    static ArrayList<Morador> moradores = new ArrayList<Morador>();


    /*public PRINCIPAL(){}*/

    static void  inicia(){

        System.out.println("informe numero de predios");

        int no_predios=1;

        System.out.println("informe numero de blocos por predio");

        int no_blocos=4;

        System.out.println("informe numero de apartamentos por blocos");

        int no_apartamentos=4;

        ArrayList<Apartamento> temp_ap = new ArrayList<Apartamento>();

        ArrayList<Bloco> temp_bl = new ArrayList<Bloco>();

        
        boolean bool_genero=true;

        for(int i=0;i<no_predios;i++){

            predios.add(new Predio((i+1)*100,2,4));

            for(int j=0;j<no_blocos;j++){

                temp_bl.add(new Bloco(((i+1)*100)+(j+1)*10));

                
                for(int k=0;k<no_apartamentos;k++){

                    if(bool_genero)bool_genero=false;

                    else bool_genero=true;

                    temp_ap.add(new Apartamento(((i+1)*100)+((j+1)*10)+1+k,bool_genero));


                    
                }

                temp_bl.get(j).setApartamento(temp_ap);

                apartamentos.addAll(temp_ap);

                temp_ap.clear();

            }

            predios.get(i).setBloco(temp_bl);

            blocos.addAll(temp_bl);

            temp_bl.clear();

          //inicializa todos os objetos apartamentos, blocos e predio(s) e interliga essses objetos

          }


    }

    static void insere_morador(){

        String nome="César";

        String genero="masculino"; //duas opções, por hora, "masculino" e "feminino"

        Calendar data=Calendar.getInstance();

        Date data_nascimento=data.getTime();//objeto date;

        Date ano_ingresso=data.getTime();//teste

        Date previsao_saida=data.getTime();//teste

        Morador morador = new Morador(nome, genero, data_nascimento, ano_ingresso, previsao_saida);


        int predio=3;//"qual predio?"

        int bloco=1;// "qual bloco?"

        int apartamento=4; // "qual apartamento?"


        apartamentos.indexOf(Apartamento c.get_ID(314);

        
    }


    static void teste(){

        for(int i=0;i<predios.size();i++){

            System.out.printf("P%d, ",predios.get(i).get_ID());

        }

        for(int i=0;i<blocos.size();i++){

            System.out.printf("B%d, ",blocos.get(i).get_ID());

        }

        for(int i=0;i<apartamentos.size();i++){

            System.out.printf("A%s, ",apartamentos.get(i).getGenero());

        }

    }


    public static void main(String[] args){

        inicia();          //inicializa todos os objetos apartamentos, blocos e predio(s) e interliga essses objetos

       // a ID inicializada é um nº de 3 digitos. o primeiro digito dá o nº do predio, o segundo o nº do bloco daquele predio e o terceiro o nº do apartamento daquele bloco

       //metade dos apartamentos é inicializado com genero masculino e a outra metade com genero feminino

        //teste();


       
        
        //generosAp(Apartamento apartamentos);

        //System.out.println(apartamento[1].getGenero());

        //insere();

    }


    

        
    
        
 /*   public static void insere(){

        int n;
//variavel temporaria a ser substituida por Scans

        System.out.println("Insere nome");

        String nome="César";//na interface grafica será um campo para nome

        System.out.println("Insere Predio");

        n=1;//na interface grafica, uma lista de predios diponiveis

        int temp_id_ap=n*100;

        System.out.println("Insere Bloco");

        n=9;//na interface grafica, uma lista de predios diponiveis

        temp_id_ap+=n*10;

        System.out.println("insere apartamento");

        n=4;

        temp_id_ap+=n;

        
        setMorador(nome,apartamento[temp_id_ap]);

        int erro=apartamento[temp_id_ap].Update_no_ocupantes(inclui);

        if(erro==2)System.out.println("apartamento cheio");

        else{

            apartamento[temp_id_ap].

        }

    }*/}

//declarar n,i,
