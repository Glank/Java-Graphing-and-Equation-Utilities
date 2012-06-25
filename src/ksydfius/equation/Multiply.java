package ksydfius.equation;

public class Multiply extends Operation{

	public Multiply(Node n1, Node n2) {
		super("*", n1, n2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getValue() {
		Double v1 = node1.getValue();
		Double v2 = node2.getValue();
		if (v1==null || v2==null)
			return null;
		return v1*v2;
	}

}
