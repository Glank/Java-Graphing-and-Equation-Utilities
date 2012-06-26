package ksydfius.equation;

public class Cotangent extends Function{

	public Cotangent(Node n) {
		super("cot", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return 1/(Math.tan(v));
		return null;
	}
}
