package Mapa_Otros;

import Constructores.*;
import Naves.*;
import java.util.Scanner;

/**
 *
 * @author Luis
 */
public class Tienda {

    private static final Scanner scanner = new Scanner(System.in);
    private Obrero[] obrerosEnVenta;
    private Maestro_De_Obra[] maestrosDeObrasEnventa;
    private Ingeniero[] ingenierosEnVenta;
    private Nave[] navesEnVenta;

    /**
     * Al inicio la tienda tiene 5 constructor de cada tipo para vender y 0
     * naves
     */
    public Tienda() {
        this.obrerosEnVenta = new Obrero[5];
        this.maestrosDeObrasEnventa = new Maestro_De_Obra[5];
        this.ingenierosEnVenta = new Ingeniero[5];
        this.navesEnVenta = new Nave[0];
    }

    /**
     * Se agrega el/los obrero/s que el jugador quiera vender en tienda
     *
     * @param obreroAvender
     * @param cantidadObreros
     */
    public void agregarObreroATienda(Obrero obreroAvender, int cantidadObreros) {
        aumentarTamañoArregloObreros(obrerosEnVenta, obreroAvender, cantidadObreros);

    }

    /**
     * se agrega el/los maestrosDeObra a la tienda
     *
     * @param maestroDeObra
     * @param cantidadMaestrosDeObraAVender
     */
    public void agregarMaestroDeObraATienda(Maestro_De_Obra maestroDeObra, int cantidadMaestrosDeObraAVender) {
        aumentarTamañoArregloMaestros(maestrosDeObrasEnventa, maestroDeObra, cantidadMaestrosDeObraAVender);

    }

    /**
     * Se agrega los el/los ingenieros a la tienda
     *
     * @param ingenieroAVender
     * @param cantidadIngenierosAVender
     */
    public void agregarIngenieroATienda(Ingeniero ingenieroAVender, int cantidadIngenierosAVender) {
        aumentarTamañoArregloIngenieros(ingenierosEnVenta, ingenieroAVender, cantidadIngenierosAVender);
    }

    /**
     * se agrega espacios al arreglo de obreros para añadir obreros que el
     * usuario quiera vender en la tienda
     *
     * @param arregloObreros
     * @param obreroAvender
     */
    public void aumentarTamañoArregloObreros(Obrero[] arregloObreros, Obrero obreroAvender, int cantidadDeObrerosAvender) {
        if (obrerosEnVenta.length == 5) {
            for (int i = 0; i < cantidadDeObrerosAvender; i++) {
                obrerosEnVenta[i] = obreroAvender;
            }
        } else {
            obrerosEnVenta = new Obrero[arregloObreros.length + cantidadDeObrerosAvender];
            //con el arrayCopy, voy a copiar los elementos de arregloObreros a obreros a la venta
            System.arraycopy(arregloObreros, 0, obrerosEnVenta, 0, arregloObreros.length);
            obrerosEnVenta[arregloObreros.length] = obreroAvender;
        }
    }

    /**
     * Tiene la misma lógica que la anterior
     *
     * @param arregloMaestroDeObra
     * @param maestroDeObra
     * @param cantidadMaestroObra
     */
    public void aumentarTamañoArregloMaestros(Maestro_De_Obra[] arregloMaestroDeObra, Maestro_De_Obra maestroDeObra, int cantidadMaestroObra) {
        if (maestrosDeObrasEnventa.length == 5) {
            for (int i = 0; i < cantidadMaestroObra; i++) {
                maestrosDeObrasEnventa[i] = maestroDeObra;
            }
        } else {
            maestrosDeObrasEnventa = new Maestro_De_Obra[arregloMaestroDeObra.length + cantidadMaestroObra];
            //con el arrayCopy, voy a copiar los elementos de arregloMaestroDeObra a maestrsDeObra a la venta
            System.arraycopy(arregloMaestroDeObra, 0, maestrosDeObrasEnventa, 0, maestrosDeObrasEnventa.length);
            maestrosDeObrasEnventa[arregloMaestroDeObra.length] = maestroDeObra;
        }
    }

    public void aumentarTamañoArregloIngenieros(Ingeniero[] arregloIngenieros, Ingeniero ingenieroAVender, int cantidadIngenieroAVender) {
        if (ingenierosEnVenta.length == 5) {
            for (int i = 0; i < cantidadIngenieroAVender; i++) {
                ingenierosEnVenta[i] = ingenieroAVender;
            }
        } else {
            ingenierosEnVenta = new Ingeniero[arregloIngenieros.length + cantidadIngenieroAVender];
            //con el arrayCopy, voy a copiar los elementos de arregloIngenieros a ingenierosEnVenta
            System.arraycopy(arregloIngenieros, 0, ingenierosEnVenta, 0, ingenierosEnVenta.length);
            ingenierosEnVenta[arregloIngenieros.length] = ingenieroAVender;
        }
    }

    public void agregarNaveAlaTienda(Nave naveAVender, int cantidadNavesAvender) {
        aumentarTamañoArregloNaves(navesEnVenta, naveAVender, cantidadNavesAvender);

    }

    public void aumentarTamañoArregloNaves(Nave[] arregloNaves, Nave naveAVender, int cantidadNavesAVender) {
        if (navesEnVenta.length == 0) {
            navesEnVenta = new Nave[1];
            navesEnVenta[0] = naveAVender;
        } else {
            navesEnVenta = new Nave[arregloNaves.length + 1];
            //con el arrayCopy, voy a copiar los elementos de arregloNaves a naves a la venta
            System.arraycopy(arregloNaves, 0, navesEnVenta, 0, arregloNaves.length);
            navesEnVenta[arregloNaves.length] = naveAVender;
        }
    }

    /**
     * se muestra los construcotres que hay en la tienda
     *
     * @param jugador
     */
    public void mostrarConstructoresYNavesAVender(Jugador jugadorDeCompras) {
        int opcionCompra = 0;
        System.out.println("Constructores a la venta:");
        System.out.println("Presione la opción para realizar la compra.");
        System.out.println("1. Obrero \n2. Maestro de Obra \n3. Ingeniero\n4. Naves\n5. Salir de la tienda");
        opcionCompra = scanner.nextInt();

        switch (opcionCompra) {
            case 1:
                venderObrero(jugadorDeCompras);
                break;
            case 2:
                venderMaestroDeObra(jugadorDeCompras);
                break;
            case 3:
                venderIngeniero(jugadorDeCompras);
                break;
            case 4:
                venderNave(jugadorDeCompras);
                break;
            case 5:
                System.out.println("Has salido de la tienda.");
            default:
        }
    }

    public void venderObrero(Jugador jugadorDeCompras) {

        System.out.println(jugadorDeCompras.getNombre() + ", tines: " + jugadorDeCompras.obtenerGalactusGanado() + "galacuts");
        System.out.println("Lo sentimos, la tienda no está terminada");

    }

    public void venderMaestroDeObra(Jugador jugadorDeCompras) {
        System.out.println(jugadorDeCompras.getNombre() + ", tines: " + jugadorDeCompras.obtenerGalactusGanado() + "galacuts");

    }

    public void venderIngeniero(Jugador jugadorDeCompras) {
        System.out.println(jugadorDeCompras.getNombre() + ", tines: " + jugadorDeCompras.obtenerGalactusGanado() + "galacuts");

    }

    public void venderNave(Jugador jugadorDeCompras) {
        System.out.println(jugadorDeCompras.getNombre() + ", tines: " + jugadorDeCompras.obtenerGalactusGanado() + "galacuts");
    }

    public Obrero[] getObreros() {
        return obrerosEnVenta;
    }

    public void setObreros(Obrero[] obreros) {
        this.obrerosEnVenta = obreros;
    }

    public Maestro_De_Obra[] getMaestrosDeObras() {
        return maestrosDeObrasEnventa;
    }

    public void setMaestrosDeObras(Maestro_De_Obra[] maestrosDeObras) {
        this.maestrosDeObrasEnventa = maestrosDeObras;
    }

    public Ingeniero[] getIngenieros() {
        return ingenierosEnVenta;
    }

    public void setIngenieros(Ingeniero[] ingenieros) {
        this.ingenierosEnVenta = ingenieros;
    }
}
