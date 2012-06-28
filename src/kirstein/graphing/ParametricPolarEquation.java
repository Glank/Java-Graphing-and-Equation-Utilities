package kirstein.graphing;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Vector;

import ksydfius.equation.Equation;
import ksydfius.equation.Variable;

public class ParametricPolarEquation implements DrawableEquation{
	public Equation equtheta;
	public Equation equr;
	public Variable t_theta;
	public Variable t_r;
	public double tstart,tend,dt;
	
	public ParametricPolarEquation(String equ_theta, String equ_r, double tstart, double tend, double dt){
		this.tstart = tstart;
		this.tend = tend;
		this.dt = dt;
		
		equtheta = new Equation(equ_theta);
		equr = new Equation(equ_r);
		Vector<Variable> variables = equtheta.getVariables();
		if(variables.size()==0){
			t_theta = new Variable("t");
		}
		else{
			if(variables.size()!=1)
				throw new EquationException("Invalid Theta Equation: " + equ_theta);
			t_theta = variables.firstElement();
			if(!t_theta.getName().equals("t"))
				throw new EquationException("Invalid Theta Equation: " + equ_theta);
		}
			variables = equr.getVariables();
		if(variables.size()==0){
			t_r = new Variable("r");
		}
		else{
			if(variables.size()!=1)
				throw new EquationException("Invalid R Equation: " + equ_r);
			t_r = variables.firstElement();
			if(!t_r.getName().equals("t"))
				throw new EquationException("Invalid R Equation: " + equ_r);
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
			t_theta.setValue(i);
			t_r.setValue(i);
			double theta = equtheta.getValue();
			double r = equr.getValue();
			double x = getX(theta, r);
			double y = getY(theta, r);
			points.add(new GraphPoint(x,y));
			
		}
		return points;
	}
}
