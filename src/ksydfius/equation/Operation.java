package ksydfius.equation;

public abstract class Operation extends Node{
	
	protected Node node1;
	protected Node node2;
	
	public Operation(String a, Node n1, Node n2) {
		super(a);
		node1 = n1;
		node2 = n2;
		
	}

	@Override
	public abstract Double getValue();
	@Override
	public Node[] getChildren() {
		return new Node[]{node1,node2};
	}
	
	@Override
	public String toString(){
		String str = "";
		if(node1.getClass().equals(getClass()) || !(node1 instanceof Operation))
			str += node1.toString();
		else
			str += "(" + node1 + ")";
		str += super.toString();
		if(node2.getClass().equals(getClass()) || !(node2 instanceof Operation))
			str += node2.toString();
		else
			str += "(" + node2 + ")";
		return str;
	}
}
