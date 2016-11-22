package lab04;

import controller.Controller;
import controller.impl.ControllerImpl;
import exceptions.ParametersNotCorrectException;
import exceptions.ParametersNotSetException;
import gui.HistogramView;
import gui.MainWindowView;
import gui.impl.HistogramViewImpl;
import gui.impl.MainWindowViewImpl;
import model.HistogramModel;
import model.HistogramModelImpl;

public class Main {
	/*
	 * Controllers will have to validate
	 * (nx < 0 | ny < 0 | xmin >= xmax | ymin >= ymax) - bad
	 */
	public static void main(String[] args) {
		// appConstruction
		
		HistogramModel histogramModel = new HistogramModelImpl();
		
		Controller controller = new ControllerImpl();
		controller.setHistogramModel(histogramModel);
		
		MainWindowView mainWindowView = new MainWindowViewImpl();
		mainWindowView.setController(controller);
		
		HistogramView histogramView = new HistogramViewImpl();
		histogramView.setHistogramModel(histogramModel);
		
		controller.setMainWindow(mainWindowView);
	}

}
