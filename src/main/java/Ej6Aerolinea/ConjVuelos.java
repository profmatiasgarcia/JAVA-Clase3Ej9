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

public class ConjVuelos {

    private ArrayList cv;

    public ConjVuelos() {
        cv = new ArrayList();
    }

    public int indexOf(int nroVuelo) {
        int i;
        for (i = 0; i < cv.size() && ((Vuelo) cv.get(i)).getNum() != nroVuelo; i++)
			;
        return i < cv.size() ? i : -1;
    }

    public void agregarVuelosDesdeTeclado() {
        char opc = 's';
        int n;
        while (opc == 's' || opc == 'S') {
            Vuelo v = new Vuelo();
            n = this.indexOf(v.getNum());
            if (n != -1) {
                EntradaSalida.imprimir("este vuelo ya existe, ingrese otro");
            } else {
                cv.add(v);
                opc = EntradaSalida.leerChar("¿Más vuelos? S/N: ");
            }
        }
        if (cv.size() > 0) {
            grabarEnUnArchivo("src/main/resources/ConjuntoDeVuelos.txt");
        }
    }

    public void agregarVuelosDesdeArchivo() {
        LeerArchivoDeVuelos a = new LeerArchivoDeVuelos();
        a.abrirArchivo("src/main/resources/ConjuntoDeVuelos.txt");
        cv = a.guardarDatosDelArchivoVuelosEnUnArrayList();
        a.cerrarArchivo();
    }

    public void add(Vuelo v) {
        cv.add(v);
    }

    public int size() {
        return cv.size();
    }

    public Vuelo get(int i) {
        return (Vuelo) cv.get(i);
    }

    private void grabarEnUnArchivo(String nomArchivoVuelos) {
        CrearArchivoDeVuelos archivo = new CrearArchivoDeVuelos();
        archivo.abrirArchivo(nomArchivoVuelos);
        archivo.agregarRegistrosDesdeConjDeVuelos(this);
        archivo.cerrarArchivo();
    }
}
