package Constructores;

/**
 *
 * @author luis
 */
public class Constructor {

    protected int precioCompra;
    protected int precioDeVenta;
    protected int velocidadDeConstruccion;
    protected boolean construido;

    public Constructor() {
    }

    public int obtenerPrecioCompra(){
        return this.precioCompra;
    }
    
    public int obtenerPrecioVenta(){
        return this.precioCompra;
    }
    public boolean construirNave(int turnoJugador) {
        if(this.velocidadDeConstruccion == turnoJugador){
            return this.construido;
        }else{
         return this.construido = false;
        }
    }
}
