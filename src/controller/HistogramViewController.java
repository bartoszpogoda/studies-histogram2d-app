package controller;

import java.awt.event.MouseListener;

import gui.HistogramView;
import gui.MainWindowView;
import model.HistogramModel;

public interface HistogramViewController extends MouseListener {
	public void setHistogramView(HistogramView histogramView);
	public void setHistogramModel(HistogramModel histogramModel);
	public void setMainWindowView(MainWindowView mainWindowView);
	
}
