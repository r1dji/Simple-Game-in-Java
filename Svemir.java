package lab3v1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Svemir extends Canvas implements Runnable {
	
	private Thread nit;
	
	private LinkedList<NebeskoTelo> nebeskaTela = new LinkedList<>();
	
	public Svemir() {
		setBackground(Color.BLACK);
		if (nit == null) {
			nit = new Thread(this);
		}
		
	}
	
	public synchronized void dodaj(NebeskoTelo nt) {
		nebeskaTela.add(nt);
	}
	
	private void crtajFigure() {
		for (int i = 0; i < nebeskaTela.size(); i++) {
			nebeskaTela.get(i).crtaj(getGraphics());
		}
	}
	
	private void pomeriFigure() {
		for (int i = 0; i < nebeskaTela.size(); i++) {
			nebeskaTela.get(i).pomeriY(5);
		}
	}
	
	@Override
	public void run() {
		try {
			while (!(nit.interrupted())) {
				nit.sleep(100);
				if (nit.interrupted()) {
					break;
				}
				synchronized (this) {
					while (nebeskaTela.size() < 1) {
						this.wait();
					}
					pomeriFigure();
					repaint();
				}
			}
			
		}catch(InterruptedException e) {}	
	}
	
	@Override
	public synchronized void paint(Graphics g) {
		crtajFigure();	
	}
	
	public void pokreni() {	
		if (nit == null) {
			nit = new Thread(this);
		}
		nit.start();
	}
	
	public void zaustavi() {
		if (nit != null) {
			nit.interrupt();
		}
	}
}
