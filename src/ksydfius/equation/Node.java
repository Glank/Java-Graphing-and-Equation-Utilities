package ksydfius.equation;

public abstract class Node {
	String str;
	public abstract Node[] getChildren();
	public abstract Double getValue();
	@Override
	
	public String toString(){
		return str;
	}
	public Node(String a){
		str = a;
	}
}
