package com.jindal.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class CustomButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3850394106818073907L;

	public CustomButton(String title) {
		super(title);
		setFont(new Font("Courier", Font.PLAIN,20));
		setBackground(Color.BLUE);
		setForeground(Color.WHITE);
		setFocusable(false);
		setBorder(null);
	}
	public CustomButton(String title,Font font,Color color) {
		super(title);
		setFont(font);
		setForeground(color);
		
	}
	

}
