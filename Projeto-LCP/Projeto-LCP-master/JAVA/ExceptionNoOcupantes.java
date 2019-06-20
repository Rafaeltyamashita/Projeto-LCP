public class ExceptionNoOcupantes extends Exception{
   
 @Override
    public String getMessage(){
       
 return "Excedu o número de ocupantes ou não há ocupantes";
 }

} 