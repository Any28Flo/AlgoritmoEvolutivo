/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rutapoto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Instituto
 */
public class Grafica extends JFrame {
    JPanel panel;
   
    public Grafica(double[] elites, double[] promedio){
        setTitle("Grafica Ruta Potrobus");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init(elites, promedio);
        
    }
 
    private void init(double[] elites, double[] promedio) {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        
        for (int i=0; i< elites.length ; i++){
        
        line_chart_dataset.addValue(elites[i], "elite", "Gen" +(i+1));
        line_chart_dataset.addValue(promedio[i], "promedio", "Gen" +(i+1));
        } 
 
        // Creando el Grafico
        JFreeChart chart=ChartFactory.createLineChart("Ruta",
                "No. Generaciones","Aptitud",line_chart_dataset,PlotOrientation.VERTICAL,
                true,true,false);  
        
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
}
 








