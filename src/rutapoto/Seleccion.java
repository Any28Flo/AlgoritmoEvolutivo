/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutapoto;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Pc
 */
public class Seleccion {

   // static ArrayList<Individuo> concursantes = new ArrayList();
    public int seTorneo(int k, double[] apt) {
        //declaración de variables
        int posSelecc = 0;

        //generación de número aleatorio
        int a = (int) (Math.random() * apt.length );
        int b = (int) (Math.random() * apt.length );

       // System.out.println("na1: " + a + " na2: " + b);

        posSelecc = apt[a]< apt[b] ? a : b;

        return posSelecc;
    }
    

    public int torneo(int k, double[] apt) {
        //declaración de variables
        int posSelecc = 0;
        int[] concursantes = new int[k];
        //generación de número aleatorio
        int a = (int) (Math.random() * apt.length);
        int b = (int) (Math.random() * apt.length);

        for (int i = 0; i < k; i++) {
            concursantes[i] = (int) (Math.random() * apt.length - 1);
           // System.out.println(concursantes[i]);
        }

        posSelecc = concursantes[0];
        //System.out.println("na1: " + a +" na2: "+ b  );
        for (int j = 0; j < concursantes.length - 1; j++) {

            posSelecc = apt[concursantes[j]] < apt[posSelecc] ? concursantes[j] : posSelecc;
        }

        return posSelecc;
    }

}
