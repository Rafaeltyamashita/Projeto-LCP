//CREATE TABLE Morador(Linha INTEGER,Nome VARCHAR(30),Genero Varchar(10),Data_de_Nascimento DATE,Ano_de_Ingresso INTEGER,Previsao_Saida DATE,Data_Saida DATE,Predio INTEGER,Bloco Integer,Apartamento Integer,Cama Integer)
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;
public class Morador{
  private String nome,genero;
  private final Date data_nascimento;
  private final int ano_ingresso;
  private int idade;
  private Date previsao_saida,data_saida;
  
  private boolean status_sindico;
  //private File advertencia;
  
  public Morador(String nome,String genero,Date data_nascimento,int ano_ingresso,Date previsao_saida){
    setNome(nome);
    setGenero(genero);
    this.ano_ingresso=ano_ingresso;
    this.data_nascimento=data_nascimento;
    setPrevisao_saida(previsao_saida);
    setidade(data_nascimento);
  }
  public void setidade(Date data_nascimento){
  Date d = new Date();
  Calendar data_atual = Calendar.getInstance();
  data_atual.setTime(d);
  Calendar data = Calendar.getInstance();
  data.setTime(data_nascimento);
  int year = data_atual.get(Calendar.YEAR);
  int year1 = data.get(Calendar.YEAR);
  int mes = data_atual.get(Calendar.MONTH);
  int mes1 = data.get(Calendar.MONTH);
  int dia = data_atual.get(Calendar.DATE);
  int dia1 = data.get(Calendar.DATE);
  idade = year - year1;
    if(mes - mes1 > 0)
    {idade = year - year1;
    }
    else
    {if(mes - mes1 == 0)
     {  if(dia - dia1 > 0)
        {idade = year - year1;
        }
        else
        {   if(dia - dia1 == 0)
            {idade = year - year1;
            }
            else
            {idade = year - year1 - 1;
            }
        }
     }
     else
     {idade = year - year1 - 1;
     }
    }
  }
  public int getidade(){
      return idade;
  }
  public void setNome(String nome){
  this.nome = nome;
  }
  public String getNome(){
  return nome;
  }
  public void setGenero(String genero){
  this.genero = genero;
  }
  public String getGenero(){
  return genero;
  }
  public Date getData_nascimento()
  {return data_nascimento;
  }
  public int getAno_ingresso()
  {return ano_ingresso;
  }
  public void setPrevisao_saida(Date previsao_saida)
  {this.previsao_saida = previsao_saida;
  }
  public Date getPrevisao_saida()
  {return  previsao_saida;
  }
  public void setData_saida(Date data_saida)
  {this.data_saida = data_saida;
  }
  public Date getData_saida()
  {return  data_saida;
  }
  public void setStatus_sindico(boolean status_sindico)
  {this.status_sindico = status_sindico;
}
  public boolean getStatus_sindico()
  {return this.status_sindico;
  }

  //metodo advertencia(write/read)

}
