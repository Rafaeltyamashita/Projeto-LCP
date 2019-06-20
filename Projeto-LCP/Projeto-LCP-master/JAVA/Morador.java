import java.util.Date;
public class Morador{
  private String nome,genero;
  private final Date data_nascimento,ano_ingresso;
  private Date previsao_saida,data_saida;
  
  private boolean status_sindico;
  //private File advertencia;
  
  public Morador(String nome,String genero,Date data_nascimento,Date ano_ingresso,Date previsao_saida){
    setNome(nome);
    setGenero(genero);
    this.ano_ingresso=ano_ingresso;
    this.data_nascimento=data_nascimento;
    setPrevisao_saida(previsao_saida);
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
  
  public Date getData_nascimento(Date data_nascimento)
  {return data_nascimento;
  }
  
  public Date getAno_ingresso(Date ano_ingresso)
  {return ano_ingresso;
  }
  public void setPrevisao_saida(Date previsao_saida)
  {this.previsao_saida = previsao_saida;
  }
  public Date getPrevisao_saida(Date previsao_saida)
  {return  previsao_saida;
  }
  public void setData_saida(Date data_saida)
  {this.data_saida = data_saida;
  }
  public Date getData_saida(Date data_saida)
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

