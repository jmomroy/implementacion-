import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;


public class linear {

	double[]x={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	double[]y={1,1,0,1,0,1,1,0,1,0,1,0,1,0,1,0,0,0,1,1};
	////////////////////////////////////////////////
	//Agregando librerias 
	SimpleRegression sr=new SimpleRegression();
	Plot2DPanel plot =new Plot2DPanel ();
	JTextArea resultados=new JTextArea();
	
	//////////////////////////////
	public linear() {
		for(int I=0;I<x.length;I++){
			sr.addData(x[I],y[I]);
			}
		double []yc=new double [y.length];
		for(int I=0;I<x.length;I++){
			yc[I]=sr.predict(x[I]);
			plot.addLegend("South");
			plot.addScatterPlot("datos", x,y);
			plot.addLinePlot("Regresion",x, yc);
					
		BaseLabel titulo=new BaseLabel("regresion lineal",java.awt.Color.BLUE , 0.5,1.1);
			plot.addPlotable(titulo);
			
			resultados.setBackground(Color.LIGHT_GRAY);
			resultados.append("datos leidos" +sr.getN());
			
			
			JFrame frame=new JFrame ("regresion lineal");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(600,500);
			frame.add(plot,BorderLayout.CENTER);
		
			frame.add(resultados,BorderLayout.SOUTH);
			frame.setVisible(true);
		}
	}
		public static void main (String[]arg){
new linear ();			
		}
}
