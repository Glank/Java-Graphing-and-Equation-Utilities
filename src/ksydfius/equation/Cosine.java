package ksydfius.equation;

public class Cosine extends Function{

	public Cosine(Node n) {
		super("cos", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.cos(v);
		return null;
	}
}
