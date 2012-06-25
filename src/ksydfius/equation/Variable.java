package ksydfius.equation;

public class Variable extends Node{
	
	private Double value;
	
	public String getName(){
		return str;
	}
	
	public void setValue(Double v){
		value = v;
	}
	
	public Variable(String a) {
		super(a);
	}

	@Override
	public Double getValue() {
		if (value != null) return value;
		
		if (toString().equals("pi"))
			return Math.PI;
		if (toString().equals("e"))
			return Math.E;
		return null;
	}
	public Node[] getChildren() {
		return new Node[0];
	}
	
	@Override
	public String toString(){
		if(value!=null)
			return value.toString();
		else
			return super.toString();
	}
}
