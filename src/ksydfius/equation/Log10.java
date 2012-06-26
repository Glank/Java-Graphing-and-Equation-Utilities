package ksydfius.equation;

public class Log10 extends Function{

	public Log10(Node n) {
		super("log", n);
		// TODO Auto-generated constructor stub
	}
	public Double getValue(){
		Double v = nodes[0].getValue();
		if (v != null)
			return Math.log10(v);
		return null;
	}
}
