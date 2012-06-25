package kirstein.graphing;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class GraphDisplayDialog extends JDialog{
	private static final long serialVersionUID = -4702578915770384486L;

	private GraphComponent graph;
	private GraphDisplayDialog(Graph g){
		graph = new GraphComponent(g);
		setLayout(new BorderLayout());
		add(graph, BorderLayout.CENTER);
		pack();
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void show(Graph g){
		GraphDisplayDialog gdd = new GraphDisplayDialog(g);
		gdd.setVisible(true);
	}
	
	public static void show(String xequation){
		XEquation equation = new XEquation(xequation);
		Graph g = new Graph();
		g.addEquation(equation);
		show(g);
	}
}
