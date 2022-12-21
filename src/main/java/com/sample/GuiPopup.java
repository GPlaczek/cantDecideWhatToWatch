package com.sample;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class GuiPopup {
	private String question;
	private ArrayList<String> answers;
	private String answer;
	private static JFrame mainFrame;
	
	public GuiPopup(String question, ArrayList<String> answers) {
		this.question = question;
		this.answers = answers;
		if (!this.answers.isEmpty()) { this.answer = this.answers.get(0); }
		if (GuiPopup.mainFrame != null) {
			GuiPopup.mainFrame = new JFrame();
			GuiPopup.mainFrame.setSize(400,500);
	    	GuiPopup.mainFrame.setLayout(null);
	    	GuiPopup.mainFrame.setVisible(true);
		}
	}
	
	public String ask() {
		JPanel p = new JPanel(new GridLayout(0, 1));
		p.add(new JLabel(this.question));
		
		ButtonGroup g = new ButtonGroup();
		boolean sel = false;
		for(String i : answers) {
			JRadioButton rb = new JRadioButton(i);
			rb.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					if (arg0.getStateChange() == ItemEvent.SELECTED) {
						answer = i;
					}
				}
			});
			if (!sel) {
				rb.setSelected(true);
				sel = true;
			}
			g.add(rb);
			p.add(rb);
		}
		if ((JOptionPane.showConfirmDialog(GuiPopup.mainFrame, p, "Question", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE)) < 0) {
			return "nope";
		} else {
			return this.answer;

		}
	}
}
