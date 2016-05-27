package NAVSAL;

/**
 * @author CanCerbero
 * @version 1.0
 */

public class Valkiria {

   /**
    * @param args systema para legar valores de entrada
    */

    public static void main(final String[] args) {
    Arma q = new Arma("Pistola Boreal","Pistolero",60,0); 
    Arma a = new Arma("Papiro Supernova","Mago",75,2);

    Armadura p = new Armadura("Coraza Diamantina",1000,1);
    Armadura i = new Armadura("Vestido de bruja",750,0);

    Unidad k = new Unidad("Rodriguez","Pistolero",37,13,8,2,1);
    Unidad o = new Unidad("Hechicera","Mago",23,12,18,7,0);

    q.equipar(k);
    p.equipar(k);

    a.equipar(o);
    i.equipar(o);

    k.datos();
    o.datos();

    k.duelo(o);

    k.datos();
    o.datos();
    }
}