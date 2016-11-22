package controller.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
import gui.HistogramView;
import gui.MainWindowView;
import model.HistogramModel;

public class ControllerImpl implements Controller {

	private MainWindowView mainWindowView;
	private HistogramView histogramView;
	
	private HistogramModel histogramModel;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMainWindow(MainWindowView mainWindowView) {
		this.mainWindowView = mainWindowView;
	}

	@Override
	public void setHistogramView(HistogramView histogramView) {
		this.histogramView = histogramView;
	}

	@Override
	public void setHistogramModel(HistogramModel histogramModel) {
		this.histogramModel = histogramModel;
	}

}
