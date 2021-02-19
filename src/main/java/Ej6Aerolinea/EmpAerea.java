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
public class EmpAerea {

    private ConjVuelos cVuelos;
    private ConjReservas cReservas;
    private String mensaje;

    public EmpAerea() {
        char opc;
        cVuelos = new ConjVuelos();
        opc = EntradaSalida.leerChar("¿El archivo de vuelos ya fue creado ? S/N: ");
        if (opc == 's' || opc == 'S') {
            cVuelos.agregarVuelosDesdeArchivo();
        } else {
            cVuelos.agregarVuelosDesdeTeclado();
        }
        mensaje = "Operaciones para la compañia aerea\n";
        mensaje += "1 - Agregar vuelo\n";
        mensaje += "2 - Ingresar una reserva\n";
        mensaje += "3 - Mostrar vuelos\n";
        mensaje += "4 - Mostrar reservas\n";
        mensaje += "\n\nIngrese un numero de opcion";
    }

    public void ejecutar() {
        cReservas = new ConjReservas();
        menu();
        actualizarArchivoDeVuelos();
    }

    public void actualizarArchivoDeVuelos() {
        CrearArchivoDeVuelos a = new CrearArchivoDeVuelos();
        a.abrirArchivo("src/main/resources/ConjuntoDeVuelos.txt");
        a.agregarRegistrosDesdeConjDeVuelos(cVuelos);
        a.cerrarArchivo();
    }

    public void mostrarVuelos() {
        LeerArchivoDeVuelos archivo = new LeerArchivoDeVuelos();
        archivo.abrirArchivo("src/main/resources/ConjuntoDeVuelos.txt");
        archivo.mostrarDatosDelArchivoVuelosPorPantalla();
        archivo.cerrarArchivo();
    }

    public void menu() {

        int opcion = EntradaSalida.leerInt(mensaje);
        //EntradaSalida.imprimir(String.valueOf(opcion) + " antes del if");

        if (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) {
            while (true) {
                switch (opcion) {
                    case 1 -> cVuelos.agregarVuelosDesdeTeclado();

                    case 2 -> cReservas.ingresarReservas(cVuelos);

                    case 3 -> {
                        actualizarArchivoDeVuelos();
                        this.mostrarVuelos();
                    }

                    case 4 -> cReservas.mostrarReservas();
                }

                opcion = EntradaSalida.leerInt(mensaje);
                //EntradaSalida.imprimir(String.valueOf(opcion) + " antes de cerrar while");
                if (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
                    System.exit(1);
                }
            }
        }
    }
}
