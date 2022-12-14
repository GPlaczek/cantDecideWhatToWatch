package com.sample;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieRuntime;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
    public static final void main(String[] args) {
    	JFrame f = new JFrame();
    	JButton b = new JButton("fire");
    	b.setBounds(130,100,100,40);
    	b.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			try {
    	            // load up the knowledge base
    		        KieServices ks = KieServices.Factory.get();
    	    	    KieContainer kContainer = ks.getKieClasspathContainer();
    	        	KieSession kSession = kContainer.newKieSession("ksession-rules");

    	            // go !
    	            kSession.fireAllRules();
    	        } catch (Throwable t) {
    	            t.printStackTrace();
    	        }
    		}
    	});
    	f.add(b);
    	f.setSize(400,500);
    	f.setLayout(null);
    	f.setVisible(true);
        
    }
    

    /*void recommend(JFrame frame, KieRuntime krt, String title) {
    	final JPanel panel = new JPanel();
    	panel.add( new JLabel(title) );
    	JOptionPane.showMessageDialog(frame, panel);	
    }	
    

    Pytanie zapytaj(JFrame frame, KieRuntime krt, String question, ArrayList answers) {

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
    
    
    public class Pytanie {
    	String trescPytania;
    	String odpowiedz;
    	public Pytanie(String trescPytania, String odpowiedz) {
    		this.trescPytania = trescPytania;
    		this.odpowiedz = odpowiedz;
    	}
    	void setOdpowiedz(String odpowiedz) {
    		this.odpowiedz = odpowiedz;
    	}
    }
   */
}


