package model;

import java.util.List;

import dom.Point;
import exceptions.ParametersNotSetException;

public interface HistogramModel {
	public void setXMin(int xmin);
	public void setXMax(int xmax);
	public void setYMin(int ymin);
	public void setYMax(int ymax);
	public void setNx(int nx);
	public void setNy(int ny);
	
	public void setData(List<Point> listOfPoints);
	public void recalculate() throws ParametersNotSetException;
	
	public int[][] getHistogramValues();
	public int getHistogramMaxValue();
	public int getNx();
	public int getNy();
}
