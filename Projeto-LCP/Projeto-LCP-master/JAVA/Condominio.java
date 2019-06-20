public interface Condominio{
  //private final int predios_ID; // setado o ID do predio indentificador
  //private int ocupantes_condominio;

  //public Condominio(int n){
  //  this.predios_ID =  n;
 // }
 
 public int get_ID();
 //ID de tudo
 public void Update_no_ocupantes(boolean variacao);
 //true no_ocupantes++, false --;
  public int getNo_ocupantes();

}