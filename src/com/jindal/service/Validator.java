/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jindal.service;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author RUBAL GARG
 */
public class Validator {

    private javax.swing.JTextField floatField;
    private int flag = 0;
    private int bkSpace = 0;

    public static void integerValidation(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c))) 
        {
            evt.consume();
        }
    }

    public static void alphanumericIntegerValidation(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!((Character.isLetterOrDigit(c)) || c == '-')) {
            evt.consume();
        }
    }

    public static void doubleValidation(java.awt.event.KeyEvent evt,JTextField source) {
        char c = evt.getKeyChar();
        if (!((Character.isDigit(c)) || c == '.')) {
            evt.consume();
        }
        if(c=='.')
        {
            String textData =  source.getText();
            if(textData.contains(".")){
                evt.consume();
            }
        }
    }

    /**
     * Insert the method's description here. Creation date: (3/14/01 10:37:57
     * AM)
     *
     * @return boolean
     * @param str java.lang.String
     */
    public boolean isDot(String str) {
        int val = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                val = 1;
                break;
            }
        }
        if (val == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * keyPressed method comment.
     */
    public void keyPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == 8) {
            bkSpace = 1;
        }
    }

    /**
     * keyReleased method comment.
     */
    public void keyReleased(java.awt.event.KeyEvent e) {
        bkSpace = 0;
    }

    /**
     * keyTyped method comment.
     */
    public void keyTyped(java.awt.event.KeyEvent ke) {
        char c = ke.getKeyChar();
        String curVal = floatField.getText().trim();
// If '.' is encountered for the first time, the flag is incremented by 2.
        if (c == '.') {
            flag = flag + 2;
        }
        Character cc = new Character(c);
        // Get the Numeric Value from the Character and checking the condition for flag to be 1.
        if ((cc.getNumericValue(c) == -1) && (flag > 1)) {
            // Pass the value of the text as a String to the method isDot and if true (dot is already there),
            // if it is false (dot is not there) set the value back to 0 to allow the user to enter dot again.
            if (!(isDot(curVal))) {
                flag = 0;
            }
        }
        // This will allow the user to enter the numbers as well as dot.
        if (!(((c >= '0' && c <= '9')) || (c == '.') || bkSpace == 1)) {
            ke.consume();
        } else {
            // If the flag is greater than 1 then the dot is not allowed.
            if (flag > 1) {
                if ((c == '.')) {
                    ke.consume();
                }
            }
        }
    }

    /**
     * Insert the method's description here. Creation date: (3/14/01 10:41:14
     * AM)
     *
     * @param newFlag int
     */
    public void setFlag(int newFlag) {
        flag = newFlag;
    }

    /**
     * Insert the method's description here. Creation date: (3/15/01 9:51:56 AM)
     *
     * @param newFloatField javax.swing.JTextField
     */
    public void setFloatField(javax.swing.JTextField newFloatField) {
        floatField = newFloatField;
    }
}
