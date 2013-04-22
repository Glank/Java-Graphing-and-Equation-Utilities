package tests;

import kirstein.graphing.Graph;
import kirstein.graphing.GraphDisplayDialog;
import kirstein.graphing.GraphPoint;
import kirstein.graphing.ParametricEquation;
import kirstein.graphing.ParametricPolarEquation;
import kirstein.graphing.ThetaEquation;
import kirstein.graphing.XEquation;

// parametric polar, theta polar

public class GraphDisplayTest {
	public static void main(String[] args){
		Graph g = new Graph();
		XEquation equation = new XEquation("sin(x)");
		g.addEquation(equation);
		g.addPoint(new GraphPoint(1,2));
		g.addPoint(new GraphPoint(3,3));
		/*
		ParametricEquation equation2 = new ParametricEquation("t^2", "t*2", 0, 2*Math.PI, 0.01);
		g.addEquation(equation2);
		equation = new ParametricEquation("sin(2*x)+cos(x*5)");
		g.addEquation(equation);
		*/
		g.getDimensions().setXMin(-30);
		g.getDimensions().setXMax(30);
		g.getDimensions().setYMin(-30);
		g.getDimensions().setYMax(30);
		g.getSettings().xTickDistance = 5;
		g.getSettings().xTickHeight = 5;
		g.getSettings().yTickDistance = 5;
		g.getSettings().yTickWidth = 5;
		GraphDisplayDialog.show(g);
	}
}
