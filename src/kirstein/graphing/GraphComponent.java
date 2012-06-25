package kirstein.graphing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GraphComponent extends Component{
	private static final long serialVersionUID = -1955652602049891826L;
	private Graph graph;
	
	public GraphComponent(Graph graph){
		this.setGraph(graph);
		int width = graph.getDimensions().getWidth();
		int height = graph.getDimensions().getHeight();
		setPreferredSize(new Dimension(width,height));
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		graph.getDimensions().setWidth(getWidth());
		graph.getDimensions().setHeight(getHeight());
		g.setColor(Color.BLACK);
		graph.drawTo(g);
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}
}
