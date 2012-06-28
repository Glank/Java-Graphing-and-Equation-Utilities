package kirstein.graphing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JPanel;

public class GraphComponent extends Component implements KeyListener, MouseWheelListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = -1955652602049891826L;
	private Graph graph;
	private Point mousePress;
	
	public GraphComponent(Graph graph){
		this.setGraph(graph);
		int width = graph.getDimensions().getWidth();
		int height = graph.getDimensions().getHeight();
		setPreferredSize(new Dimension(width,height));
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		addMouseWheelListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
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

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_PLUS || e.getKeyCode() == KeyEvent.VK_EQUALS)
			graph.zoomIn(1.25);
		else if (e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_UNDERSCORE)
			graph.zoomOut(1.25);
		else if (e.getKeyCode() == KeyEvent.VK_UP){
			graph.MoveUp(0.1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN){
			graph.MoveDown(0.1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			graph.MoveLeft(0.1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			graph.MoveRight(0.1);
		}
		else if (e.getKeyCode() == KeyEvent.VK_C || e.getKeyCode() == KeyEvent.VK_SPACE)
			graph.center();
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int notches = e.getWheelRotation();
		if (notches < 0){
			graph.zoomIn(1.25);
			notches = 0;
		}
		else if (notches > 0){
			graph.zoomOut(1.25);
			notches = 0;
		}
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePress = e.getPoint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		if (e.getButton() == MouseEvent.BUTTON3)
			graph.center();
		*/
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		double dx = -graph.getDimensions().getXUnitsPerPixel()*(me.getX() - mousePress.x);
		double dy = graph.getDimensions().getYUnitsPerPixel()*(me.getY() - mousePress.y);
		mousePress = me.getPoint();
		graph.translate(dx,dy);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
