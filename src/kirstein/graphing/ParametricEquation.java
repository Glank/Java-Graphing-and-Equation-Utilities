package kirstein.graphing;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Vector;

import ksydfius.equation.Equation;
import ksydfius.equation.Variable;

public class ParametricEquation implements DrawableEquation{
	public Equation equx;
	public Equation equy;
	public Variable tx;
	public Variable ty;
	public double tstart,tend,dt;
	
	public ParametricEquation(String equ_x, String equ_y, double tstart, double tend, double dt){
		this.tstart = tstart;
		this.tend = tend;
		this.dt = dt;
		
		equx = new Equation(equ_x);
		equy = new Equation(equ_y);
		Vector<Variable> variables = equx.getVariables();
		if(variables.size()!=1)
			throw new EquationException("Invalid X Equation: " + equ_x);
		tx = variables.firstElement();
		if(!tx.getName().equals("t"))
			throw new EquationException("Invalid X Equation: " + equ_x);
		
		variables = equy.getVariables();
		if(variables.size()!=1)
			throw new EquationException("Invalid Y Equation: " + equ_y);
		ty = variables.firstElement();
		if(!ty.getName().equals("t"))
			throw new EquationException("Invalid Y Equation: " + equ_y);
	}

	@Override
	public Iterable<GraphPoint> getPoints(GraphDimensions dimensions) {
		LinkedList<GraphPoint> points = new LinkedList<GraphPoint>();
		for(double i = tstart; i < tend; i+=dt){
			tx.setValue(i);
			ty.setValue(i);
			points.add(new GraphPoint(equx.getValue(), equy.getValue()));
			
		}
		return points;
	}
}
