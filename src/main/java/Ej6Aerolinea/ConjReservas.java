package Ej6Aerolinea;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2017 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */
import java.util.ArrayList;

//import java.util.Scanner;
public class ConjReservas {

    private ArrayList cr;

    public ConjReservas() {
        cr = new ArrayList();
    }

    public void ingresarReservas(ConjVuelos cVuelo) {
        char opc = 's';
        // opc = EntradaSalida.leerChar("Ingresa reserva? s/n");
        while (opc == 's' || opc == 'S') {
            Reserva res = new Reserva();
            Vuelo v = null;
            int nroVuelo = res.getNVuelo();

            if (cVuelo.indexOf(nroVuelo) == -1) {
                EntradaSalida.imprimir("Vuelo inexistente.\nReserva no realizada.");
            } else {
                v = cVuelo.get(cVuelo.indexOf(nroVuelo));
                if (v.lugaresVacios() < res.getCantReserva()) {
                    EntradaSalida.imprimir("Hay " + v.lugaresVacios() + " lugares vacios.\nReserva no realizada.");
                } else {
                    cr.add(res);
                    v.actualizarOcupados(res.getCantReserva());
                }
            }
            opc = EntradaSalida.leerChar("¿Ingresa más reservas? S/N: ");
        }
        // mostrarReservas();
    }

    public void mostrarReservas() {
        String renglon = "";
        for (int i = 0; i < cr.size(); i++) {
            Reserva r = (Reserva) cr.get(i);
            renglon = renglon + "Número de reserva: " + r.getNumR() + "\nNúmero de vuelo: " + r.getNVuelo()
                    + "\nCantidad reservada: " + r.getCantReserva() + "\n\n";
        }
        EntradaSalida.imprimir(renglon);
    }

}
