import java.util.ArrayList;
//...ligado a no coupantes bloco - NÃO RESOLVIDO
//implementar read/writ file  - NÃO RESOLVIDO


public class Apartamento implements Condominio{
    public final int ID;
    private String genero_ocupantes;
    private int no_ocupantes;
    //private File manutencao;
    ArrayList<Cama> camas = new ArrayList<Cama>();
    
    public Apartamento(int ID,boolean bool_genero){ 
        setGenero(bool_genero);
        this.ID =ID;
        this.no_ocupantes = 0;
        setCama(true);
    }

    /**
     *
     * @return
     */
    
    public int get_ID(){    return this.ID;    }
    public void setGenero(boolean bool_genero){
        if(bool_genero)            this.genero_ocupantes ="feminino";
        else                       this.genero_ocupantes ="masculino";
    }//se 'true' for passado como parametro, o quarto será colocado como 'feminino', caso contrario, como 'masculino'
    public String getGenero(){  return this.genero_ocupantes;   }
    public void setCama(boolean status_vago){
        for(int i=0;i<3;i++){
            camas.add(new Cama(status_vago));
        }
    }
    public void Update_no_ocupantes(boolean variacao){
        if(variacao)
            if(this.no_ocupantes>3)  new ExceptionNoOcupantes();
            else no_ocupantes++;
        else    if(this.no_ocupantes>3)  new ExceptionNoOcupantes();
                else no_ocupantes--;
    }
 //true no_ocupantes++, false --;
  public int getNo_ocupantes(){ return no_ocupantes;}



}