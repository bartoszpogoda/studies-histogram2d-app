package gui;

import java.util.List;

import controller.Controller;
import dom.Point;
import exceptions.ParametersNotSetException;

public interface MainWindowView {
	public void reportError(String message);
	public void reportSuccess(String message);
	
	public void setController(Controller controller);
	
	public String getXMin();
	public String getXMax();
	public String getYMin();
	public String getYMax();
	public String getNx();
	public String getNy();
	
	public String getFilename();
	
}
