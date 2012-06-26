package ksydfius.equation;

public class AND extends Function{

	public AND(Node n1, Node n2) {
		super("and", n1, n2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	
	public Double getValue(){
		if (nodes[0].getValue() == null || nodes[1].getValue() == null) return null;
		return (double) ((int)((double)nodes[0].getValue()) & (int)((double)nodes[1].getValue()));
	}
	
}

