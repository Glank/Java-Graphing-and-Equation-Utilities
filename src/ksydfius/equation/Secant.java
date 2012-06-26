package ksydfius.equation;

public class Secant extends Function{

	public Secant(Node n) {
		super("sec", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return 1/(Math.cos(v));
		return null;
	}
}
