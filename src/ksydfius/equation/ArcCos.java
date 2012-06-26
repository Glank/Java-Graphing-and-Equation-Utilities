package ksydfius.equation;

public class ArcCos extends Function{

	public ArcCos(Node n) {
		super("acos", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.acos(v);
		return null;
	}
}
