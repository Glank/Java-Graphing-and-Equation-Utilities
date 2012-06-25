package kirstein.graphing;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Vector;

import ksydfius.equation.Equation;
import ksydfius.equation.Variable;

public class XEquation implements DrawableEquation{
	public Equation equ;
	public Variable x;
	
	public XEquation(String equation){
		equ = new Equation(equation);
		Vector<Variable> variables = equ.getVariables();
		if(variables.size()!=1)
			throw new EquationException("Invalid X Equation: " + equation);
		x = variables.firstElement();
		if(!x.getName().equals("x"))
			throw new EquationException("Invalid X Equation: " + equation);
	}

	@Override
	public Iterable<GraphPoint> getPoints(GraphDimensions dimensions) {
		LinkedList<GraphPoint> points = new LinkedList<GraphPoint>();
		for(int i = 0; i < dimensions.getWidth(); i++){
			GraphPoint p = dimensions.getGraphPoint(new Point(i, 0));
			x.setValue(p.x);
			Double val = equ.getValue();
			if(val==null)
				throw new EquationException("Invalid X Equation: " + equ.toString());
			p.y = val;
			points.add(p);
		}
		return points;
	}
}
