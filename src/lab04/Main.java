package lab04;

import controller.Controller;
import controller.HistogramViewController;
import controller.PointListReader;
import controller.impl.ControllerImpl;
import controller.impl.HistogramViewControllerImpl;
import exceptions.ParametersNotCorrectException;
import exceptions.ParametersNotSetException;
import gui.HistogramView;
import gui.MainWindowView;
import gui.impl.HistogramViewImpl;
import gui.impl.MainWindowViewImpl;
import model.HistogramModel;
import model.HistogramModelImpl;

public class Main {
	public static void main(String[] args) {
		// appConstruction
		
		HistogramModel histogramModel = new HistogramModelImpl();
		PointListReader pointListReader = new PointListReader();
		
		Controller controller = new ControllerImpl();
		controller.setHistogramModel(histogramModel);
		controller.setPointListReader(pointListReader);
		

		HistogramViewController histogramViewController = new HistogramViewControllerImpl();
		
		
		HistogramView histogramView = new HistogramViewImpl();
		histogramView.setHistogramModel(histogramModel);
		
		histogramViewController.setHistogramModel(histogramModel);
		histogramViewController.setHistogramView(histogramView);
		
		histogramView.setController(histogramViewController);

		MainWindowView mainWindowView = new MainWindowViewImpl(histogramView);
		mainWindowView.setController(controller);

		histogramViewController.setMainWindowView(mainWindowView);
		controller.setMainWindowView(mainWindowView);
		controller.setHistogramView(histogramView);
	}

}
