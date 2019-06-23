import java.util.ArrayList;

public class Predio implements Condominio{// extends Condominio{
    public final int ID;//vai ser setado uma unica vez e servirá para identificar o predio
    private final int no_blocos;
    private int no_ocupantes;////dá o numero de ocupantes total no predio
    ArrayList<Bloco> blocos = new ArrayList<Bloco>();

  public Predio(int ID,int no_blocos){
      this.ID=ID;
      this.no_ocupantes=0;
      this.no_blocos=no_blocos;
  }
  
  public void setBloco(ArrayList<Bloco> blocos){ this.blocos=blocos;}

    public int get_ID(){  return ID; }
    //incrementa ou decrementa o numero de ocupantes
    public void Update_no_ocupantes(boolean variacao){
    if(variacao) no_ocupantes++;
    else no_ocupantes--;}//true no_ocupantes++, false --;
  
    public int getNo_ocupantes(){   return no_ocupantes;  }
}
