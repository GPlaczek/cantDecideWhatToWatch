package com.sample;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.kie.api.runtime.KieRuntime;

public class Gui {
	
	public static class Pytanie {
		public String trescPytania;
		public String odpowiedz;
		public Pytanie(String trescPytania, String odpowiedz) {
			this.trescPytania = trescPytania;
			this.odpowiedz = odpowiedz;
		}
		void setOdpowiedz(String odpowiedz) {
			this.odpowiedz = odpowiedz;
		}
		String getOdpowiedz() {
			return this.odpowiedz;
		}
		void setTrescPytania(String trescPytania) {
			this.trescPytania = trescPytania;
		}
		String getTrescPytania() {
			return this.trescPytania;
		}
		public static Pytanie zapytaj(JFrame frame, KieRuntime krt, String question, ArrayList answers) {

		    class Listener implements ItemListener {
		        public Pytanie answers;
		        public String chosen;
		        public Listener(Pytanie answer, String chosen) {
		            this.answers = answer;
		            this.chosen = chosen;
		        }

		        @Override
		        public void itemStateChanged(ItemEvent event) {
		            if (event.getStateChange() == ItemEvent.SELECTED) {
		                answers.setOdpowiedz(chosen);
		            }
		        }
		    }
		    Pytanie response = new Pytanie(question, answers.get(0).toString());

		    final JPanel panel = new JPanel(new GridLayout(0, 1));
		    panel.add(new JLabel(question));

		    ArrayList<JRadioButton> buttons = new ArrayList<>();

		    for (int i = 0; i < answers.size(); i++) {
		        String text = answers.get(i).toString();
		        JRadioButton radioButton = new JRadioButton(text);
		        Listener newListener = new Listener(response, text);
		        radioButton.addItemListener(newListener);
		        buttons.add(radioButton);
		    }

		    buttons.get(0).setSelected(true);
		    response.setOdpowiedz(answers.get(0).toString());

		    ButtonGroup group = new ButtonGroup();

		    for (int i = 0; i < buttons.size(); i++) {
		        group.add(buttons.get(i));
		        panel.add(buttons.get(i));
		    }

		    if (JOptionPane.showConfirmDialog(frame, panel, "Question", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE) < 0) {
		        response.setOdpowiedz("Exit program");
		    }

		    return response;
		}
	}
	
	public void recommend(JFrame frame, KieRuntime krt, String title) {
		final JPanel panel = new JPanel();
		panel.add( new JLabel(title) );
		JOptionPane.showMessageDialog(frame, panel);	
	}	

}
