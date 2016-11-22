package controller;

import java.awt.event.ActionListener;

import gui.HistogramView;
import gui.MainWindowView;
import model.HistogramModel;

public interface Controller extends ActionListener {
	public void setMainWindow(MainWindowView mainWindowView);
	public void setHistogramView(HistogramView histogramView);
	public void setHistogramModel(HistogramModel histogramModel);
	
}
