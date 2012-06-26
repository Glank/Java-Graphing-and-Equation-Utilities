package ksydfius.equation;

public class ArcCot extends Function{

	public ArcCot(Node n) {
		super("acot", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.atan(1/v);
		return null;
	}
}
