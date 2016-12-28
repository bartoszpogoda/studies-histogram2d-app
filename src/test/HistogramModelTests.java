package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exceptions.DataNotSetException;
import exceptions.ParametersNotCorrectException;
import exceptions.ParametersNotSetException;
import gui.impl.HistogramViewImpl;
import helper.Point;
import model.HistogramModel;
import model.impl.HistogramModelImpl;

public class HistogramModelTests {

	@Test
	public void test1() throws ParametersNotSetException, ParametersNotCorrectException, DataNotSetException {
		
		HistogramModel histogram = new HistogramModelImpl();
		
		int nx = 2, ny = 2, xmin = 0, ymin = 0, 
				xmax = 100, ymax = 100;
		
		histogram.setNx(nx);
		histogram.setNy(ny);
		
		histogram.setXMin(xmin);
		histogram.setYMin(ymin);
		
		histogram.setXMax(xmax);
		histogram.setYMax(ymax);
		
		List<Point> listOfPoints = new ArrayList<Point>();
		
		listOfPoints.add(new Point(45,45));

		listOfPoints.add(new Point(10,60));
		listOfPoints.add(new Point(10,100));
		
		listOfPoints.add(new Point(60,42));
		listOfPoints.add(new Point(60,32));
		listOfPoints.add(new Point(60,30));
		
		listOfPoints.add(new Point(50,50));
		listOfPoints.add(new Point(99,99));
		listOfPoints.add(new Point(99,99));
		listOfPoints.add(new Point(100,100));
		
		histogram.setData(listOfPoints);
		histogram.recalculate();
		

		assertEquals(1, histogram.getHistogramValues()[0][0]);
		assertEquals(2, histogram.getHistogramValues()[0][1]);
		assertEquals(3, histogram.getHistogramValues()[1][0]);
		assertEquals(4, histogram.getHistogramValues()[1][1]);
		
		
		}
	
}