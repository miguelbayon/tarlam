/**
 * La clase carta representa una carta de la baraja francesa
 * 
 */
public class Carta
{
    private int valor;
    private int palo;

    /**
     * Constructor de objetos carta. Inicializa los atributos de la clase
     * con los valores recibidos como parametros.
     */
    public Carta(int valor, int palo)
    {
        this.valor = valor;
        this.palo = palo;
    }

    /**
     * Retorna el valor de la carta
     * 
     * @return     El valor del atributo valor
     */
    public int getValor()
    {
        return valor;
    }

    /**
     * Retorna el valor del palo de la carta: 1, 2, 3 o 4 si el palo es
     * "picas", "corazones", "diamantes" o "treboles" respectivamente.
     * 
     * @return     El valor del atributo palo
     */
    public int getPalo()
    {
        return palo;
    }    
    
    /**
     * Retorna el nombre del palo de la carta en formato String. En concreto, 
     * retorna "picas", "corazones", "diamantes" o "treboles" si el valor del 
     * atributo palo es 1, 2, 3 o 4 respectivamente.
     * 
     * @return     La cadena "picas", "corazones", "diamantes" o "treboles"
     *              en funcion del valor del atributo palo.
     */
    public String getPaloString()
    {
        String paloCarta = null;
        if(palo == 1){
            paloCarta = "picas";
        }else if(palo == 2){
            paloCarta = "corazones";
        }else if(palo == 3){
            paloCarta = "diamantes";
        }else if(palo == 4){
            paloCarta = "treboles";
            
        }
        return paloCarta;
    }    
    
    /**
     * Retorna el valor de la carta como String. Si la carta tiene valor 1, entonces
     * es un "As"; si tiene valor 11, 12 y 13 entonces es una "Jota", 
     * "Dama" y "Rey" respectivamente; en otro caso su valor se corresponde
     * con su nombre
     * 
     * @return     El valor de la carta en formato String
     */    
    public String getValorString() 
    {
        String valorCarta = "" + valor;
        if (valor == 1) {
            valorCarta = "As";
        }else if (valor == 11){
            valorCarta = "Jota";
        }else if (valor == 12){
            valorCarta = "Dama";
        }else if (valor == 13){
            valorCarta = "Rey";
        }
        return valorCarta;
    }
    
    /**
     * Retorna el nombre completo de la carta: por ejemplo "As de corazones",
     * "Dama de picas", "7 de treboles", "3 de diamantes", etc.
     * 
     * @return     El nombre completo de la carta en formato String
     */ 
    public String toString() 
    {
        return getValorString() + " de " + getPaloString();
    }
    
}