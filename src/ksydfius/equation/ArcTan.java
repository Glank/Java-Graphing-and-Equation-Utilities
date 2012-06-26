package ksydfius.equation;

public class ArcTan extends Function{

	public ArcTan(Node n) {
		super("atan", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.atan(v);
		return null;
	}
}
