package ksydfius.equation;

public class Exponent extends Operation{

	public Exponent(Node n1, Node n2) {
		super("^", n1, n2);
	}

	@Override
	public Double getValue() {
		Double v1 = node1.getValue();
		Double v2 = node2.getValue();
		if (v1==null || v2==null)
			return null;
		return Math.pow(v1,v2);
	}
}
