package kirstein.graphing;

import java.awt.Point;

public class GraphDimensions {
	private double xMin = -100, xMax = 100, yMin = -100, yMax = 100;
	private int width = 500, height = 500;
	
	public Point getPoint(GraphPoint p){
		double xUnitsOver = p.x-xMin;
		double yUnitsUp = p.y-yMin;
		double pixelsOver = xUnitsOver/getXUnitsPerPixel();
		double pixelsUp = yUnitsUp/getYUnitsPerPixel();
		int x = (int)pixelsOver;
		int y = height-(int)pixelsUp;
		return new Point(x,y);
	}
	
	public GraphPoint getGraphPoint(Point p){
		int pixelsOver = p.x;
		int pixelsUp = height-p.y;
		double xUnitsOver = pixelsOver*getXUnitsPerPixel();
		double yUnitsUp = pixelsUp*getYUnitsPerPixel();
		double x = xMin+xUnitsOver;
		double y = yMin+yUnitsUp;
		return new GraphPoint(x,y);
	}
	
	public double getXMin() {
		return xMin;
	}

	public void setXMin(double xMin) {
		this.xMin = xMin;
	}

	public double getXMax() {
		return xMax;
	}

	public void setXMax(double xMax) {
		this.xMax = xMax;
	}

	public double getYMin() {
		return yMin;
	}

	public void setYMin(double yMin) {
		this.yMin = yMin;
	}

	public double getYMax() {
		return yMax;
	}

	public void setYMax(double yMax) {
		this.yMax = yMax;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getXUnitsPerPixel(){
		return (xMax-xMin)/width;
	}
	
	public double getYUnitsPerPixel(){
		return (yMax-yMin)/height;
	}
}
