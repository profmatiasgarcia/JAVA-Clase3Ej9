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
public class Vuelo {

    private int num;
    private int totalLug;
    private int lugOcup;

    public Vuelo() {
        num = EntradaSalida.leerInt("Ingrese el numero del vuelo: ");
        totalLug = EntradaSalida.leerInt("Ingrese el total de lugares: ");
        lugOcup = 0;
    }

    public Vuelo(int n, int l, int ocup) {
        num = n;
        totalLug = l;
        lugOcup = ocup;
    }

    public Vuelo(int n, int l) {
        this(n, l, 0);
    }

    public int getNum() {
        return num;
    }

    public int getTotalLug() {
        return totalLug;
    }

    public int getLugOcup() {
        return lugOcup;
    }

    public boolean hayLugar() {
        return lugOcup < totalLug;
    }

    public int lugaresVacios() {
        return totalLug - lugOcup;
    }

    public void actualizarOcupados(int r) {
        lugOcup = lugOcup + r;
    }
}
