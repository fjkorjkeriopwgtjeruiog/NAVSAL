package NAVSAL;

public class Armadura{
    public String nombre;
    public int proteccion;
    public int sexo; // true: Varon || false: Mujer
    
    public Armadura(String n,int p, int s){
    nombre=n;
    proteccion=p;
    sexo=s;
    }
    
    /**
     * Una unidad intenta equiparse una armadura. Solo lo consiguira si el sexo para el que se hizo la armadura y el sexo de la unidad coinciden.
     * @param z la unidad que quiere equiparse la armadura.
     */
    
    public void equipar(Unidad z){
    if(z.sexo==sexo){z.armadura=this; z.ps=proteccion; System.out.println("Armadura equipada correctamente.");}
    else System.out.println("Armadura no compatible.");
    }
}