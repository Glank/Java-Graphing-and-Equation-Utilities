package ksydfius.equation;

public class XOR extends Function{

	public XOR(Node n1, Node n2) {
		super("xor", n1, n2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	
	public Double getValue(){
		Double v1 = nodes[0].getValue();
		Double v2 = nodes[1].getValue();
		if (v1 == null || v2 == null) return null;
		return (double) ((int)((double)v1) ^ (int)((double)v2));
	}
	
}

