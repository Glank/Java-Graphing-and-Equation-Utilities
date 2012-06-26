package ksydfius.equation;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

public class Equation {
	public static void main(String[] args){
		String a = "and(7,5)";
		Equation equ = new Equation(a);
		System.out.println(equ.getValue());
	}
	private Node rootnode;
	private HashMap<String, Variable> variables;
	
	public Equation (String a){
		variables = new HashMap<String, Variable>();
		rootnode = getNode(a);
	}
	
	public Vector<Variable> getVariables(){
		Vector<Variable> ret = new Vector<Variable>();
		for(Entry<String, Variable> entry:variables.entrySet())
			ret.add(entry.getValue());
		return ret;
	}
	
	public void set(String var, Double d){
		Variable v = variables.get(var);
		if(v!=null)
			v.setValue(d);
	}
	
	public Double getValue(){
		return rootnode.getValue();
	}
	
	private int indOfOutP( char op, String equ ){
		int PDepth = 0;
		
		for (int i = 0; i < equ.length(); i++){
			if (equ.charAt(i) == '(')
				PDepth++;
			else if (equ.charAt(i) == ')')
				PDepth--;
			else if (PDepth == 0){
				if (equ.charAt(i) == op)
					return i;
			}
		}
		return -1;
	}
	
	private Node getNode(String equ){
		Node ret;
		ret = getNextAdd(equ);
		if (ret != null) return ret;
		ret = getNextSub(equ);
		if (ret != null) return ret;
		ret = getNextMul(equ);
		if (ret != null) return ret;
		ret = getNextDiv(equ);
		if (ret != null) return ret;
		ret = getNextExp(equ);
		if (ret != null) return ret;
		ret = getNextMod(equ);
		if (ret != null) return ret;
		
		if (equ.startsWith("(") && equ.endsWith(")"))
			return getNode(equ.substring(1, equ.length() - 1));
		
		if (equ.endsWith(")"))
			ret = getNextPrefixFunction(equ);
		if (ret != null) return ret;
		
		try{
			Double.parseDouble(equ);
			return new Number(equ);
		}catch (Throwable t){
			Variable v = variables.get(equ);
			if(v==null){
				v = new Variable(equ);
				variables.put(equ, v);
			}
			return v;
		}
		
	}
	
	private Add getNextAdd(String equ){
		int a = indOfOutP('+', equ);
		if (a == -1)
			return null;
		String left = equ.substring(0, a);
		String right = equ.substring(a + 1);
		Node n1 = getNode(left);
		Node n2 = getNode(right);
		return new Add(n1, n2);
	}
	
	private Subtract getNextSub(String equ){
		int a = indOfOutP('-', equ);
		if (a == -1)
			return null;
		if (a == 0)
			return null;
		String left = equ.substring(0, a);
		String right = equ.substring(a + 1);
		Node n1 = getNode(left);
		Node n2 = getNode(right);
		return new Subtract(n1, n2);
	}
	
	private Multiply getNextMul(String equ){
		int a = indOfOutP('*', equ);
		if (a == -1)
			return null;
		String left = equ.substring(0, a);
		String right = equ.substring(a + 1);
		Node n1 = getNode(left);
		Node n2 = getNode(right);
		return new Multiply(n1, n2);
	}
	
	private Divide getNextDiv(String equ){
		int a = indOfOutP('/', equ);
		if (a == -1)
			return null;
		String left = equ.substring(0, a);
		String right = equ.substring(a + 1);
		Node n1 = getNode(left);
		Node n2 = getNode(right);
		return new Divide(n1, n2);
	}
	
	private Exponent getNextExp(String equ){
		int a = indOfOutP('^', equ);
		if (a == -1)
			return null;
		String left = equ.substring(0, a);
		String right = equ.substring(a + 1);
		Node n1 = getNode(left);
		Node n2 = getNode(right);
		return new Exponent(n1, n2);
	}
	
	private Modulus getNextMod(String equ){
		int a = indOfOutP('%', equ);
		if (a == -1)
			return null;
		String left = equ.substring(0, a);
		String right = equ.substring(a + 1);
		Node n1 = getNode(left);
		Node n2 = getNode(right);
		return new Modulus(n1, n2);
	}
	
	private Function getNextPrefixFunction(String equ){
		int a = equ.indexOf("(");
		String prefix = equ.substring(0, a);
		equ = equ.substring(a+1, equ.length() - 1);
		
		Vector<String> parts = new Vector<String>();
		int j = indOfOutP(',',equ);
		while(j!=-1){
			parts.add(equ.substring(0,j));
			equ = equ.substring(j+1);
			j = indOfOutP(',',equ);
		}
		parts.add(equ);
		
		Vector<Node> ofNodes = new Vector<Node>();
		
		for (String s:parts)
			ofNodes.add(getNode(s));
		
		Node nodes[] = new Node[ofNodes.size()];
		
		for (int i = 0; i < nodes.length; i++)
			nodes[i] = ofNodes.get(i);
		
		if (prefix.equals("sin"))
			return new Sine(nodes[0]);
		if (prefix.equals("cos"))
			return new Cosine(nodes[0]);
		if (prefix.equals("tan"))
			return new Tangent(nodes[0]);
		if (prefix.equals("csc"))
			return new Cosecant(nodes[0]);
		if (prefix.equals("cot"))
			return new Cotangent(nodes[0]);
		if (prefix.equals("sec"))
			return new Secant(nodes[0]);
		if (prefix.equals("acos"))
			return new ArcCos(nodes[0]);
		if (prefix.equals("asin"))
			return new ArcSin(nodes[0]);
		if (prefix.equals("atan"))
			return new ArcTan(nodes[0]);
		if (prefix.equals("asec"))
			return new ArcSec(nodes[0]);
		if (prefix.equals("acsc"))
			return new ArcCsc(nodes[0]);
		if (prefix.equals("acot"))
			return new ArcCot(nodes[0]);
		if (prefix.equals("log"))
			return new Log10(nodes[0]);
		if (prefix.equals("ln"))
			return new Ln(nodes[0]);
		if (prefix.equals("xor"))
			return new XOR(nodes[0], nodes[1]);
		if (prefix.equals("and"))
			return new AND(nodes[0], nodes[1]);
		if (prefix.equals("or"))
			return new OR(nodes[0], nodes[1]);
		if (prefix.equals("not"))
			return new NOT(nodes[0]);
		
		return new Function(prefix, nodes);
		
	}
	
	@Override
	public String toString(){
		return rootnode.toString();
	}
	
}