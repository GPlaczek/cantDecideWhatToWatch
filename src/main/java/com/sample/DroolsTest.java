package com.sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
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
}
