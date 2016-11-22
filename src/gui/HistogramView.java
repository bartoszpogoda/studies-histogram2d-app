package gui;

import model.HistogramModel;

public interface HistogramView {
	public void setHistogramModel(HistogramModel histogramModel);
	public void repaint();
}
