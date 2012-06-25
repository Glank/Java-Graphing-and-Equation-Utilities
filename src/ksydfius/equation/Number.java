package ksydfius.equation;

public class Number extends Node{

	private Double value;
	
	public Number(String a) {
		super(a);
		try{
			value = Double.parseDouble(a);
		}catch (Throwable t){
			throw new RuntimeException();
		}
		
	}

	@Override
	public Double getValue() {
		return value;
	}
	public Node[] getChildren() {
		return new Node[0];
	}
}
