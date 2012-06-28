package kirstein.graphing;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Vector;

import ksydfius.equation.Equation;
import ksydfius.equation.Variable;

public class ThetaEquation implements DrawableEquation{
	public Equation equ;
	public Variable theta;
	public double tstart,tend,dt;
	
	public ThetaEquation(String equation, double tstart, double tend, double dt){
		this.tstart = tstart;
		this.tend = tend;
		this.dt = dt;
		
		equ = new Equation(equation);
		Vector<Variable> variables = equ.getVariables();
		if(variables.size()==0){
			theta = new Variable("t");
		}
		else{
			if(variables.size()!=1)
				throw new EquationException("Invalid Theta Equation: " + equation);
			theta = variables.firstElement();
			if(!theta.getName().equals("t"))
				throw new EquationException("Invalid Theta Equation: " + equation);
		}
	}
	
	public double getY(double theta, double r){
		return r * Math.sin(theta);
	}
	
	public double getX(double theta, double r){
		return r * Math.cos(theta);
	}

	@Override
	public Iterable<GraphPoint> getPoints(GraphDimensions dimensions) {
		LinkedList<GraphPoint> points = new LinkedList<GraphPoint>();
		for(double i = tstart; i < tend; i+=dt){
			theta.setValue(i);
			double r = equ.getValue();
			double x = getX(i, r);
			double y = getY(i, r);
			points.add(new GraphPoint(x,y));
		}
		return points;
	}
}
