import java.util.ArrayList;

class Teste{
    
public static void main(String[] args) {
       
 ArrayList<Predio> predios = new ArrayList<Predio>();
        
ArrayList<Bloco> blocos = new ArrayList<Bloco>();
        
ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
        
int no_blocos=3;
        int no_apartamentos=4;

       
 for(int i=0;i<2;i++){
           
 predios.add(new Predio(i+1,2,4));
        
    for(int j=0;j<no_blocos;j++){
                
	blocos.add(new Bloco(j+1));
                
		for(int k=0;k<no_apartamentos;k++){
         
	           boolean bool_genero=true;
                    
		apartamentos.add(new Apartamento(1+k,bool_genero));
                   
		 if(bool_genero)bool_genero=false;
                    
		else bool_genero=true;
                
		}
                
	//blocos.get(i).setApartamento(apartamentos);
            
	}
            predios.get(i).setBloco(blocos);
            
        
 }
                
       
        
//System.out.println(predios.get(1).blocos.get(1).get_ID());
        
System.out.println(apartamentos.get(0).get_ID());
    }
  
 
}