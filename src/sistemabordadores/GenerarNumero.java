
package sistemabordadores;


public class GenerarNumero {
    
    private int dato;
    private int cont=0;
    private String num="";

    public void generar(int dato) {
        
        this.dato = dato+1;
        int can = 0;
    
   
             
           if((this.dato>=10000000) & (this.dato<99999999)) 
           {
               can=this.dato;
               num = ""+ can; 
               
           }
           
           
           
           if((this.dato>=1000000) & (this.dato<9999999)) 
           {
               can=this.dato;
               num = "0" + can; 
               
           }
           
          
           
           if((this.dato>=100000) & (this.dato<=999999)) 
           {
               can=this.dato;
               num = "00" + can; 
                              
           }
           
        
           
           if((this.dato>=10000) & (this.dato<=99999)) 
           {
               can=this.dato;
               num = "000" + can; 
               
           }
           
        
           if((this.dato>=1000) & (this.dato<=9999))
           {
                can=this.dato;
               num = "0000" + can; 
           
            }
           
           
           
          if((this.dato>=100) & (this.dato<=999))
           {
                 can=this.dato;
               num = "00000" + can; 
           
           }
          
               
         if((this.dato>=10) & (this.dato<=99))
         {      can=this.dato;
               num = "000000" + can; 
         }
               
          if((this.dato>=1) & (this.dato<=9))
           {
                can=this.dato;
               num = "0000000" + can;
           
               
           }
         
    }

    public String serie()
    {
        return this.num;
    }
    
    
    
    
}
