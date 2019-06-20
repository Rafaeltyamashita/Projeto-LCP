import java.util.ArrayList;

public class Bloco implements Condominio{
  public final int ID; //indentifica o bloco
   //private final int no_apartamentos;
   private int no_ocupantes;//dá o numero de ocupantes total no bloco
   ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();

   public Bloco(int ID){
       this.no_ocupantes = 0;
       this.ID=ID;
       //this.no_apartamentos=no_apartamentos;
       //setApartamento(ID,true);
   }
   public void setApartamento(ArrayList<Apartamento> apartamentos){
        this.apartamentos=apartamentos;
}

  public int get_ID(){  return ID; }
 
  public void Update_no_ocupantes(boolean variacao){
    if(variacao) no_ocupantes++;
    else no_ocupantes--;}//true no_ocupantes++, false --;
  
    public int getNo_ocupantes(){   return no_ocupantes;  }
}
