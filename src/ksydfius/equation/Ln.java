package ksydfius.equation;

public class Ln extends Function{

	public Ln(Node n) {
		super("ln", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.log(v);
		return null;
	}
}
