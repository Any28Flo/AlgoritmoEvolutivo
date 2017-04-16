/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutapoto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Pc
 */
public class Individuo {
    private final int genes[];
    private double aptitud;
    /*private final double distancia [][]={
                               {0,12.0,13.5,16.0,8.9,17.3},
                               {12.0,0,25.5,28.0,20.9,29.3},
                               {13.5,25.5,0,11.0,4.6,3.8},
                               {16.0,28.0,11.0,0,15.6,8.1},
                               {8.9,20.9,4.6,15.6,0,8.4},
                               {17.3,29.3,3.8,8.1,8.4,0}
        };*/
     private final double distancia [][]={
                               {0,2.0,6.0,6.0,6.0,2.0},
                               {2.0,0,6.0,2.0,6.0,6.0},
                               {6.0,6.0,0,2.0,2.0,6.0},
                               {6.0,2.0,2.0,0,6.0,6.0},
                               {6.0,6.0,2.0,6.0,0,2.0},
                               {2.0,6.0,6.0,6.0,2.0,0}
        };
   
     public Individuo() {
        this.genes = new int[(distancia.length+1)];
        llenar();
    }
     
    /*public Individuo() {
        this.genes = new int[7];
        llenar();
    }*/
    
    public Individuo(int[] genes) {
        this.genes = genes;
    }
        private void llenar() {
        ArrayList<Integer> l = new ArrayList();
         
        int valor_inicial = 2;
        int valor_final = this.distancia.length;
        Arrays.fill(this.genes,0);
        this.genes[0] = 1;
        this.genes[this.genes.length-1] = 1;
         
        for (int i = valor_inicial; i <= valor_final; i++) {
            l.add(i);
        }
         
        int cont=1;
        Random ale = new Random();
        int n;
        while(l.size()>0){
            n = ale.nextInt(l.size());
            this.genes[cont++] = l.get(n);
            l.remove(n);
        }
    }
     

   /* private void llenar() {
        genes[0] = 1;
        genes[6] = 1;

        Random ale = new Random();
        int n = ale.nextInt(6 - 2 + 1) + 2;
        for (int i = 1; i < genes.length - 1; i++) {
            if (existe(genes, n)) {
                while ((n == 0 || (existe(genes, n)))) {
                    n = ale.nextInt(6 - 2 + 1) + 2;

                }
            }
            genes[i] = n;

        }
    }*/
    
    

    public int[] getGenes() {
        return genes;
    }

    public double getAptitud() {
        aptitud();
        return aptitud;
    }

    public boolean existe(int[] genes, int n) {
        boolean exist = false;
        for (int j = 0; j < genes.length - 1; j++) {
            if (genes[j] == n) {
                exist = true;
            }
        }
        return exist;
    }
    public void aptitud() {
         
        double suma = 0;
        for (int i = 0; i < this.distancia.length; i++) {
            suma += this.distancia[this.genes[i]-1][this.genes[i+1]-1];
        }
        this.aptitud = suma;
    }
    /*public void aptitud() {
        ArrayList<Double> dis = new ArrayList();
        for (int i = 0; i < this.genes.length - 1; i++) {
            int x = distancia.length;
            for (int f = 0; f < x; f++) {
                for (int c = 0; c < x; c++) {
                    int g = genes[i] - 1;
                    int g2 = genes[i + 1] - 1;
                    if (f == g && c == g2) {

                        // System.out.print("[" + distancia[f][c] + "]");
                        dis.add(distancia[f][c]);
                    }
                }
            }

        }
        double suma = 0;
        for (int o = 0; o < dis.size(); o++) {
            //System.out.println(dis.get(o));
            suma += dis.get(o);

        }
        aptitud = suma;
        //System.out.println(aptitud);
        
    }*/
     public void verImdividuo() {
         System.out.print("[ ");
        for (int i = 0; i < genes.length; i++) {
            System.out.print(genes[i]+" | ");
        }
         System.out.println("]");

    }
    public void mutarIntercambio(){
         int porcentaje = 50;
         mutarIntercambio(porcentaje);
     }
      
     public void mutarIntercambio(int porcentaje){
        int probabilidad;
         
        //Revisar que la probabilidad de mutacion sea entre 0 y 100
        probabilidad = (porcentaje < 0) ? 1 : porcentaje;
        probabilidad = (probabilidad > 100) ? 100 : probabilidad;
         
        Random rdm = new Random();
        int valor_inicial = 2;
        int valor_final = this.distancia.length;
        int n;
        int p;
        int aux_intercambio;
         for (int i = valor_inicial-1; i < valor_final; i++) {
             p = rdm.nextInt(101);
             if(p<=probabilidad){
                 do {
                     n = rdm.nextInt((valor_final-1) - (valor_inicial-1) + 1) + (valor_inicial-1);
                 } while (this.genes[i] == n);
                 aux_intercambio = this.genes[i];
                 this.genes[i] = this.genes[n];
                 this.genes[n] = aux_intercambio;
             }
              
         }
     }
}
