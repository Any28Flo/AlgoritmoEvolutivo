/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutapoto;

import java.util.Random;

/**
 *
 * @author Pc
 */
public class Mutacion {
    int [][] auxhijos= new int[2][7];
    int [] auxhijocruza= new int[7];
    int [] auxhijo2cruza= new int[7];
    Individuo[] hijos= new Individuo[2];
    Random rdn = new Random();
    public Individuo[] muta (Individuo [] hijos)
    {
        
        //Individuo[] hijos = new Individuo[2];
        int[] hijo1 = hijos[0].getGenes();
        int[] hijo2 = hijos[1].getGenes();
       
        Random rnd = new Random();
        int k1 = rnd.nextInt(5)+1; 
         int k2= rnd.nextInt(5)+1;
          while(k1== k2) k2= rnd.nextInt(5)+1; 
       

       int aux=0 ;
       aux= hijo1[k1];
       hijo1[k1]=hijo1[k2];
       hijo1[k2]=aux;
       
       /***hijo 2**/
   
      
        hijos[0] = new Individuo(hijo1);
        hijos[1] = new Individuo(hijo2);
     return hijos;
   
    }
     public Individuo[] llamaMutacion (Individuo[] padres){
    
       for (int i=0; i<padres[0].getGenes().length; i++){
              // .getIndividuo().length; i++){
       int [][] auxpadres = new int[2][10];
       //muta cada jornada
       auxpadres[0] = padres[0].getGenes();
       auxpadres[1] = padres[1].getGenes();
              
       
       auxhijos [0] = intercambio(auxpadres[0]);
       auxhijos [1] = intercambio(auxpadres[1]);
       
       
       auxhijocruza = auxhijos[0];
       auxhijo2cruza = auxhijos[1];
       }
       
        hijos[0] = new Individuo(auxhijocruza);
        hijos[1] = new Individuo(auxhijo2cruza);
        //se imprimen los indiiduos
        for (Individuo individuo : hijos) {
            individuo.verImdividuo();
            System.out.println(" ");
        }
    return hijos;

    
    } 
     public int[] intercambio (int[] hijos){
    
        
        
        int k1 = rdn.nextInt(5)+1; 
         int k2 = rdn.nextInt(5)+1; 
        int aux=0;
        
        aux=hijos[k1];
        hijos[k1]=hijos[k2];
        hijos[k2]=aux;
        
        return hijos;
    }
    
    boolean resul;

    public void setr(boolean resul) {
        this.resul = resul;
    }

    public boolean MutarIndividuo(Double tazaMutacion) {
        boolean mutara = false;
        Random r = new Random();
        double randomx = 0 + (1 - 0) * r.nextDouble();
        if (randomx < tazaMutacion) {
            mutara = true;
        }
        //System.out.println("Muto:" + mutara);
        this.setr(mutara);
        return mutara;
    }
    public  boolean MutaIndividuo(int tazaMutacion) {
        
        Random ram = new Random();
        boolean muta = false;
        
        int mt=ram.nextInt(100);
        if (mt<tazaMutacion) {
            muta=true;
            
        }
        //System.out.println("mt: " + mt);
        return muta;
        
        
    }
    
    
 
}
