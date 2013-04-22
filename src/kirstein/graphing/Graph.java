package kirstein.graphing;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class Graph{
	private GraphDimensions dimensions;
	private Vector<DrawableEquation> equations;
	private GraphSettings settings;
	
	public Graph(){
		dimensions = new GraphDimensions();
		settings = new GraphSettings();
		equations = new Vector<DrawableEquation>();
		
	}

	public void zoomOut( double scaleFactor ){
		double height = dimensions.getYMax() - dimensions.getYMin();
		double width = dimensions.getXMax() - dimensions.getXMin();
		double centerx, centery;
		
		centerx = width/2 + dimensions.getXMin();
		centery = height/2 + dimensions.getYMin();
		height *= scaleFactor;
		width *= scaleFactor;
		
		dimensions.setXMin(centerx - width/2);
		dimensions.setXMax(centerx + width/2);
		dimensions.setYMin(centery - height/2);
		dimensions.setYMax(centery + height/2);
		
		settings.xTickDistance *= scaleFactor;
		settings.yTickDistance *= scaleFactor;
		
	}
	
	public void zoomIn( double scaleFactor ){
		double height = dimensions.getYMax() - dimensions.getYMin();
		double width = dimensions.getXMax() - dimensions.getXMin();
		double centerx, centery;
		
		centerx = width/2 + dimensions.getXMin();
		centery = height/2 + dimensions.getYMin();
		height /= scaleFactor;
		width /= scaleFactor;
		
		dimensions.setXMin(centerx - width/2);
		dimensions.setXMax(centerx + width/2);
		dimensions.setYMin(centery - height/2);
		dimensions.setYMax(centery + height/2);
		
		settings.xTickDistance /= scaleFactor;
		settings.yTickDistance /= scaleFactor;
		
		
	}
	
	public GraphDimensions getDimensions() {
		return dimensions;
	}
	public void setDimensions(GraphDimensions dimensions) {
		this.dimensions = dimensions;
	}
	public void clearEquations(){
		equations.clear();
	}
	public void removeEquation(DrawableEquation equation) {
		equations.remove(equation);
	}
	public void addEquation(DrawableEquation equation) {
		equations.add(equation);
	}
	public GraphSettings getSettings() {
		return settings;
	}
	public void setSettings(GraphSettings settings) {
		this.settings = settings;
	}
	public void drawTo(Graphics g){
		if(settings.drawXAxis)
			drawXAxis(g);
		if(settings.drawYAxis)
			drawYAxis(g);
		if(settings.drawXTicks)
			drawXTicks(g);
		if(settings.drawYTicks)
			drawYTicks(g);
		for(int i = 0; i < equations.size(); i++)
			drawEquation(equations.get(i),g);
	}
	
	public void drawLine(GraphPoint gp1, GraphPoint gp2, Graphics g){
		Point p1 = dimensions.getPoint(gp1);
		Point p2 = dimensions.getPoint(gp2);
		drawLine(p1,p2,g);
	}
	
	public void drawLine(Point p1, Point p2, Graphics g){
		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}
	
	public void drawXAxis(Graphics g){
		GraphPoint xAxisStart = new GraphPoint(dimensions.getXMin(), 0);
		GraphPoint xAxisEnd = new GraphPoint(dimensions.getXMax(), 0);
		drawLine(xAxisStart, xAxisEnd, g);
	}
	
	public void drawYAxis(Graphics g){
		GraphPoint yAxisStart = new GraphPoint(0, dimensions.getYMin());
		GraphPoint yAxisEnd = new GraphPoint(0, dimensions.getYMax());
		drawLine(yAxisStart, yAxisEnd, g);
	}
	
	public void drawXTicks(Graphics g){
		double yStart = dimensions.getYUnitsPerPixel()*settings.xTickHeight;
		double yEnd = -yStart;
		GraphPoint gp1 = new GraphPoint(0,yStart);
		GraphPoint gp2 = new GraphPoint(0,yEnd);
		for(double x = 0; x >= dimensions.getXMin(); x-=settings.xTickDistance){
			gp1.x = x;
			gp2.x = x;
			drawLine(gp1,gp2,g);
			drawString(x+"", gp1, g);
		}
		for(double x = 0; x <= dimensions.getXMax(); x+=settings.xTickDistance){
			gp1.x = x;
			gp2.x = x;
			drawLine(gp1,gp2,g);
			drawString(x+"", gp1, g);
		}
	}
	
	public void drawYTicks(Graphics g){
		double xStart = dimensions.getXUnitsPerPixel()*settings.yTickWidth;
		double xEnd = -xStart;
		GraphPoint gp1 = new GraphPoint(xStart,0);
		GraphPoint gp2 = new GraphPoint(xEnd,0);
		for(double y = 0; y >= dimensions.getYMin(); y-=settings.yTickDistance){
			gp1.y = y;
			gp2.y = y;
			drawLine(gp1,gp2,g);
			drawString(y+"", gp1, g);
		}
		for(double y = 0; y <= dimensions.getYMax(); y+=settings.yTickDistance){
			gp1.y = y;
			gp2.y = y;
			drawLine(gp1,gp2,g);
			drawString(y+"", gp1, g);
		}
	}
	
	public void drawEquation(DrawableEquation equation, Graphics g){
		Iterable<GraphPoint> points = equation.getPoints(dimensions);
		GraphPoint last = null;
		for(GraphPoint p:points){
			if(Double.isInfinite(p.x) || Double.isInfinite(p.y) || Double.isNaN(p.x) || Double.isNaN(p.y))
				p = null;
			if(last!=null && p!=null)
				drawLine(last, p, g);
			last = p;
		}
	}

	public void MoveUp( double percentage ){
		double height = dimensions.getYMax() - dimensions.getYMin();
		dimensions.setYMin(dimensions.getYMin()+percentage*height);
		dimensions.setYMax(dimensions.getYMax()+percentage*height);
	}
	
	public void MoveDown( double percentage ){
		double height = dimensions.getYMax() - dimensions.getYMin();
		dimensions.setYMin(dimensions.getYMin()-percentage*height);
		dimensions.setYMax(dimensions.getYMax()-percentage*height);
	}
	
	public void MoveLeft( double percentage ){
		double width = dimensions.getXMax() - dimensions.getXMin();
		dimensions.setXMin(dimensions.getXMin()-percentage*width);
		dimensions.setXMax(dimensions.getXMax()-percentage*width);
	}
	
	public void MoveRight( double percentage ){
		double width = dimensions.getXMax() - dimensions.getXMin();
		dimensions.setXMin(dimensions.getXMin()+percentage*width);
		dimensions.setXMax(dimensions.getXMax()+percentage*width);
	}
	public void center(){
		double height = dimensions.getYMax() - dimensions.getYMin();
		double width = dimensions.getXMax() - dimensions.getXMin();
		dimensions.setXMax(width/2);
		dimensions.setXMin(-width/2);
		dimensions.setYMax(height/2);
		dimensions.setYMin(-height/2);
	}
	
	public void translate(double dx, double dy){
		dimensions.setXMin(dimensions.getXMin()+dx);
		dimensions.setXMax(dimensions.getXMax()+dx);
		dimensions.setYMin(dimensions.getYMin()+dy);
		dimensions.setYMax(dimensions.getYMax()+dy);
		
	}
}
