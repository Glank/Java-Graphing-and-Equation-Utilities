package ksydfius.equation;

public class Function extends Node {
	protected Node nodes[];
	
	public Function(String a, Node...ns) {
		super(a);
		nodes = ns;
		
	}

	@Override
	public Double getValue(){
		return null;
	}
	public Node[] getChildren() {
		return nodes;
	}
}
