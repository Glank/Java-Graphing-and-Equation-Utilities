package ksydfius.equation;

public class Cosecant extends Function{

	public Cosecant(Node n) {
		super("csc", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return 1/(Math.sin(v));
		return null;
	}
}
