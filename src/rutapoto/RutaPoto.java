package rutapoto;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Pc
 */
public class RutaPoto {

    /**
     * @param args the command line arguments
     */
    private ArrayList<Individuo> numIndividuos = new ArrayList<>();
    private static ArrayList<Poblacion> generaciones = new ArrayList<>();

    private static Individuo[] padres;
   
    private static Individuo[] hijos;
    private static Poblacion newPob;

    public static void main(String[] args) {
        // TODO code application logic here
        Seleccion seleccion = new Seleccion();
        Cruza cruce = new Cruza();

        int tamPob = 10;
        int probMutacion=0;
        int numGeneraciones =10;
        int k = 3;
        double apt[] = new double[tamPob];
        double aptMejores[]= new double[numGeneraciones];
        double mejores[]= new double[numGeneraciones];
        double promMejor[]= new double[numGeneraciones];
        Poblacion pob;
        
        /*
         poblacion inicial
         */
        pob = new Poblacion(tamPob);
        generaciones.add(pob);
        
        //generaciones
        for (int j = 0; j < numGeneraciones; j++) {

            //variable nueva poblacion
            newPob = new Poblacion(tamPob, 1);
            int indContador = 0;
            System.out.println("Generacion "+j);
            generaciones.get(j).verPoblacion();

            apt = generaciones.get(j).evaPob();
            
            int posMejor=generaciones.get(j).getMejor();
           // System.out.println("El");
            //pob.mejor();
            aptMejores[j]=pob.aptgeneracion(tamPob);
           // System.out.println("*******************");
           // System.out.println("El mejor es el individuo :"+posMejor);
//          mejores[j]=apt[mejores];
            promMejor[j]=generaciones.get(j).promedio();
            System.out.println("Promedio generacion: "+promMejor[j]);
            /*
             genera nueva poblacion
             */
            for (int i = 0; i < tamPob / 2; i++) {

                padres = new Individuo[2];

                padres[0] = generaciones.get(j).getInd(seleccion.seTorneo(k, apt));
                padres[1] = generaciones.get(j).getInd(seleccion.seTorneo(k, apt));
                
               // System.out.println("Individuos más aptos:");
                 //padres[0].verImdividuo();
               //  padres[1].verImdividuo();
               // System.out.println("Hijos:");

               // hijos = new Individuo[2];

                hijos = cruce.xCiclos(padres);

                //hijos[0].verImdividuo();
                //hijos[1].verImdividuo();

                /*System.out.println("");
                 Mutacion mutacion= new Mutacion();
                 
                 boolean muta= mutacion.MutarIndividuo(probMutacion);
                       
                 if(muta==true)
                 {
                    // System.out.println("Mutacion: ");
                 //hijos= mutacion.llamaMutacion(hijos);
                     //hijos=mutacion.muta(hijos);
                 }*/
                hijos[0].mutarIntercambio(probMutacion);
                hijos[1].mutarIntercambio(probMutacion);
                 
                newPob.agregarPoblacion(hijos, indContador);
                indContador += 2;
            }

            generaciones.add(newPob);
            //System.out.println("Individuos más aptos:");
             
            System.out.println("");
           // System.out.println("El mejor es el individuo :"+posMejor);
            mejores[j]=apt[posMejor];
            
        }
        for (int i = 0; i < promMejor.length; i++) {
            System.out.println(+promMejor[i]);
            
        }
         new Grafica(mejores, promMejor).setVisible(true);
    }

}
