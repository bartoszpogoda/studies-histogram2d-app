package gui.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.JPanel;

import controller.Controller;
import controller.HistogramViewController;
import exceptions.ParametersNotCorrectException;
import exceptions.ParametersNotSetException;
import gui.HistogramView;
import model.HistogramModel;

public class HistogramViewImpl extends JPanel implements HistogramView {

	private HistogramModel histogramModel;
	private boolean gridMode;

	public HistogramViewImpl() {
		gridMode = false;
	}

	@Override
	public void setHistogramModel(HistogramModel histogramModel) {
		this.histogramModel = histogramModel;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (histogramModel == null) {
			g.drawString("Model not found", 50, 50);
			return;
		}

		Graphics2D g2D = (Graphics2D) g;

		int width = this.getWidth();
		int height = this.getHeight();

		int histogramMaxValue = histogramModel.getHistogramMaxValue();

		if (histogramMaxValue == 0)
			return;

		int xStep = width / histogramModel.getNx();
		int yStep = height / histogramModel.getNy();

		int currentX = 0;

		for (int[] row : histogramModel.getHistogramValues()) {
			// 0 -> nx

			int currentY = height - yStep;
			for (int v : row) {
				int grayScaleValue = (int) (255 - ((float) v / histogramMaxValue) * 255);
				g2D.setColor(new Color(grayScaleValue, grayScaleValue, grayScaleValue));
				g2D.fillRect(currentX, currentY, xStep, yStep);
				currentY -= yStep;

			}

			currentX += xStep;
		}

		// grid
		if(gridMode){
			currentX = 0;

			g2D.setColor(Color.RED);
			for (int i = 0; i < histogramModel.getNx(); i++) {
				int currentY = height - yStep;
				for (int j = 0; j < histogramModel.getNy(); j++) {
					g2D.drawRect(currentX, currentY, xStep, yStep);
					currentY -= yStep;

				}

				currentX += xStep;
			}
		}
	}

	@Override
	public JPanel getJPanel() {
		return this;
	}

	@Override
	public void setGridMode(boolean mode) {
		this.gridMode = mode;
	}

	@Override
	public void setController(HistogramViewController controller) {
		this.addMouseListener(controller);
	}


}
