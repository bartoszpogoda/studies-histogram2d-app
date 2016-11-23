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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class MainWindowViewImpl extends JFrame implements MainWindowView {
	private JButton btnReadFromFile, btnRedraw;
	
	public MainWindowViewImpl(HistogramView histogramView) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("500px:grow"),
				ColumnSpec.decode("100px"),},
			new RowSpec[] {
				RowSpec.decode("500px:grow"),
				RowSpec.decode("1px"),}));
		
		JPanel histogramPanel = histogramView.getJPanel();
		getContentPane().add(histogramPanel, "1, 1, fill, fill");
		
		JPanel actionPanel = new JPanel();
		
		getContentPane().add(actionPanel, "2, 1, fill, fill");
		
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
