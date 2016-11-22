package gui;

import controller.Controller;

public interface MainWindowView {
	public void reportError(String message);
	
	public void setController(Controller controller);
}
