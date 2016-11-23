package gui.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import exceptions.ParametersNotCorrectException;
import exceptions.ParametersNotSetException;
import gui.HistogramView;
import gui.MainWindowView;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.MatteBorder;

import controller.Controller;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.UIManager;
import javax.swing.JSlider;
import java.awt.Font;

public class MainWindowViewImpl extends JFrame implements MainWindowView {
	private JButton btnReadFromFile, btnRedraw;
	
	public MainWindowViewImpl(HistogramView histogramView) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new GridBagLayout());
		
		//panel
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.7;
		c.gridwidth = 2;
		c.gridheight = 1;
		
		this.add(histogramView.getJPanel(), c);
		
		GridBagConstraints d = new GridBagConstraints();
		d.fill = GridBagConstraints.BOTH;
		d.gridx = 2;
		d.gridy = 0;
		d.weightx = 0.5;
		d.gridwidth = 1;
		d.gridheight = 1;
		
		JPanel actionPanel = new JPanel();
		
		this.add(actionPanel, d);
		
		btnReadFromFile = new JButton("Wczytaj...");
		btnRedraw = new JButton("Przerysuj");
		
		actionPanel.add(btnReadFromFile);
		actionPanel.add(btnRedraw);
		
		actionPanel.setBackground(new Color(111,123,222));
		
		this.setSize(800,600);
		this.setVisible(true);
	}

	@Override
	public void reportError(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(Controller controller) {
		// TODO Auto-generated method stub
		
	}
	
}
