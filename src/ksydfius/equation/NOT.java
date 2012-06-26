package ksydfius.equation;

public class NOT extends Function{

	public NOT(Node n) {
		super("not", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return (double)(~((int)(double)v));
		return null;
	}
}
