package ksydfius.equation;

public class ArcSin extends Function{

	public ArcSin(Node n) {
		super("asin", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.asin(v);
		return null;
	}
}
