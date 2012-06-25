package tests;

import kirstein.graphing.Graph;
import kirstein.graphing.GraphDisplayDialog;
import kirstein.graphing.XEquation;

public class GraphDisplayTest {
	public static void main(String[] args){
		Graph g = new Graph();
		XEquation equation = new XEquation("(1-x*x)^.5");
		g.addEquation(equation);
		equation = new XEquation("x*x");
		g.addEquation(equation);
		equation = new XEquation("sin(2*x)+cos(x*5)");
		g.addEquation(equation);
		g.getDimensions().setXMin(-2);
		g.getDimensions().setXMax(2);
		g.getDimensions().setYMin(-2);
		g.getDimensions().setYMax(2);
		g.getSettings().xTickDistance = .1;
		g.getSettings().xTickHeight = 5;
		g.getSettings().yTickDistance = .1;
		g.getSettings().yTickWidth = 5;
		GraphDisplayDialog.show(g);
	}
}
