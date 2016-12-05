package gui;

import javax.swing.JPanel;

import controller.Controller;
import controller.HistogramViewController;
import model.HistogramModel;

public interface HistogramView {
	public void setHistogramModel(HistogramModel histogramModel);
	public void setController(HistogramViewController controller);
	
	public JPanel getJPanel();
	public void repaint();
	
	public int getWidth();
	public int getHeight();
	
	public void setGridMode(boolean mode);
}
