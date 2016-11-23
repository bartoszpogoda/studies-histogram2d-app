package gui;

import javax.swing.JPanel;

import model.HistogramModel;

public interface HistogramView {
	public void setHistogramModel(HistogramModel histogramModel);
	public JPanel getJPanel();
	public void repaint();
}
