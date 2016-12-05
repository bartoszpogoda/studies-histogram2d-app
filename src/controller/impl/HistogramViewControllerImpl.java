package controller.impl;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.HistogramViewController;
import dom.Point;
import exceptions.DataNotSetException;
import exceptions.ParametersNotSetException;
import gui.HistogramView;
import gui.MainWindowView;
import model.HistogramModel;

public class HistogramViewControllerImpl implements HistogramViewController {

	private HistogramView histogramView;
	private HistogramModel histogramModel;
	private MainWindowView mainWindowView;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!arg0.isShiftDown()) return;
		
		int x = arg0.getX();
		int y = arg0.getY();

		int translatedX = x;
		int translatedY = histogramView.getHeight() - y;
		
		
		
		try {
			histogramModel.addScaledPoint(new Point(translatedX,translatedY), histogramView.getWidth(), histogramView.getHeight());
		} catch (DataNotSetException e1) {
			mainWindowView.reportError("Najpierw wczytaj dane");
			return;
		}
		
		try {
			histogramModel.recalculate();
			histogramView.repaint();
		} catch (ParametersNotSetException e) {
			return;
		} catch (DataNotSetException e) {
			return;
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHistogramView(HistogramView histogramView) {
		this.histogramView = histogramView;
		
	}

	@Override
	public void setHistogramModel(HistogramModel histogramModel) {
		this.histogramModel = histogramModel;
		
	}

	@Override
	public void setMainWindowView(MainWindowView mainWindowView) {
		this.mainWindowView = mainWindowView;
		
	}
	
}
