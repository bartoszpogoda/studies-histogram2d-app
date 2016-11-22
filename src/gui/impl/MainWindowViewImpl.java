package gui.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import exceptions.ParametersNotCorrectException;
import exceptions.ParametersNotSetException;
import gui.MainWindowView;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import controller.Controller;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.UIManager;
import javax.swing.JSlider;
import java.awt.Font;

public class MainWindowViewImpl extends JFrame implements MainWindowView {

	@Override
	public void reportError(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(Controller controller) {
		// TODO Auto-generated method stub
		
	}
	
}
