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
public class Cruza {
 
    public Individuo[] porCiclos(Individuo [] padres)
    {
        Individuo[] hijos = new Individuo[2];
        int[] padre1 = padres[0].getGenes();
        int[] madre1 = padres[1].getGenes();
       
        int h1[] = new int[padre1.length];
        int h2[] = new int[padre1.length];
        

        Aleatorios rnd = new Aleatorios(1, 5);
        
        int a = rnd.generar();
       System.out.println("Inicio del ciclo" + a);
        int inicio =padre1[a];
        int paro = inicio;
        int buscar = inicio;
        int i = 0;
        do {
            if (padre1[i] == buscar) {
                h1[i] = padre1[i];
                h2[i] = madre1[i];
                buscar = madre1[i];
                if (madre1[i] == paro) {
                    break;
                } else {
                    i = 0;
                }
            } else {
                i++;
            }
        } while (true);
        for (int j = 1; j < h1.length - 1; j++) {
           if (h1[j] == 0) {
                h1[j] = madre1[j];
            }
            if (h2[j] == 0) {
               h2[j] = padre1[j];
            }

        }
        h1[0] = 1;
        h1[7] = 1;
        h2[0] = 1;
        h2[7] = 1;
          
      
        hijos[0] = new Individuo(h2);
        hijos[1] = new Individuo(h1);
        
     return hijos;
    }
    
    //cruce por ciclos
    public Individuo [] xCiclos ( Individuo[] padre){ 
        Individuo[] hijo = new Individuo[2];
        Random rnd = new Random();
        
        int k = rnd.nextInt(5)+1; 
        //System.out.println("Ciclo:"+k);
        int i=0;
        int pos=k;
        int[][] padres = new int[2] [padre[0].getGenes().length];
        
        padres[0]= padre[0].getGenes();
        padres[1]= padre[1].getGenes();
                
       
        
        int[][] hijos = new int[2][padres[0].length];
        
        //imprime valor de padres en la posicion k
       //System.out.println("P1:" + padres[0][k]);
       //System.out.println("P2:" + padres[1][pos]);
        
        hijos[0][k]=padres[0][k];
        hijos[1][pos]=padres[1][pos];
       
        //busca el ciclo en los padres y rellena los hijos.
        //encuentra un ciclo que se define mediante las posiciones de los valores entre p1 y p2
        while (padres[0][k] != padres[1][pos]){
            if (padres[1][pos] == padres[0][i]) {
                pos=i;
                i=0;
                
                //copiar de los padres a los hijos los valores que esten en el ciclo.
                hijos[0][pos]=padres[0][pos];
                hijos[1][pos]=padres[1][pos];
        
               // System.out.println(padres[1][pos]);
            }else {
                
                i++;
            }
        }      
        
        //rellenando espacios vacios de hijos, intercambiando los valores de los padres
         for (int j=0; j< padres[0].length; j++){
        
            if (hijos[0][j] ==0){
            hijos[0][j] =padres[1][j];
            hijos[1][j] =padres[0][j];
            }
        }
        hijo[0] = new Individuo(hijos[0]);
        hijo[1] = new Individuo(hijos[1]);
        return hijo;
    }
}
