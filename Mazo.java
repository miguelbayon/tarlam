import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Clase que representa un mazo de la baraja francesa de 52 cartas.
 * 
 * @author Miguel Bayon
 */
public class Mazo
{
    private ArrayList<Carta> mazo;

    /**
     * Constructor de la clase Mazo. Crea las 52 cartas de la baraja
     * francesa.
     */
    public Mazo()
    {
        mazo = new ArrayList<>();
        int index = 1;
        while(index<5){
            generarCartasDeUnPalo(index);
            index++;    
        }
        
    }
    
    /**
     * Genera 13 cartas del palo indicado y las anade al mazo.
     * 
     * @param   El palo de las cartas que debe generar en formato
     *          entero
     */    
    private void generarCartasDeUnPalo(int palo)
    {
        int index = 1;
        while (index < 14){
            mazo.add(new Carta(index, palo));
            index++;
        }
    }

    /**
     * Devuelve el numero de cartas que contiene actualmente el mazo.
     * 
     * @return  El numero de cartas que tiene el mazo ahora mismo
     */
    public int getNumeroCartasEnMazo()
    {
        return mazo.size();
    }
        
    /**
     * Devuelve la carta que esta en la primera posicion del mazo y
     * elimina esta carta del mazo. Si el mazo esta vacio, devuelve
     * null.
     * 
     * @return     El objeto carta que está en la primera posicion
     *             del mazo
     */    
    public Carta robar()
    {
        /*Carta cartaRobada = null;
        Iterator <Carta> it = mazo.iterator();
        boolean robada = false;
        while (it.hasNext() && !robada){
            cartaRobada = it.next();
            it.remove();
            robada = true;
        }
        return cartaRobada;*/
        
        Carta cartaRobada = null;
        if(getNumeroCartasEnMazo() > 0){
            cartaRobada = mazo.remove(0);
        }
        return cartaRobada;
    }
    
    /**
     * Baraja el mazo.
     * 
     */    
    public void barajar() 
    {
        Collections.shuffle(mazo);
    }
    
    /**
     * Muestra por pantalla los nombres de las cartas del mazo en el orden
     * en que se encuentran en el mazo.
     * 
     */    
    public void mostrarMazo() 
    {
        for(Carta cartaAmostrar:mazo){
            System.out.println(cartaAmostrar.toString());
        }
    }

}