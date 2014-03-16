import java.util.ArrayList;
import java.util.Iterator;
/**
 * Clase que representa a un jugador de Tarlam
 * 
 * @author Miguel Bayon
 */
public class Jugador
{
    private int id;
    private ArrayList<Carta> cartasEnMano;

    /**
     * Constructor de la clase Jugador
     */
    public Jugador(int id)
    {
        this.id = id;
        cartasEnMano = new ArrayList<>();
    }
    
    /**
     * Devuelve el valor del atributo id.
     * 
     * @return     El valor entero del atributo id
     */
    public int getId() 
    {
        return id;
    }

    /**
     * Anade a las cartas que tiene un jugador en la mano la carta que 
     * se pasa como parametro.
     * 
     * @param   Una carta que se le entrega al jugador
     */
    public void recibirCarta(Carta carta)
    {
        cartasEnMano.add(carta);
    }

    /**
     * Devuelve la suma de los valores de todas las cartas que tiene
     * un jugador en la mano.
     * 
     * @return     El valor de la suma de los valores de todas las
     *             cartas de un jugador.
     */
    public int getValorTotalCartasEnMano() 
    {
        int contador = 0;
        for(Carta carta:cartasEnMano)
        {
            contador += carta.getValor();
        }
        return contador;
    }

    /**
     * Devuelve una cadena indicando el id del jugador, el valor total de sus cartas y 
     * el nombre de cada una de sus cartas. Esta cadena SERA una UNICA LINEA.
     * 
     * @return     Una cadena con los datos del jugador
     */
    public String toString() 
    {
        String cadenaDevolver = "ID: " + getId();
        cadenaDevolver += "Puntuacion total de sus cartas: " + getValorTotalCartasEnMano();
        for(Carta carta : cartasEnMano){
            cadenaDevolver += "[" + carta.toString() + "]";
        }
        return cadenaDevolver;
    }    

    /**
     * Devuelve un valor booleano indicando si el jugador tiene entre sus cartas la
     * Carta indicada como parámetro
     *
     * @param carta    La carta que se quiere buscar
     * @return             Un valor booleano indicando si el jugador tiene o no esa carta
     */
    public boolean tieneCarta(Carta carta)
    {
        boolean tieneCarta = false;
        Iterator<Carta> it = cartasEnMano.iterator();
        while(!tieneCarta && it.hasNext()){
            Carta cartaActual = it.next();
            if(cartaActual.toString().equals(carta.toString())){
            //if(cartaActual.getValor() == carta.getValor() && cartaActual.getPalo()==carta.getPalo())
                tieneCarta = true;
            }
        }
        return tieneCarta;
    }
}