package ksydfius.equation;

public class Tangent extends Function{

	public Tangent(Node n) {
		super("tan", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.tan(v);
		return null;
	}
}
