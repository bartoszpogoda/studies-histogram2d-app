package controller.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import controller.Controller;
import controller.PointListReader;
import exceptions.DataNotSetException;
import exceptions.NumberOfCordinatesNotEvenException;
import exceptions.ParametersNotSetException;
import gui.HistogramView;
import gui.MainWindowView;
import model.HistogramModel;

public class ControllerImpl implements Controller {

	private MainWindowView mainWindowView;
	private HistogramView histogramView;
	
	private HistogramModel histogramModel;
	private PointListReader pointListReader;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equalsIgnoreCase("BTN_REDRAW")){
			int xmin,xmax,ymin,ymax,nx,ny;
			try{
				xmin = Integer.parseInt(mainWindowView.getXMin());
				xmax = Integer.parseInt(mainWindowView.getXMax());
				ymin = Integer.parseInt(mainWindowView.getYMin());
				ymax = Integer.parseInt(mainWindowView.getYMax());
				nx = Integer.parseInt(mainWindowView.getNx());
				ny = Integer.parseInt(mainWindowView.getNy());
			} catch(NumberFormatException e){
				mainWindowView.reportError("Wszystkie parametry musza byc liczbami calkowitymi");
				return;
			}
			
			if((nx <= 0 || ny <= 0 || xmin >= xmax || ymin >= ymax)){
				mainWindowView.reportError("Parametry nie sa poprawne (min<=max, n>0)");
				return;
			}
				
			
			histogramModel.setXMin(xmin);
			histogramModel.setXMax(xmax);
			histogramModel.setYMin(ymin);
			histogramModel.setYMax(ymax);
			histogramModel.setNx(nx);
			histogramModel.setNy(ny);
			
			try {
				histogramModel.recalculate();
			} catch (ParametersNotSetException e) {
				mainWindowView.reportError("Wszystkie parametry musza byc ustawione");
				return;
			} catch (DataNotSetException e) {
				mainWindowView.reportError("Brak danych");
				return;
			}
			
			histogramView.repaint();
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("BTN_LOAD")){
			String filename;
			
			filename =  mainWindowView.getFilename();
			
			try {
				pointListReader.setFileInputStream(filename);
			} catch (FileNotFoundException e) {
				mainWindowView.reportError("B³¹d odczytu pliku");
				return;
			}
			
			try {
				histogramModel.setData(pointListReader.read());
			} catch (NumberOfCordinatesNotEvenException e) {
				mainWindowView.reportError("Nieprawid³owa iloœæ danych w pliku");
				histogramModel.setData(null);
				return;
			}
			
			mainWindowView.reportSuccess("Dane za³adowane pomyœlnie");
			
		}

	}

	@Override
	public void setMainWindowView(MainWindowView mainWindowView) {
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

	@Override
	public void setPointListReader(PointListReader pointListReader) {
		this.pointListReader = pointListReader;
	}

}
