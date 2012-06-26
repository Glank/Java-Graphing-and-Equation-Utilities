package ksydfius.equation;

import java.util.Vector;

public class test {
	public static void main (String[] args){
		String equ = "xor(51,7),sin(3)";
		Vector<String> parts = new Vector<String>();
		int j = indOfOutP(',',equ);
		while(j!=-1){
			parts.add(equ.substring(0,j));
			equ = equ.substring(j+1);
			j = indOfOutP(',',equ);
		}
		parts.add(equ);
		for (int i = 0; i < parts.size(); i++)
			System.out.println(parts.get(i));
	}
	
	private static int indOfOutP( char op, String equ ){
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
	
}
