package ksydfius.equation;

public class ArcSec extends Function{

	public ArcSec(Node n) {
		super("asec", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.acos(1/v);
		return null;
	}
}
