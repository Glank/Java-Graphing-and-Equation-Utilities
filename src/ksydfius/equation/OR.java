package ksydfius.equation;

public class OR extends Function{

	public OR(Node n1, Node n2) {
		super("or", n1, n2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	
	public Double getValue(){
		Double v1 = nodes[0].getValue();
		Double v2 = nodes[1].getValue();
		if (nodes[0].getValue() != null || nodes[1].getValue() != null)
			return (double) ((int)((double)v1) | (int)((double)v2));
		return null;
	}
	
}

