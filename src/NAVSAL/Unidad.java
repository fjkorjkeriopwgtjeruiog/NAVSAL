package NAVSAL;

public class Unidad{
    public String nombre,clase;
    public int sexo, ataque, defensa[]=new int[3],ps; // defensa es un vector de 3 elementos: 0: Laser || 1: Fuego || 2: Explosion
    public Arma arma;
    public Armadura armadura;

    public static String sexado[]={"Hembra","Macho"};
    public static String afiliacion[]={"Laser","Fuego","Explosion"};

    public Unidad(String n,String c,int a,int d1,int d2,int d3,int s){
    nombre=n;
    clase=c;
    ataque=a;
    defensa[0]=d1;
    defensa[1]=d2;
    defensa[2]=d3;
    sexo=s;
    }
    
    /**
     * Funcion que muestra los datos de un personaje.
     */

    public void datos(){
        if(ps>0){
    System.out.println(nombre);
    System.out.println(clase+" "+sexado[sexo]);
    System.out.println(arma.nombre);
    System.out.println(armadura.nombre);
    System.out.println("PS: "+ps+"/"+armadura.proteccion);
    vitalidad();
    System.out.println(afiliacion[arma.elemento]+": "+ataque+arma.potencia);
    for(int u=0; u<defensa.length; u++) System.out.print("Anti-"+afiliacion[u]+": "+defensa[u]*3+" ");
    System.out.println("\n");
        }
        else System.out.println(nombre+" ha muerto.");
    }

    /**
     * Sistema porcentual de vitalidad.
     */
    
    public void vitalidad(){
    int c=100;
    for(int u=0; u<c; u++){
    if(armadura.proteccion*u/c<ps) System.out.print("+");
    else System.out.print("-");
    }
    System.out.print("\n");
    }
    
    /**
     * Prediccion del daño total que causaras a tu rival.
     * @param b el enemigo que vas a atacar.
     * @return cuantos ps le quitaras al oponente de un golpe.
     */
    
    public int daño(Unidad b){
    int t=arma.potencia+ataque-b.defensa[arma.elemento]*3;
    if(t<1) t=1;
    return t;
    }

    /**
     * Empieza el ataque.
     * @param b el enemigo que es atacado.
     * @return el daño total que recibe el enemigo.
     */
    
    public int prediccion(Unidad b){
    int t=daño(b);
    System.out.println("¡"+b.nombre+" pierde "+t+" ps!");
    if(b.ps<=t) System.out.println("¡"+b.nombre+" no ha aguantado el ataque!");
    return t;
    }
    
    /**
     * Duelo 1 contra 1. No parara hasta que uno de los 2 muera.
     * @param b el enemigo al que nos enfrentamos.
     */
    
    public void duelo(Unidad b){
    int t=daño(b);
    if(t<1) t=1;
    System.out.println("¡"+b.nombre+" pierde "+t+" ps!");
    if(b.ps<=t){b.ps=0; System.out.println("¡"+b.nombre+" no ha aguantado el ataque!");}
    else{System.out.print("¡"+b.nombre+" ha aguantado el ataque. "); b.vitalidad(); b.ps-=t; b.duelo(this);} // El combate no parara hasta que alguien muera.
    }
}