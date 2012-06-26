package ksydfius.equation;

public class ArcCsc extends Function{

	public ArcCsc(Node n) {
		super("acsc", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.asin(1/v);
		return null;
	}
}
