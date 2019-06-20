import java.util.Date;

public class Cama{
  //private final int ID;
  private boolean status_vago;
  Date data_vagou;
  Morador morador;

  public Cama(boolean status_vago){
    //super();
    //this.ID=ID;
    this.status_vago=true;
    data_vagou = new Date();  }

  //public void setMorador(String nome,String genero,int data_nascimento,ano_ingresso,int previsao_saida,da//terminar setador do morador)
  public void setData_vagou(Date data){
    this.data_vagou = data;
  }
  public Date getData_vagou(){
    return this.data_vagou;
  }
  public void setStatus_vago(boolean status){
    if(status_vago){
      this.status_vago = status;
    }
    else{
      System.out.println("erro, cama ocupada");}
  }
  public boolean getStatus_vago(){
    return this.status_vago;
  }
  
  public void setOcupante(Morador morador){ if(getStatus_vago()){   this.morador=morador;  } }
  public Morador getOcupante(){   return this.morador;  }
}