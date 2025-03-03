package lab3v1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class Simulator extends Frame {
	
	private Svemir svemir = new Svemir();
	private Generator generator = new Generator(svemir);
	
	public Simulator() {
		setBounds(700, 200, 200, 400);
		populateWindow();
		setResizable(false);
		setVisible(true);
	}

	private void populateWindow() {
		
		Panel bottomPanel = new Panel();
		
		Button pokreni = new Button("Pokreni!");
		
		pokreni.addActionListener((ae) -> {
			pokreni.setEnabled(false);
			generator.pokreni();
			svemir.pokreni();
		});
		
		bottomPanel.add(pokreni);
		
		add(svemir, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

	}
	
	public static void main(String[] args) {
		new Simulator();
	}
}
