package Ej4arraylistSerializable;
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
import java.util.*;

public class Main {

    static double prom;

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int op;

        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
        do {
            Alumno alu = new Alumno(); // hago una referencia para cada alumno
            
            System.out.println("Ingrese el nombre del alumno:");
            alu.setNom(leer.next());
            System.out.println("Ingrese la primera calificación:");
            alu.setCalif1(leer.nextInt());
            System.out.println("Ingrese la segunda calificación:");
            alu.setCalif2(leer.nextInt());
            System.out.println("Ingrese la tercera calificación:");
            alu.setCalif3(leer.nextInt());

            listaAlumnos.add(alu);

            System.out.println("¿Desea ingresar otro alumno?");
            System.out.println("1.-Si\t 2.-No");
            op = leer.nextInt();
        } while (op != 2);

        System.out.println("==========================");
        CrearArchivoSecuencialDeArrayList aplicacion = new CrearArchivoSecuencialDeArrayList();
        aplicacion.abrirArchivo("src/main/resources/alumnos.ser");
        aplicacion.agregarUnArrayList(listaAlumnos);// grabo al archivo
        aplicacion.cerrarArchivo();

        //-----LECTURA-----
        ArrayList<Alumno> listaAlumnos2 = new ArrayList<Alumno>();// armo otra lista

        LeerArchivoSecuencialDeArrayList aplicacion2 = new LeerArchivoSecuencialDeArrayList();
        aplicacion2.abrirArchivo("src/main/resources/alumnos.ser");
        listaAlumnos2 = (ArrayList<Alumno>) aplicacion2.leerArrayList(); // leo del  archivo  y lo  guardo  en el arrayneuvo
        aplicacion2.cerrarArchivo();

        List listaAlu = new ArrayList<Alumno>(listaAlumnos2);
        Iterator it = listaAlu.iterator(); // todos los objetos se can recorrer
        // con el iterator
        while (it.hasNext()) {
            System.out.println(it.next() + "");
        }
    }
}
