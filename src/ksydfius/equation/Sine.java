package ksydfius.equation;

public class Sine extends Function{

	public Sine(Node n) {
		super("sin", n);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.sin(v);
		return null;
	}
	
}

