import java.util.ArrayList;
import java.util.Iterator;
/**
 * Clase que representa una partida de Tarlam
 * 
 * @author Miguel Bayon
 */
public class Partida
{
    // Coleccion que incluye a los jugadores que no han sido aun eliminados
    private ArrayList<Jugador> jugadores;
    // Superado este valor los jugadores son eliminados de la partida
    private int umbralEliminacion;
    // Coleccion con las cartas que quedan en el mazo
    private Mazo mazo;
    // Indica el numero de rondas que se han jugado
    private int numeroRondasJugadas;

    /**
     * Constructor de objetos de tipo Partida. Crea a los jugadores y el
     * mazo y lo baraja.
     * 
     * @param numeroJugadores   Numero de jugadores que juegan la partida
     * @param umbralEliminacion Umbral por encima del cual los jugadores son eliminados
     */
    public Partida(int numeroJugadores, int umbralEliminacion)
    {     
        jugadores = new ArrayList<Jugador>();
        if (numeroJugadores >=2 && numeroJugadores <=10){
        int index = 0;
        while(index<numeroJugadores){//@MIGUEL: Mal identado
            jugadores.add(new Jugador(index+1));
            index++;
        }
        }else{
            System.out.println("Recuerde que en este juego pueden jugar un mínimo de 2 personas "+
                "y un máximo de 10. Inicie una nueva partida");
        }
        mazo = new Mazo(); 
        this.umbralEliminacion = umbralEliminacion;
        numeroRondasJugadas = 0;
        
        mazo.barajar();
    }

    /**
     * Juega una ronda de Tarlam siempre que queden cartas suficientes en el mazo
     * para poder repartir una a cada jugador (en caso contrario muestra un mensaje
     * de error por pantalla y no hace nada mas). Si el valor de la suma de las 
     * cartas de un jugador es mayor que el umbral de eliminacion que se fijo al 
     * iniciar la partida, ese jugador se elimina.
     * 
     * Muestra por pantalla como queda cada jugador (suma total de sus cartas y las 
     * cartas que tiene) y si esta eliminado o no.     
     * 
     * Al acabar la ronda muestra también un mensaje informando si todos los jugadores 
     * han sido eliminados o si hay un ganador (es decir, si solo queda tras la ronda
     * un jugador sin eliminar).
     * 
     * @return      Una coleccion con los jugadores que no han sido aun eliminados
     *              Si tras jugar la ronda no queda ningun jugador sin eliminar, la 
     *              coleccion retornada estara vacia. Si la ronda no se pudo jugar por
     *              falta de cartas en el mazo, devuelve null
     */
    public ArrayList<Jugador> jugarRonda()
    {   
        ArrayList<Jugador> arrayDevuelto;
        
        if(mazo.getNumeroCartasEnMazo() >= jugadores.size()) {
            // Hay suficientes cartas para jugar la ronda
            
            // Reparto una carta a cada jugador
            int index=0;
            while(jugadores.size()>index)
            {
                jugadores.get(index).recibirCarta(mazo.robar());
                index++;
            }
            
            // Saco por pantalla los datos de todos los jugadores y los elimino si superan el umbral
            Iterator<Jugador> it = jugadores.iterator();
            while(it.hasNext()){
                Jugador jugador = it.next();
                System.out.println(jugador.toString());
                if(jugador.getValorTotalCartasEnMano() > umbralEliminacion){
                    it.remove();
                    System.out.println("Ha sido eliminado");
                }
                else{
                    System.out.println("Sigue en partida");
                }
            }
            
            // Saco por pantalla si hay un ganador o si se han eliminado a todos los jugadores
            if(jugadores.size()>0){
                if(jugadores.size()==1){
                    System.out.println("Hay un ganador, el jugador " + jugadores.get(0).getId());
                }
            }else{
                System.out.println("Todos los jugadores han sido eliminados");
            }
            
            numeroRondasJugadas++;
            arrayDevuelto = jugadores;
        }
        else {
            System.out.println("No se puede jugar la ronda, ya que no hay suficientes cartas");
            arrayDevuelto = null;
        }
        
        return arrayDevuelto;
    }//
    
    
    /**
     * Imprime por pantalla el numero de cartas que quedan en el mazo.
     */
    public void numeroDeCartasQueQuedanEnElMazo()
    {
        System.out.println("Quedan en el mazo " + mazo.getNumeroCartasEnMazo() + " cartas");
    }
    
    /**
     * Devuelve el numero de rondas que se han jugado hasta el momento.
     * 
     * @return      Numero de rondas jugadas hasta el momento
     */
    public int getNumeroRondasJugadas() 
    {
        return numeroRondasJugadas;
    }   

    /**
     * Devuelve una coleccion con el jugador o los jugadores que tienen mayor puntuacion 
     * o null si todos los jugadores han sido ya eliminados.
     *
     * @return   Los jugadores que tienen la puntuación mas alta en este momento
     */
    public ArrayList<Jugador> getJugadoresMayorPuntuacion() 
    {       
        //Vamos a obtener la mayor puntuacion que tiene un jugador
        int valorMaximo = 0;
        
        for(Jugador jugador : jugadores) {
            if (jugador.getValorTotalCartasEnMano()>valorMaximo){
                valorMaximo=jugador.getValorTotalCartasEnMano();
            }
        }
        
        //Ahora construimos el ArrayList que vamos a devolver
        ArrayList<Jugador> jugadoresMayorPuntuacion = new ArrayList<>(); 
        for(Jugador jugador : jugadores){
            if(jugador.getValorTotalCartasEnMano() == valorMaximo){
                jugadoresMayorPuntuacion.add(jugador);
            }
        }
        
        return jugadoresMayorPuntuacion;//@MIGUEL: No devuelves null en caso de que todos los jugadores hayan sido ya eliminados
        
    }


    /**
     * Devuelve la id del jugador que tiene entre sus cartas el rey de picas o
     * -1 si ningún jugador tiene esa carta.
     *
     * @return     La id de un jugador o el valor -1
     */
    public int getIdJugadorConReyPicas() 
    {        
        int idJugador = -1;
        int index = 0;
        boolean searching = true;
        while(index < jugadores.size() && searching){
            Jugador jugador = jugadores.get(index);
            if(jugador.tieneCarta(new Carta(13,1)))
            {
                searching = false;
                idJugador = jugador.getId();
            }
            index++;
        }
        return idJugador;
    }
}