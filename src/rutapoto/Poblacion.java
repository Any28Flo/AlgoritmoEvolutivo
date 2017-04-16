/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutapoto;

import java.util.Arrays;

/**
 *
 * @author Pc
 */
public class Poblacion {

    private Individuo[] pob;
    private double[] apt;

    public Poblacion(int tamPob) {
        pob = new Individuo[tamPob];
        for (int i = 0; i < tamPob; i++) {
            pob[i] = new Individuo();
        }
    }

    public Poblacion(int tamPob, int x) {
        pob = new Individuo[tamPob];
    }

    public Individuo[] getPob() {
        return pob;
    }

    public Individuo getInd(int index) {
        return pob[index];
    }

    public double[] evaPob() {
        apt = new double[pob.length];

        for (int i = 0; i < pob.length; i++) {

            apt[i] = pob[i].getAptitud();

          
              System.out.println("aptitud: " + apt[i]);
        }
        return apt;
    }

    public void mejor() {

        double mejor = pob[0].getAptitud();
        int[] genesMejor = pob[0].getGenes();
        for (int i = 0; i < pob.length; i++) {
            if (pob[i].getAptitud() < mejor) {
                mejor = pob[i].getAptitud();
                genesMejor = pob[i].getGenes();
            }

        }
        System.out.println("***************************");
        System.out.println("El mejor es " + mejor);
        //System.out.println("Individuo: " + Arrays.toString(genesMejor));
        //return apt;
    }

    public double mejorApt() {
        double mejor = pob[0].getAptitud();
        for (int i = 0; i < pob.length; i++) {
            if (pob[i].getAptitud() < mejor) {
                mejor = pob[i].getAptitud();

            }

        }
        return mejor;
    }
     public double aptgeneracion(int tamPob) {
        double promedio = pob[0].getAptitud();
        double prom=0;
        for (int i = 0; i < pob.length; i++) {
            
                promedio += pob[i].getAptitud();


        }
        prom=promedio/tamPob;
        return prom;
    }

    public void verPoblacion() {
        for (int i = 0; i < pob.length; i++) {
            System.out.print("Ind " + i + ":");
            pob[i].verImdividuo();

        }
    }

    public void agregarPoblacion(Individuo[] hijos, int index) {
        this.pob[index] = hijos[0];
        this.pob[index + 1] = hijos[1];
    }

    public int getMejor() {
        double mejor = apt[0];
        int pos = 0;
        for (int i = 0; i < apt.length; i++) {

            if ( apt[i]<mejor ) {
                mejor = apt[i];
                
                pos = i;
            }
        }
        System.out.println("Mejor individuo:"+mejor);
        return pos;
    }

    public double promedio() {
        double pro = 0;
        for (int i = 0; i < apt.length; i++) {

            pro += apt[i];
        }
        return pro;

    }
}
