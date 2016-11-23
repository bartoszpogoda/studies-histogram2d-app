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
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.MatteBorder;

import controller.Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.UIManager;
import javax.swing.JSlider;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class MainWindowViewImpl extends JFrame implements MainWindowView {
	private JButton btnReadFromFile, btnRedraw;
	private JTextField tfMinX, tfMaxX, tfMinY, tfMaxY, tfNx, tfNy;
	private JTextField tfFileName;
	private Component verticalStrut;
	private Component verticalStrut_1;
	
	public MainWindowViewImpl(HistogramView histogramView) {
		this.setTitle("Histogram2D - Bartosz Pogoda");
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
		actionPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Ustawienia", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.Y_AXIS));
		getContentPane().add(actionPanel, "2, 1, center, fill");
		
		tfMinX = new JTextField();
		tfMinX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfMinX.setMaximumSize(new Dimension(200,20));
		tfMaxX = new JTextField();
		tfMaxX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfMaxX.setMaximumSize(new Dimension(200,20));
		tfMinY = new JTextField();
		tfMinY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfMinY.setMaximumSize(new Dimension(200,20));
		tfMaxY = new JTextField();
		tfMaxY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfMaxY.setMaximumSize(new Dimension(200,20));
		tfNx = new JTextField();
		tfNx.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfNx.setMaximumSize(new Dimension(200,20));
		tfNy = new JTextField();
		tfNy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfNy.setMaximumSize(new Dimension(200,20));
		
		JLabel label = new JLabel("xmin");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setLabelFor(tfMinX);
		actionPanel.add(label);
		actionPanel.add(tfMinX);
		JLabel label_1 = new JLabel("xmax");
		label_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actionPanel.add(label_1);
		actionPanel.add(tfMaxX);
		JLabel label_2 = new JLabel("nx");
		label_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actionPanel.add(label_2);
		actionPanel.add(tfNx);
		JLabel label_3 = new JLabel("ymin");
		label_3.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actionPanel.add(label_3);
		actionPanel.add(tfMinY);
		JLabel label_4 = new JLabel("ymax");
		label_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actionPanel.add(label_4);
		actionPanel.add(tfMaxY);
		JLabel label_5 = new JLabel("ny");
		label_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actionPanel.add(label_5);
		actionPanel.add(tfNy);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		actionPanel.add(verticalStrut_1);
		

		btnRedraw = new JButton("Rysuj");
		btnRedraw.setBackground(Color.ORANGE);
		btnRedraw.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRedraw.setMaximumSize(new Dimension(300,100));
		btnRedraw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRedraw.setActionCommand("BTN_REDRAW");
		actionPanel.add(btnRedraw);
		
		verticalStrut = Box.createVerticalStrut(120);
		actionPanel.add(verticalStrut);

		
		JLabel label_6 = new JLabel("Nazwa pliku");
		label_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actionPanel.add(label_6);
		
		tfFileName = new JTextField();
		tfFileName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfFileName.setMaximumSize(new Dimension(200,20));

		actionPanel.add(tfFileName);
		btnReadFromFile = new JButton("Wczytaj");
		btnReadFromFile.setActionCommand("BTN_LOAD");
		btnReadFromFile.setBackground(Color.YELLOW);
		btnReadFromFile.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReadFromFile.setHorizontalAlignment(SwingConstants.TRAILING);
		btnReadFromFile.setMaximumSize(new Dimension(300, 50));
		btnRedraw.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReadFromFile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		actionPanel.add(btnReadFromFile);
		
		actionPanel.setBackground(Color.LIGHT_GRAY);
		
		this.setSize(800,600);
		this.setVisible(true);
	}

	@Override
	public void reportError(String message) {
		JOptionPane.showMessageDialog(this, message, "B³¹d", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void setController(Controller controller) {
		this.btnReadFromFile.addActionListener(controller);
		this.btnRedraw.addActionListener(controller);
		
	}

	@Override
	public String getXMin() {
		return tfMinX.getText();
	}

	@Override
	public String getXMax() {
		return tfMaxX.getText();
	}

	@Override
	public String getYMin() {
		return tfMinY.getText();
	}

	@Override
	public String getYMax() {
		return tfMaxY.getText();
	}

	@Override
	public String getNx() {
		return tfNx.getText();
	}

	@Override
	public String getNy() {
		return tfNy.getText();
	}

	@Override
	public String getFilename() {
		return tfFileName.getText();
	}

	@Override
	public void reportSuccess(String message) {
		JOptionPane.showMessageDialog(this, message, "Sukces", JOptionPane.DEFAULT_OPTION);
		
	}
	
}
