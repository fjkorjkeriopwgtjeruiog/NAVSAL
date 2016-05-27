package NAVSAL;
public class Arma {
        public String nombre, tipo;
    public int potencia,elemento;
    
    public Arma(String n,String t,int p,int e){
    nombre=n;
    tipo=t;
    potencia=p;
    elemento=e;
    }
    
    /**
     * Una unidad intenta equiparse el arma. Para que la operación tenga exito, debe el tipo de arma coincidir con la clase de la unidad.
     * @param z la unidad que intenta equiparse el arma.
     */
    
    public void equipar(Unidad z){
    if(z.clase.equals(tipo)){z.arma=this; System.out.println("Arma equipada correctamente.");}
    else System.out.println("Arma no compatible.");
    }
}