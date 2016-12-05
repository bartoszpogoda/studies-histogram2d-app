package model;

import java.util.List;

import dom.Point;
import exceptions.DataNotSetException;
import exceptions.ParametersNotSetException;

public class HistogramModelImpl implements HistogramModel {

	private int[][] histogramValues; // 0 - nx ; 0 - ny

	private int xmin, ymin, xmax, ymax;

	private int nx, ny;

	private List<Point> listOfPoints;

	@Override
	public void setXMin(int xmin) {
		this.xmin = xmin;
	}

	@Override
	public void setXMax(int xmax) {
		this.xmax = xmax;
	}

	@Override
	public void setYMin(int ymin) {
		this.ymin = ymin;
	}

	@Override
	public void setYMax(int ymax) {
		this.ymax = ymax;
	}

	@Override
	public void setNx(int nx) {
		this.nx = nx;
	}

	@Override
	public void setNy(int ny) {
		this.ny = ny;
	}

	public void setData(List<Point> listOfPoints) {
		this.listOfPoints = listOfPoints;
	}

	@Override
	public void addPoint(Point point) throws DataNotSetException {
		if(listOfPoints == null) throw new DataNotSetException();
		
		this.listOfPoints.add(point);
		
	}
	@Override
	public void recalculate() throws ParametersNotSetException, DataNotSetException {
		if (nx == 0 | ny == 0)
			throw new ParametersNotSetException();

		if(listOfPoints == null)
			throw new DataNotSetException();
		
		histogramValues = new int[nx][ny];

		for (int[] row : histogramValues) {
			for (int v : row) {
				v = 0;
			}
		}

		for (Point p : listOfPoints) {

			// odfiltrowuje spoza przedzia³u
			if (p.getX() < xmin || p.getX() > xmax || p.getY() < ymin || p.getY() > ymax)
				continue;

			// jesli na krawedzi to do n w kierunku min, dla 0 nx = 1
			int x = -1;
			int y = -1;

			float scalex = ((float) p.getX() - xmin) / (xmax - xmin);
			float scaledNx = scalex * nx;

			if (scalex >= 1)
				x = nx - 1; //
			else {
				x = (int) (scaledNx); // zaokr¹glenie w dó³
			}

			if (x >= nx)
				x--;

			float scaley = ((float) p.getY() - ymin) / (ymax - ymin);
			float scaledNy = scaley * ny;

			if (scaley >= 1)
				y = ny - 1; //
			else {
				y = (int) (scaledNy); // zaokr¹glenie w dó³
			}

			if (y >= ny)
				y--;
			
			histogramValues[x][y]++;

		}

	}

	@Override
	public int[][] getHistogramValues() {
		return histogramValues;
	}

	@Override
	public int getHistogramMaxValue() {
		int histogramMaxValue = 0;

		if(histogramValues == null) return histogramMaxValue;
		
		for (int[] row : histogramValues) {
			for (int v : row) {
				if (v > histogramMaxValue)
					histogramMaxValue = v;
			}
		}

		return histogramMaxValue;
	}

	@Override
	public int getNx() {
		return this.nx;
	}

	@Override
	public int getNy() {
		return this.ny;
	}

}