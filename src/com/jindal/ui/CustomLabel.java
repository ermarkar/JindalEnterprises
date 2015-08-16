package com.jindal.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class CustomLabel extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 380959340783064626L;

	public CustomLabel(String title) {
		super(title);
		setFont(new Font("Courier", Font.PLAIN,20));
		setBackground(Color.green);
		
	}
	public CustomLabel(String title,int fontSize) {
		super(title);
		setFont(new Font("Courier", Font.PLAIN,fontSize));
		setBackground(Color.green);
		
	}
        public CustomLabel(String title,Font font,Color color) {
		super(title);
		setFont(font);
		setForeground(color);
		
	}
	

}
