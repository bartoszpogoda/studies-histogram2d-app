package model;

import java.util.List;

import exceptions.DataNotSetException;
import exceptions.ParametersNotSetException;
import helper.Point;

public interface HistogramModel {
	public void setXMin(int xmin);
	public void setXMax(int xmax);
	public void setYMin(int ymin);
	public void setYMax(int ymax);
	public void setNx(int nx);
	public void setNy(int ny);
	
	public void setData(List<Point> listOfPoints);
	public void addPoint(Point point) throws DataNotSetException;
	public void addScaledPoint(Point point,int width, int height) throws DataNotSetException;
	public void recalculate() throws ParametersNotSetException, DataNotSetException;
	
	public int[][] getHistogramValues();
	public int getHistogramMaxValue();
	public int getNx();
	public int getNy();
}
