package controller;

import java.awt.event.ActionListener;

import gui.HistogramView;
import gui.MainWindowView;
import helper.PointListReader;
import model.HistogramModel;

public interface Controller extends ActionListener {
	public void setMainWindowView(MainWindowView mainWindowView);
	public void setHistogramView(HistogramView histogramView);
	public void setHistogramModel(HistogramModel histogramModel);
	public void setPointListReader(PointListReader pointListReader);
	
}
