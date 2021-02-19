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
import java.io.Serializable;

public class Alumno implements Serializable {//si no se pone el serializable no se puede usar el output etc	private String nom;

    private String nom;
    private int calif1;
    private int calif2;
    private int calif3;

    public Alumno() {
    }

    public int getCalif1() {
        return calif1;
    }

    public void setCalif1(int calif1) {
        this.calif1 = calif1;
    }

    public int getCalif2() {
        return calif2;
    }

    public void setCalif2(int calif2) {
        this.calif2 = calif2;
    }

    public int getCalif3() {
        return calif3;
    }

    public void setCalif3(int calif3) {
        this.calif3 = calif3;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString() {
        return nom + " notas: " + calif1 + " " + calif2 + " " + calif3;
    }

}
